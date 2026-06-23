package com.xuexi.doudizhu;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
    //牌盒
    static ArrayList<String> list = new ArrayList<>();

    //准备牌
    static{
        ArrayList<String> color = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();
        Collections.addAll(color, "♠", "♣", "♥", "♦");
        Collections.addAll(number, "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add("大王");
        list.add("小王");
    }

    public PokerGame(){

        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if(i < 3){
                lord.add(poker);
                continue;
            }
            if(i % 3 == 0){
                player1.add(poker);
            }else if(i % 3 == 2){
                player2.add(poker);
            }else{
                player3.add(poker);
            }
        }

        //看牌
        lookPoker("底牌", lord);
        lookPoker("玩家1", player1);
        lookPoker("玩家2", player2);
        lookPoker("玩家3", player3);

    }
    public void lookPoker(String name, ArrayList<String> list){
        System.out.print(name + " : ");
        System.out.println(list);
    }
}
