import java.util.Scanner;

public class Computer {


    String name = "电脑";

    int score= 0;

    public  int showFist() {

        Scanner input = new Scanner(System.in);

        int show = (int) (Math.random()*3 + 1);

        switch (show){

            case 1:
                System.out.println("电脑出剪刀");
                break;
            case 2:
                System.out.println("电脑出石头");
                break;
            case 3:
                System.out.println("电脑出布");
                break;
        }

        return show;

    }

}