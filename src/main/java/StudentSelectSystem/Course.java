package StudentSelectSystem;



import java.util.Scanner;

public class Course {
    private int no;
    static int count=0;
    private String name;
    Scanner sc=new Scanner(System.in);
    private double score;

    public Course() throws Exception{
        System.out.println("输入课程名称:");
        String name=sc.next();
        System.out.println("请输入课程学分:");
        double score= CheckType.CheckDouble();
        count++;
        this.name=name;
        this.score=score;
        this.no=count;
    }

    public Course(int no, String name, double score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public String toString() {
        return this.no+"\t\t"+this.name+"\t\t"+this.score;
    }

}
