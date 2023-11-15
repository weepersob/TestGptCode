package StudentSelectSystem;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;


import java.util.List;
import java.util.Scanner;

public class CourseGovern {
    static Scanner sc=new Scanner(System.in);
    public static void courseOperate()
    {
        while(true)
        {
            System.out.println("课程信息管理");
            System.out.println("----------------------------------------------");
            System.out.println("课程信息添加————————1");
            System.out.println("课程信息修改————————2");
            System.out.println("课程信息删除————————3");
            System.out.println("课程信息查询————————4");
            System.out.println("退出———————————————0");
            int option= CheckType.CheckInt();
            if(option==1)
            {
                try {
                    addCourse();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("课程添加失败，请重新添加!");
                    continue;
                }
            }
            else if(option==2)
            {  try {
                courseModify();
            }catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("课程修改失败,请重新修改!");
                continue;
            }

            } else if (option==3) {
                try {
                    courseDelete();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("课程删除失败,请重新删除!");
                    continue;
                }
            } else if (option==4) {
                try {
                   courseSearch();
                }catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("课程查询失败,请重新查询!");
                    continue;
                }

            } else if (option==0) {
                break;
            }else{
                System.out.println("请输入0-4之间的数字!");
                continue;
            }

        }
    }
    public static void addCourse()throws Exception
    {
        System.out.println("输入课程名称,学分(英文,号隔开)");
        String [] t=sc.next().split(",");
        Course cu=new Course(0,t[0],Double.parseDouble(t[1]));
      CourseDatabaseOperate.insertCourse(cu);
      printCourseInfo(CourseDatabaseOperate.seekCourse(""));

    }
    public static List<Course2> addCourseAPI(String name,double score)throws Exception
    {

        Course cu=new Course(0,name,score);
        CourseDatabaseOperate.insertCourse(cu);
       // printCourseInfo(CourseDatabaseOperate.seekCourse(""));
        return CourseDatabaseOperate.seekCourseApi();
    }
    public static void courseModify()
    {
        System.out.println("请输入课程编号:");
        int no=CheckType.CheckInt();
        Course v=CourseDatabaseOperate.getOneCourse(no);
        if(v==null){
            System.out.println("没有这个课程!");
        }else{

            System.out.println("请输入课程名称,学分,(,号隔开)");
            String [] t=sc.next().split(",");
            Course b=new Course(v.getNo(),t[0],Double.parseDouble(t[1]));
            CourseDatabaseOperate.updateCourse(b);
            printCourseInfo(CourseDatabaseOperate.seekCourse(""));
        }




    }
    public static void courseDelete()
    {
        System.out.println("请输入课程编号:");
     int no=CheckType.CheckInt();
     Course t=CourseDatabaseOperate.getOneCourse(no);
     if(t==null)
     {
         System.out.println("没有这个课程!");
     }else{

         CourseDatabaseOperate.deleteCourseData(no);
     }
      printCourseInfo(CourseDatabaseOperate.seekCourse(""));
    }
    public static void courseSearch()
    {
        System.out.println("请输入查询条件");
        Scanner r=new Scanner(System.in);
        String key=r.nextLine();
        printCourseInfo(CourseDatabaseOperate.seekCourse(key));
    }
    public static void printCourseInfo(List<Course> c){
        System.out.println("编号\t\t课程\t\t学分");
        System.out.println("-----------------------------------------");
        if (c.size()>0)
        {
            for (Course course : c) {
                System.out.println(course);
            }

        }else{
            System.out.println("没有课程信息!!");
        }
        System.out.println("-----------------------------------------");

    }

}
