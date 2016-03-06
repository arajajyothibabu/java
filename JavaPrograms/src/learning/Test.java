package learning;

/**
 * Created by Araja Jyothi Babu on 25-02-2016.
 */
public class Test implements AAA{
    private static final int id = 5;
    long add(int a, long b){
        return a + b;
    }
    long add(long a, int b){
        return a + b;
    }
    public static void main(String args[]) throws Exception{
        int a = 10, b = 20;
        Test test = new Test();
        //System.out.println(test.add(a,b));
        A obj = new B();
        byte  x =  5;
        obj.display(x);
    }
    public void m1(){

    }
    public void m2(){
        
    }
}
abstract class AA{

}
interface AAA{
    void m1();
    abstract void m2();
}
