import java.util.Scanner;

public class CheckType {
    public static Scanner sc=new Scanner(System.in);
    public static int CheckInt()
    {  int value;
        while(!sc.hasNextInt())
        {
            System.out.println("请输入整数！");
            sc.next();
        }
        value=sc.nextInt();
        return value;
    }
    public static double CheckDouble()
    {  double value;
        while(!sc.hasNextDouble())
        {
            System.out.println("请输入数字！");
            sc.next();
        }
        value=sc.nextDouble();
        return value;
    }
}
