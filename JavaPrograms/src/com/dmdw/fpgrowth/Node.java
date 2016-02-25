package com.dmdw.fpgrowth;

/**
 * Created by Araja Jyothi Babu on 25-02-2016.
 */
import java.util.*;

class Node
{
    int supportCount = 0;
    char name;
    Node(char name)
    {
        this.supportCount++;
        this.name = name;
    }
    List<Node> children =  new ArrayList<Node>();
}
