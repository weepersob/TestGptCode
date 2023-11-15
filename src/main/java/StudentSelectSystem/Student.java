package StudentSelectSystem;

import java.util.Scanner;

public class Student {
    static int count=0;
    private String name;
    private int no;
    private String major;
    Scanner sc=new Scanner(System.in);
    public Student(int no, String name, String major) {
        this.name = name;
        this.no = no;
        this.major = major;
    }
    public Student()
    {
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String toString() {
        return this.no+"\t\t"+this.name+"\t\t"+this.major;
    }
}
