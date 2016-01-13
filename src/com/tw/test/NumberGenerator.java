package com.tw.test;
import java.util.*;

/**
 * Created by zw on 2015/12/26.
 */
public class NumberGenerator {
    public String generate() {
        List list = new ArrayList();
        for(int j = 0; j <= 9 ; j++){
            list.add(j);
        }
        Collections.shuffle(list);
        String randomnum="";
        for(int i=0;i<4;i++){
            randomnum+=list.get(i)+"";
        }
        return randomnum;
    }

    public String comResult(String randomNum,String inputNum){
        int A=0,B=0;
        for(int digit=0;digit<4;digit++ ){
            int positiont=randomNum.indexOf(inputNum.charAt(digit));
            if(positiont>-1){
                B+=1;
            }if(positiont==digit){
                B-=1;
                A+=1;
            }
        }
        return A+"A"+B+"B";
    }

    public static void play(){
        NumberGenerator numbergen = new NumberGenerator();
        String randomnum = numbergen.generate();
        Scanner input = new Scanner(System.in);
        System.out.println("game start!");
        for (int chance= 0; chance< 6 ; chance++) {
            String line = input.nextLine();
            String result = numbergen.comResult(randomnum,line);
            if(result.equals("4A0B")){
                System.out.println("You Win!");
            }else{
                System.out.println(result);
                System.out.println("You have "+(5-chance)+" chance!");
            }
        }
        System.out.println("The right number is "+randomnum);
    }
}
