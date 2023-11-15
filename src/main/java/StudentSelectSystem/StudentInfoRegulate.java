package StudentSelectSystem;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentInfoRegulate {
   static Scanner sc=new Scanner(System.in);
    public static void operateMenu()
    {
        while(true)
        {
            System.out.println("学生信息管理");
            System.out.println("---------------------------------------------");
            System.out.println("学生信息添加————————1");
            System.out.println("学生信息修改————————2");
            System.out.println("学生信息删除————————3");
            System.out.println("学生信息查询————————4");
            System.out.println("退出———————————————0");
            int option= CheckType.CheckInt();
            if(option==1)
            {
                try {
                    addStudent();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("添加失败，请重新添加!");
                    continue;
                }
            }
            else if(option==2)
            {  try {
                modify();
            }catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("修改失败,请重新修改!");
                continue;
            }

            } else if (option==3) {
                try {
                    delete();
                }
               catch (Exception e)
               {
                   e.printStackTrace();
                   System.out.println("删除失败,请重新删除!");
                   continue;
               }
            } else if (option==4) {
                try {
                    search();
                }catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("查询失败,请重新查询!");
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
    public static void addStudent()throws Exception{
        System.out.println("请输入学生姓名,专业（英文,隔开）");
        String[] s=sc.next().split(",");
        String name=s[0];
        String major=s[1];
        Student t=new Student(0,name,major);
        StudentDatabaseOperate.insertInfo(t);
        printStudentInfo(StudentDatabaseOperate.seekStudent(""));
    }

    public static void delete()
    {
        System.out.println("请输入要删除的学生编号:");
        int no=CheckType.CheckInt();
        Student t=StudentDatabaseOperate.getOneStudent(no);
        if(t!=null){
            StudentDatabaseOperate.delete(no);
        }
        printStudentInfo(StudentDatabaseOperate.seekStudent(""));
    }
    public static void modify()
    {
        System.out.println("请输入学生的编号:");
        int no=CheckType.CheckInt();
        Student t=StudentDatabaseOperate.getOneStudent(no);
        if(t==null){
            System.out.println("学生不存在!");
        }else{
            System.out.println("请输入学生姓名,专业（,隔开）");
            String[] s=sc.next().split(",");
            String name=s[0];
            String major=s[1];
            t.setName(name);
            t.setMajor(major);
            try {
                StudentDatabaseOperate.update(t);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("更新失败!");
            }

              printStudentInfo(StudentDatabaseOperate.seekStudent(""));
        }






    }
    public static void search()
    {
        String key;
        System.out.println("请输入查询条件:");//输入回车查询所有;
        key=sc.nextLine();
        printStudentInfo(StudentDatabaseOperate.seekStudent(key));

    }
    public static void printStudentInfo(List<Student> results)
    {
        System.out.println("编号\t\t姓名\t\t专业");
        System.out.println("-----------------------------------------");
        if(results.size()>0)
        {
            Iterator<Student> it=results.iterator();
            while(it.hasNext()){
                Student s=it.next();
                System.out.println(s);
            }
        }
        else {
            System.out.println("没有学生信息!!");
        }
        System.out.println("-----------------------------------------");

















    }











}
