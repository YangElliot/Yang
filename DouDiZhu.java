import com.sun.scenario.effect.Color4f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.FormatterClosedException;

/**
 *  *   斗地主发牌程序
 *  *   1.准备牌
 *  *   2.洗牌
 *  *   3.发牌
 *  *   4.看牌
 *  *   @author 杨小天
 *  *   @create 2019-03-31 16:09
 */
public class DouDiZhu {
    public static void main(String[] args) {

        /*第一步 准备牌*/
        //定义要给存储54张牌的Arraylist集合，泛型用String
        ArrayList<String> poker =new ArrayList<>();
        //定义两个数组，一个存花色，一个存牌大小
        String[] colors={"♣","♦","♠","❤"};
        String[] numbers={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        poker.add("大王");
        poker.add("小王");
        //循环遍历两个数组，添加进poker集合里
        for (String color : colors) {
            for (String number : numbers) {
                poker.add(color+number);
            }
        }
        System.out.println(poker);

        /*第二步 洗牌*/
        //使用Collections集合工具类的shuffle方法洗牌
        //static void shuffle(List<?> list)  静态方法，类名.方法名调用
        Collections.shuffle(poker);
        System.out.println(poker);

        /*第三部 发牌*/
        //用ArrayList定义四个集合存玩家的牌和底牌
        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        ArrayList<String> dipai=new ArrayList<>();

        for (int i = 0; i < poker.size() ; i++) {
            String p=poker.get(i);
            if (i>=51){
                dipai.add(poker.get(i));
            }else if(i%3==0){
                player1.add(poker.get(i));
            }else if(i%3==1){
                player2.add(poker.get(i));
            }
            else if(i%3==2){
                player3.add(poker.get(i));
            }
        }

        /*第四步 看牌*/
        System.out.println("玩家1"+player1);
        System.out.println("玩家2"+player2);
        System.out.println("玩家3"+player3);
        System.out.println("底牌"+dipai);




    }
}
