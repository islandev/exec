/**
 * Created by ben
 * on 2018/3/3.
 */

package com.qunar.ben.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    public static  int calPoints(String[] ops) {
        int length = ops.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int sum =0;
        for (int i=0;i<length;i++){
            String op = ops[i];
            if(op.matches("-?\\d+(\\.\\d+)?")){
                int cur = Integer.parseInt(op);
                sum+=cur;
                stack.push(cur);
                continue;
            }

            int score =0;
            int pre =0;
            switch (op){
                case "C":
                    sum -= stack.pop();
                    break;
                case "D":
                     score = stack.peek()*2;
                    stack.push(score);
                    sum += (score);
                    break;
                case  "+":
                    pre= stack.pop();
                    score =  stack.peek()+pre;
                    sum+=score;
                    stack.push(pre);
                    stack.push(score);
                    break;
            }
        }
        return  sum;

    }


    public static void main(String[] args) {
        String [] points ={"-21","-66","39","+","+"};
        System.out.printf(String.valueOf(calPoints(points)));
    }
}
