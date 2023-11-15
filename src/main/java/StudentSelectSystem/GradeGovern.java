package StudentSelectSystem;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeGovern {

    static Scanner sc=new Scanner(System.in);
    public static void studentSelectCourse()throws Exception
    {
        System.out.println("请输入学号:");
        int stuNo= CheckType.CheckInt();
        Student s=StudentDatabaseOperate.getOneStudent(stuNo);
        if(s!=null)
        {
            while(true)
            {
                System.out.println(s);
                System.out.println("-----------------已选课程-----------------");
                List<Course> selectCourse=GradeDatabaseOperate.findCourseSelectByStudent(s,true);
                CourseGovern.printCourseInfo(selectCourse);
                System.out.println("----------------------------------------------------------");
                System.out.println("-----------------未选课程-----------------");
                List<Course> noSelect=GradeDatabaseOperate.findCourseSelectByStudent(s,false);
                CourseGovern.printCourseInfo(noSelect);
                System.out.println("----------------------------------------------------------");
                System.out.println("输入课程编号:-1————退出");
                int courseNo=CheckType.CheckInt();
                if(courseNo==-1)break;
                Course c=CourseDatabaseOperate.getOneCourse(courseNo);
                if(c!=null)
                {
                    Grade g=GradeDatabaseOperate.getOneByStuAndCourse(s,c);
                    if(g!=null){
                        System.out.println("该课程已经被选择");
                    }else{
                        Grade gra=new Grade();
                        gra.setCourse(c);
                        gra.setStudent(s);
                        GradeDatabaseOperate.insert(gra);
                    }
                }
                else{
                    System.out.println("没有这门课!");
                }
            }
        }
else{
    System.out.println("没有这个学生!");
        }
    }





    public static List<TempInfo> webCoursePageGet(int no,String name,int way)throws Exception {
        List<TempInfo> T = new ArrayList<>();
        int stuNo = no;
        Student s = StudentDatabaseOperate.getOneStudentApi(stuNo,name);
        if (s != null) {
           // while (true) {
             //   System.out.println(s);
            List<Course> selectCourse;
                System.out.println("-----------------已选课程-----------------");
               if(way==1){selectCourse = GradeDatabaseOperate.findCourseSelectByStudent(s, true);}
               else selectCourse=GradeDatabaseOperate.findCourseSelectByStudent(s,false);
                for (Course c : selectCourse) {
                    TempInfo t = new TempInfo();
                    t.setCourseNo(c.getNo());
                    t.setCourseName(c.getName());
                    t.setCourseMark(c.getScore());
                    t.setName(s.getName());
                    t.setMajor(s.getMajor());
                    T.add(t);
                }

            //}
       /*         CourseGovern.printCourseInfo(selectCourse);

                System.out.println("----------------------------------------------------------");
                System.out.println("-----------------未选课程-----------------");
                List<Course> noSelect=GradeDatabaseOperate.findCourseSelectByStudent(s,false);
                CourseGovern.printCourseInfo(noSelect);
                System.out.println("----------------------------------------------------------");
                System.out.println("输入课程编号:-1————退出");
                int courseNo=CheckType.CheckInt();
                if(courseNo==-1)break;
                Course c=CourseDatabaseOperate.getOneCourse(courseNo);
                if(c!=null)
                {
                    Grade g=GradeDatabaseOperate.getOneByStuAndCourse(s,c);
                    if(g!=null){
                        System.out.println("该课程已经被选择");
                    }else{
                        Grade gra=new Grade();
                        gra.setCourse(c);
                        gra.setStudent(s);
                        GradeDatabaseOperate.insert(gra);
                    }
                }
                else{
                    System.out.println("没有这门课!");
                }
            }
        }
        else{
            System.out.println("没有这个学生!");
        }*/

        }else T=null;
        return T;

    }























    public static void inputGrade()throws Exception{
        CourseGovern.printCourseInfo(CourseDatabaseOperate.seekCourse(""));
        System.out.println("输入课程编号");
        int courseNo=CheckType.CheckInt();
        Course c=CourseDatabaseOperate.getOneCourse(courseNo);
        if (c != null) {

            // 显示课程的所有成绩记录

            while (true) {

                List<Grade> grades = GradeDatabaseOperate.findGradesByCourse(c);

                printCourseGrade(c, grades);

                System.out.println("请输入学生编号:，-1退出");

                int stuNo = CheckType.CheckInt();

                if (stuNo==-1) {

                    break;

                } else {

                    Student stu = StudentDatabaseOperate.getOneStudent(stuNo);

                    if (stu != null) {
                        Grade g = GradeDatabaseOperate.getOneByStuAndCourse(stu, c);

                        if (g != null) {

                            System.out.println("输入" + stu.getName() + "的成绩：");

                            double m = CheckType.CheckDouble();

                           GradeDatabaseOperate.updateGrade(m, g.getId());

                        } else {

                            System.out.println(stu.getName() + "没有选这门课！");

                        }

                    } else {

                        System.out.println("没有这个学生！");

                    }

                }

            }



        } else {

            System.out.println("没有这门课程");

        }






    }


    public static void printStudentGrade(Student s,List<Grade> results){
        System.out.println("学生:"+s.getName());
        System.out.println("课程编号\t\t课程名称\t\t成绩");
        System.out.println("----------------------------------------------");
        double sum=0;
        for(Grade g:results)
        {
            System.out.println(g.getCourse().getNo() + "\t\t" + g.getCourse().getName() + "\t\t" + g.getGrade());

            if(g.getGrade()>=60) {

                sum=sum+g.getCourse().getScore();

            }

        }
        System.out.println("已修学分："+sum);
        System.out.println("----------------------------------------");



    }
    public static void printCourseGrade(Course c, List<Grade> results) {

        System.out.println("课程：" + c.getName());

        System.out.println("学号\t\t学生名字\t\t成绩");

        System.out.println("----------------------------------------");

        for (Grade g : results) {

            System.out.println(g.getStudent().getNo() + "\t\t" + g.getStudent().getName() + "\t\t" + g.getGrade());

        }

        System.out.println("----------------------------------------");

    }

    public static void queryGradeByStudent() throws Exception{

        System.out.println("请输入学号：");

        int stuNo=CheckType.CheckInt();

        Student s=StudentDatabaseOperate.getOneStudent(stuNo);

        if(s!=null) {

            List<Grade> grades=GradeDatabaseOperate.findGradesByStudent(s);

            printStudentGrade(s,grades);

        }else {

            System.out.println("没有这个学生！！");

        }

    }


    public static void gradeMenu() {

        while (true) {

            try {

                System.out.println("成绩管理");

                System.out.println("-------------------------");

                System.out.println("1————学生选课");

                System.out.println("2————老师录入成绩");

                System.out.println("3————成绩查询");

                System.out.println("0————退出");

                int s = CheckType.CheckInt();

                if (s == 1) {

                   studentSelectCourse ();

                } else if (s == 0) {

                    break;

                }else if(s==2) {

                    inputGrade();

                }else if(s==3) {

                    queryGradeByStudent();

                }

            }catch (Exception e) {

                // TODO: handle exception

                System.out.println("输入有误，请重新输入！！");

            }



        }



    }

}







