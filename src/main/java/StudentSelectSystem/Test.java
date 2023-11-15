package StudentSelectSystem;



public class Test {
    public  static void mobilize()
    {
        int op=0;
        while(true)
        {
            System.out.println("学生成绩信息与选课系统");
            System.out.println("-----------------------------------");
            System.out.println("1————————学生信息管理");
            System.out.println("2————————课程信息管理");
            System.out.println("3————————成绩管理");
            System.out.println("0————————退出");
            op= CheckType.CheckInt();
            if(op==1){
                StudentInfoRegulate.operateMenu();
            } else if (op==2) {

                CourseGovern.courseOperate();
            } else if (op==3) {
                GradeGovern.gradeMenu();
            } else if (op==0) {
                break;
            } else{
                System.out.println("请输入0-3的数字");
                continue;
            }

        }
    }


    public static void main(String[] args) {
        int op=0;
        while(true)
        {
            System.out.println("学生成绩信息与选课系统");
            System.out.println("-----------------------------------");
            System.out.println("1————————学生信息管理");
            System.out.println("2————————课程信息管理");
            System.out.println("3————————成绩管理");
            System.out.println("0————————退出");
            op= CheckType.CheckInt();
            if(op==1){
              StudentInfoRegulate.operateMenu();
            } else if (op==2) {

                CourseGovern.courseOperate();
            } else if (op==3) {
        GradeGovern.gradeMenu();
            } else if (op==0) {
                break;
            } else{
                System.out.println("请输入0-3的数字");
                continue;
            }

        }
    }

       // System.out.println(GradeDatabaseOperate.getSelectAll("语文"));
}
