package StudentSelectSystem;

public class Grade {
    private Student student;
    private Course course;
    private double grade;
    private int id;
    public void setId(int no){this.id=no;}
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
  public int getId(){return id;}
}
