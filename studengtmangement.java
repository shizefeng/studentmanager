import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class studengtmangement {
    public static void main(String[] args) {
        //定义一个student对象集合
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
                    //System.out.println("删除学生");
                    deletestudent(array);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    changestudent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findallstudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    //break;
                    System.exit(0);//退出该循环，结束进程
            }
        }
    }
    //添加学生  注意：当学号被占用时
    public static void addstudent(ArrayList<student> array)
    {
        Scanner sc=new Scanner(System.in);
        String sid;
        while(true)
        {
        System.out.println("请输入学生学号");
        sid=sc.nextLine();
        boolean flag=isused(array,sid);
        if(flag)
        {
            System.out.println("该学号已被占用，请重新输入");
        }
        else
        {
            break;//如果没有重复，则继续往下进行
        }
        }
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
    //查看所有学生
    public static void findallstudent(ArrayList<student> array)
    {
        if(array.size()==0)
        {
            System.out.println("无信息，请先添加再查询");
            return;//为了让程序不在往下执行
        }
        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for(int i=0;i<array.size();i++)
        {
            student s=array.get(i);
            System.out.println(s.getSid()+"\t0"+s.getName()+"\t"+s.getAge()+"\t\t"+s.getAddress());
        }
    }
    //删除学生
    //public static void deletestudent(ArrayList<student> array)
   /* {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要删除的学生学号");
        String sid=sc.nextLine();
        for(int i=0;i<array.size();i++)
        {
            student s=array.get(i);
            if(s.getSid().equals(sid))
            {
                array.remove(i);
                break;
            }

        }
        System.out.println("删除学生成功”);
}*/
    //（完善删除）当该学号不存在时
    public static void deletestudent(ArrayList<student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号");
        String sid = sc.nextLine();
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1)
            System.out.println("该信息不存在，请重新输入");
        else {
            array.remove(index);
            System.out.println("删除成功");
        }
    }

    //修改学生
    //public static void changestudent(ArrayList<student> array)
   /* {
        System.out.println("请输入需要修改学生的学号" );
        Scanner sc=new Scanner(System.in);
        String sid=sc.nextLine();
        System.out.println("请输入学生新姓名");
        String name=sc.nextLine();
        System.out.println("请输入学生新年龄");
        String age=sc.nextLine();
        System.out.println("请输入学生新地址");
        String address=sc.nextLine();
        student s=new student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        for(int i=0;i<array.size();i++)
        {
            student ss=array.get(i);
            if(ss.getSid().equals(sid))
            {
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改学生成功");
    }*/
    //（完善修改学生）当学号不存在时
public static void changestudent(ArrayList<student> array)
{
    Scanner sc= new Scanner(System.in);
    System.out.println("请输入需要修改学生的学号");
    String sid=sc.nextLine();
    System.out.println("请输入学生新姓名");
    String name=sc.nextLine();
    System.out.println("请输入学生新年龄");
    String age=sc.nextLine();
    System.out.println("请输入学生新地址");
    String address=sc.nextLine();
    int index=-1;
    student s=new student();
    s.setSid(sid);
    s.setName(name);
    s.setAge(age);
    s.setAddress(address);
    for(int i=0;i<array.size();i++)
    {
        student ss=array.get(i);
        if(ss.getSid().equals(sid))
        {
            index=i;
            //array.set(i,s);
            break;
        }
    }
    if(index==-1)
    {
        System.out.println("该信息不存在，请重新输入");
    }
    else{
        array.set(index,s);
        System.out.println("修改成功");
    }


}
public static boolean isused(ArrayList<student> array,String sid)
{
    boolean flag=false;
    for(int i=0;i<array.size();i++)
    {
        student s=array.get(i);
        if(s.getSid().equals(sid))
        {
            flag=true;
            break;
        }
    }
    return flag;
}
}

