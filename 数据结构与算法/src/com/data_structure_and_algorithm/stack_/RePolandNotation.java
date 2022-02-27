package com.data_structure_and_algorithm.stack_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式
 */

public class RePolandNotation {
    public static void main(String[] args) {
        //将中缀表达式转成后缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式" + infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式" + suffixExpressionList);

        System.out.println("结果=" + calculate(suffixExpressionList));
        //先定义逆波兰表达式，计算（30+4）*5-6
//        String suffixExpression = "30 4 + 5 * 6 -";
//        //1.先将表达式放在ArrayList中
//        //2.将ArrayList传递给一个方法，配合栈完成计算
//
//        List<String> rpnList = getListString(suffixExpression);
//        System.out.println(rpnList);
//        int res = calculate(rpnList);
//        System.out.println("结果=" + res);
    }

    //第二步、将得到的List转成后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //说明：s2这个栈在整个过程中没有pop操作，所以用List<String>替代
        List<String> s2 = new ArrayList<String>();//存储中间结果的栈

        //遍历ls
        for (String item : ls) {
            //如果是一个数，入栈s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将 ( 弹出s1栈，消除小括号
            } else {
                //当item的优先级小于等于栈顶运算符优先级
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }

        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }

    //第一步、将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式的内容
        List<String> ls = new ArrayList<String>();
        int i = 0;//用于遍历中缀表达式
        String str;//用来拼接多位数
        char c;//每遍历到一个字符，就放到c
        do {
            //如果c是一个非数字，加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {//如果是一个数，需要考虑多位数
                str = "";//将str置成""
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //将逆波兰表达式依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成逆波兰表达式计算
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        //遍历
        for (String item : ls) {
            //使用正则表达式取出数
            if (item.matches("\\d+")) {
                //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //pop出两个数并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类Operation可以返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
