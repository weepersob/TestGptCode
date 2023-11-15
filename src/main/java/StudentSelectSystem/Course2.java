package StudentSelectSystem;

import java.util.Scanner;

public class Course2 {
    private int  CID;
    private String CNAME;


    private double CSCORE;

    public Course2() {
    }

    public Course2(int no, String name, double score) {
        this. CID = no;
        this.CNAME = name;
        this.CSCORE = score;
    }

    /**
     * 获取
     * @return no
     */
    public int getNo() {
        return  CID;
    }

    /**
     * 设置
     * @param no
     */
    public void setNo(int no) {
        this. CID = no;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return CNAME;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.CNAME = name;
    }

    /**
     * 获取
     * @return score
     */
    public double getScore() {
        return CSCORE;
    }

    /**
     * 设置
     * @param score
     */
    public void setScore(double score) {
        this.CSCORE = score;
    }

    public String toString() {
        return "{CID = " +  CID + ", CNAME = " + CNAME + ", CSCORE = " + CSCORE + "}";
    }
}
