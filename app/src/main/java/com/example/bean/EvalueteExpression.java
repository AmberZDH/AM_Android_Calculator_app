package com.example.bean;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class EvalueteExpression {
    //用字符串做参数重载的计算函数，调用下面用字符串数组做方法参数的函数
    public static void compute(String expression) {
        String[] arr = strToExpressionArr(expression);
        if (isLegalExpression(arr))
            System.out.println(compute(strToExpressionArr(expression)));
        else
            System.out.println("非法表达式");
    }

    //把表达式转换为数组
    private static String[] strToExpressionArr(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                str = str.substring(0, i) +
                        " " + str.charAt(i) + " " +
                        str.substring(i + 1, str.length());
                i += 2;
            }
        }
        Scanner sc = new Scanner(str);
        while (sc.hasNext())
            list.add(sc.next());

        return list.toArray(new String[list.size()]);
    }

    //计算算术表达式
    private static int compute(String[] expression) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            String ele = expression[i];

            //如果是数字，进入数字栈
            if (isNumber(ele)) {
                numStack.push(new Integer(ele));
            }
            //以下是符号
            //遇到加减号，把栈顶的符号都处理完，直到遇到（左括号和栈空情况，最后把提取到的符号压入栈
            else if (ele.charAt(0) == '+' || ele.charAt(0) == '-') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }

                if (!opStack.isEmpty() && opStack.peek() == '(')
                    opStack.pop();

                opStack.push(ele.charAt(0));
            }
            //遇到乘除号，把前面的乘除号处理完，最后把提取到的符号压入栈
            else if (ele.charAt(0) == '*' || ele.charAt(0) == '/') {
                while (!opStack.isEmpty() && opStack.peek() != '(' &&
                        opStack.peek() != '+' && opStack.peek() != '-') {
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }

                if (!opStack.isEmpty() && opStack.peek() == '(')
                    opStack.pop();

                opStack.push(ele.charAt(0));
            }
            //遇到左括号，只进栈
            else if (ele.charAt(0) == '(') {
                opStack.push(ele.charAt(0));
            }
            //遇到右括号，只处理栈顶全部符号
            else if (ele.charAt(0) == ')') {
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    int b = numStack.pop();
                    int a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }

                if (!opStack.isEmpty() && opStack.peek() == '(')
                    opStack.pop();
            }
        }

        //最后没有以右括号结尾的表达式还得另外把剩下的符号处理完
        if (!opStack.isEmpty()) {
            int b = numStack.pop();
            int a = numStack.pop();
            numStack.push(getAnswer(a, opStack.pop(), b));
        }

        return numStack.peek();
    }

    //判断是否数字
    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }

    //四则运算
    private static int getAnswer(int a, char operator, int b) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    //判断表达式是否合法
    static boolean isLegalExpression(String[] arr) {
        //表达式的开头和结尾不能出现加减乘除符号
        char hc = arr[0].charAt(0);
        char tc = arr[arr.length - 1].charAt(0);
        if (hc == '+' || hc == '-' || hc == '*' || hc == '/' ||
                tc == '+' || tc == '-' || tc == '*' || tc == '/')
            return false;

        //括号要一一对应,而且开头不能是右括号，结尾不能是左括号
        Stack<Character> stk = new Stack();
        for (String s : arr) {
            if (s.charAt(0) == '(')
                stk.push(s.charAt(0));
            else if (s.charAt(0) == ')') {
                if (stk.isEmpty())
                    return false;
                stk.pop();
            }
        }

        if (!stk.isEmpty())
            return false;

        //不能出现非法字符，就是除了加减乘除和括号和数字外，不能出现其他字符
        String ts = "";
        for (String s : arr) {
            ts += s;
        }

        for (char c : ts.toCharArray()) {
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')'&&
                    !(c >= '0' && c <= '9'))
                return false;
        }

        //看每个数字两边是否缺少符号操作和每个符号两边是否缺少数字
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);

            //数字
            if (isNumber(arr[i])) {
                boolean hasLeft = true;
                boolean hasRight = true;

                if (i == 0)
                    hasLeft = false;
                if (i == arr.length - 1)
                    hasRight = false;

                //看左边是否有符号
                if (i > 0) {
                    char cha = arr[i - 1].charAt(0);
                    if (cha != '+' && cha != '-' && cha != '*' && cha != '/')
                        hasLeft = false;
                }
                //看右边有没有符号
                if (i < arr.length - 1) {
                    char cha = arr[i + 1].charAt(0);
                    if (cha != '+' && cha != '-' && cha != '*' && cha != '/')
                        hasRight = false;
                }
                //都没有就非法
                if (!hasLeft && !hasRight)
                    return false;
            }
            //运算符
            else if ( c == '+' || c == '-' || c == '*' || c == '/') {
                boolean hasLeft = true;
                boolean hasRight = true;

                if (i == 0)
                    hasLeft = false;
                if (i == arr.length - 1)
                    hasRight = false;

                //看左边是否有数字
                if (i > 0) {
                    if (!isNumber(arr[i - 1]))
                        hasLeft = false;
                }
                //看右边有没有数字
                if (i < arr.length - 1) {
                    if (!isNumber(arr[i + 1]))
                        hasRight = false;
                }
                //都没有就非法
                if (!hasLeft && !hasRight)
                    return false;
            }
        }

        return true;
    }
}
