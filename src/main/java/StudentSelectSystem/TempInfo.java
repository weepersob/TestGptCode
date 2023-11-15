package StudentSelectSystem;

public class TempInfo {
    private String name;
    private String major;
    private int CourseNo;
    private  String CourseName;
    private double CourseMark;

    public TempInfo() {
    }

    public TempInfo(String name, String major, int CourseNo, String CourseName, double CourseMark) {
        this.name = name;
        this.major = major;
        this.CourseNo = CourseNo;
        this.CourseName = CourseName;
        this.CourseMark = CourseMark;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取
     * @return CourseNo
     */
    public int getCourseNo() {
        return CourseNo;
    }

    /**
     * 设置
     * @param CourseNo
     */
    public void setCourseNo(int CourseNo) {
        this.CourseNo = CourseNo;
    }

    /**
     * 获取
     * @return CourseName
     */
    public String getCourseName() {
        return CourseName;
    }

    /**
     * 设置
     * @param CourseName
     */
    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    /**
     * 获取
     * @return CourseMark
     */
    public double getCourseMark() {
        return CourseMark;
    }

    /**
     * 设置
     * @param CourseMark
     */
    public void setCourseMark(double CourseMark) {
        this.CourseMark = CourseMark;
    }

    public String toString() {
        return "{name = " + name + ", major = " + major + ", CourseNo = " + CourseNo + ", CourseName = " + CourseName + ", CourseMark = " + CourseMark + "}";
    }
}
