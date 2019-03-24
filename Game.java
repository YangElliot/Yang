import java.util.Scanner;

public class Game {

    Person person =new Person();;

    Computer computer= new Computer();

    int count = 0;


    public void startGame(){



        System.out.println("\n**************************\n");
        System.out.println("********开始游戏*********");
        System.out.println("\n**************************\n");

        Scanner input = new Scanner(System.in);
        System.out.println("请选择对手 1.刘备 2.曹操 3.孙权");
        int role = input.nextInt();

        switch (role){
            case 1 :
                computer.name="刘备";
                System.out.println("你选择了刘备");
                break;
            case 2 :
                computer.name="曹操";
                System.out.println("你选择了曹操");
                break;
            case 3 :
                computer.name="孙权";
                System.out.println("你选择了孙权");
                break;
        }

        System.out.println("输入你的名字：");
        person.name = input.next();

        //开始游戏

        int perFist;
        int conFist;

        System.out.println("开始游戏么（y/n）：");
        String begin = input.next();


        while (begin.equals("y")) {

            perFist = person.showFist();
            conFist = computer.showFist();



            if ((perFist == 1 && conFist == 1) || (perFist == 2 && conFist == 2) || (perFist == 3 && conFist == 3)) {
                System.out.println("和局");

            } else if ((perFist == 1 && conFist == 2) || (perFist == 2 && conFist == 3) || (perFist == 3 && conFist == 1)) {
                System.out.println("你输了");
                computer.score++;

            } else {
                System.out.println("你赢了");
                person.score++;

            }

            count++;

            System.out.println("\n\n\n开始下一轮游戏么（y/n）：");
            begin = input.next();

        }

        showResult();
    }

    public void showResult(){
            System.out.println("____________________________________");
            System.out.println("对局次数："+count);

        if (person.score==computer.score){
            System.out.println("平局");
        }else if(person.score>computer.score){
            System.out.println("你赢了");
        }else{
            System.out.println("欢声笑语打GG");
        }


        System.out.println("\n\n"+person.name+"的分数是："+person.score);

        System.out.println(computer.name+"的分数是："+computer.score);
    }

}
