package com.dmdw.fpgrowth;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;

class FPGrowth
{
    static int minSupportCount, numberOfItems;
    static Node root = new Node('0');
    public FPGrowth(int numberOfItems)
    {
        this.numberOfItems = numberOfItems;
        minSupportCount = 2;
    }
    public static Node insertNode(Node node,char name)
    {
        Node newNode;
        int i =0;
        for (i = 0; i < node.children.size(); i++)
        {
            if(node.children.get(i).name == name)
            {
                newNode = node.children.get(i);
                newNode.supportCount++;
                return newNode;
            }
        }
        node.children.add(new Node(name));
        newNode = node.children.get(i);
        return newNode;
    }
    public static void traversal(Node node)
    {
        Node temp;
        for (int i = 0; i < node.children.size(); i++)
        {
            temp = node.children.get(i);
            System.out.println(">>> " + temp.name + "\t:" + temp.supportCount);
            traversal(temp);
        }
        System.out.println("----------");
    }
    static void generateTree()
    {
        Connection con = null;
        Statement st = null;
        ResultSet itemCount = null, itemSetResult = null;
        int items[] =  new int[9], temp = 0;
        Map<String,Integer> map = new TreeMap<String,Integer>();
        StringBuffer sortedSet = new StringBuffer(""), itemSet = new StringBuffer("");
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:jbdb","system","tiger");
            st = con.createStatement();
            System.out.println("Frequent-1-ItemSet");
            for(int number = 1;number <= numberOfItems;number++)
            {
                itemCount = st.executeQuery("select count(*) from apr where list like '%"+(char)(number+48)+"%'");
                if(itemCount.next())
                {
                    temp = itemCount.getInt(1);
                    map.put(String.valueOf((char)(number+48)), temp);
                    System.out.println(">> "+ number + "\t" + temp );
                }
            }
            Set<Entry<String, Integer>> set = map.entrySet(); //creating a Set
            List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set); //Making set of elements into List
            Collections.sort( list, new Comparator<Map.Entry<String, Integer>>() //sorting according to values in map
            {
                public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
                {
                    return (o2.getValue()).compareTo( o1.getValue() );
                }
            });
            for(Map.Entry<String, Integer> entry:list){
                sortedSet.append(entry.getKey());
            }
            System.out.println("Ordered Items according to supportCount: "+sortedSet);
            Node node;
            itemSetResult = st.executeQuery("select list from apr");
            while(itemSetResult.next())
            {
                node = root;
                itemSet.append(itemSetResult.getString(1));
                //System.out.println(">>"+ itemSet);
                for(int i=0;i < sortedSet.length();i++)
                    for(int j=0;j < itemSet.length();j++)
                        if(sortedSet.charAt(i) == itemSet.charAt(j))
                            node = insertNode(node,sortedSet.charAt(i));
                itemSet.setLength(0);
            }
            System.out.println("Nodes of Generated Tree:\n----------");
            traversal(root);
        }
        catch(Exception e) {
            System.out.println("Error: "+ e );
        }
    }
    public static void main(String args[])
    {
        FPGrowth fp = new FPGrowth(5);
        fp.generateTree();
    }
}