package com.data_structure_and_algorithm.stack_;

/**
 * 栈实现计算器
 */

public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到char保存到ch
        String keepNum = "";//用于拼接多位数
        //用while循环扫描
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么
            if (operStack.isOper(ch)) {
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果入数栈
                        numStack.push(res);
                        //把当前符号入符号栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else {
                //如果是数直接入数栈(此种方法如果是多位数就失效了)
                //numStack.push(ch - 48);//因为字符是ASCII值
                //处理多位数
                //处理数时，再向后看一位，如果是数就进行扫描，如果是符号才入栈
                keepNum += ch;

                //如果ch已经是最后一位，直接入栈
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //注意！！！，keepNum清空
                        keepNum = "";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //当扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字（结果）
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);//入栈
        }

        System.out.println(expression + " = " + numStack.pop());
    }
}

//先创建一个栈
class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数据放在该数组
    private int top = -1;//top表示栈顶，初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //创建一个方法，可以返回当前栈顶的值，但不是pop
    public int peek() {
        return stack[top];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈,注意是从栈顶开始遍历
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

    //返回运算符的优先级，优先级由程序员绝定
    //数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;//用于存放计算的结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//注意顺序
                break;
            default:
                break;
        }
        return res;
    }
}

