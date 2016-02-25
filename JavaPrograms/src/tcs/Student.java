package tcs;

/**
 * Created by Araja Jyothi Babu on 25-02-2016.
 */
public class Student {
    private String id;
    private String name;
    private String branch;
    Student(String id, String name, String branch){
        this.id = id;
        this.name = name;
        this.branch = branch;
    }
    String getId(){
        return this.id;
    }
    void setId(String id){
        this.id = id;
    }
    String getName(){
        return this.name;
    }
    void setName(String name){
        this.name = name;
    }
    String getBranch(){
        return this.branch;
    }
    void setBranch(String branch){
        this.branch = branch;
    }
}
