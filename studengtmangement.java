import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class studengtmangement {
    public static void main(String[] args) {
        ArrayList<student> array = new ArrayList<student>();
        while(true) {
            System.out.println("--------欢迎来到学生管理系统-------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    addstudent(array);
                    break;
                case "2":
                    System.out.println("删除学生");
                    break;
                case "3":
                    System.out.println("修改学生");
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //break;
                    System.exit(0);
            }
        }
    }
    public static void addstudent(ArrayList<student> array)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生学号");
        String sid=sc.nextLine();
        System.out.println("请输入学生姓名");
        String name=sc.nextLine();
        System.out.println("请输入学生年龄");
        String age=sc.nextLine();
        System.out.println("请输入学生地址");
        String address=sc.nextLine();
        student s=new student(sid,name,age,address);
        array.add(s);
        System.out.println("添加成功");


    }
}
