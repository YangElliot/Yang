import java.util.Scanner;

public class Person {

    String name = "匿名";

    int score=0;

    public  int showFist(){

        Scanner input = new Scanner(System.in);

        System.out.println("请选择出法(1.剪刀 2.石头 3.布)：");

        int show = input.nextInt();

        switch (show){

            case 1:
                System.out.println("出剪刀");
                break;
            case 2:
                System.out.println("出石头");
                break;
            case 3:
                System.out.println("出布");
                break;

        }

        return show;
    }
}
