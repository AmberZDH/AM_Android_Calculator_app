package com.example.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class CalString {
    public static double calculate(String expre) {
        List<String> num = transformEnd(expre);
        Stack<Double> stack = new Stack<>();
        double sum = 0;
        while (!num.isEmpty()) {
            String temp = String.valueOf(num.remove(0));
            if (isNamber(temp)) {
                double s = Double.parseDouble(temp);
                stack.push(s);
            } else {
                double a = stack.pop();
//                System.out.println("a = "+a);
                double b = stack.pop();
//                System.out.println("a = "+b);
                double c = calTwo(b, a, temp);
                stack.push(c);

            }
        }
        sum = stack.pop();
        return sum;
    }

    private static double calTwo(double a, double b, String opr) {
        double sum = 0;
        switch (opr) {
            case "+":
                sum = a + b;
                break;
            case "－":
                sum = a - b;
                break;
            case "×":
                sum = a * b;
                break;
            case "÷":
                sum = a / b;
                break;
            case "^":
                sum = Math.pow(a, b);
                break;
//            case "s":
//                sum = b*Math.sin(a);
//                break;
        }
        return sum;
    }

    /**
     * 1.将中缀表达式转化为后缀表达式（栈是用来进出运算的符号）
     */
    public static List<String> transformEnd(String expre) {
        List<String> sb = new ArrayList<>();
        Stack<String> stack = new Stack<>();
//        expre = expre.replaceAll("(\\D)", "o$1o");
        expre = expre.replaceAll("([0-9]\\\\d*\\\\.?\\\\d*)|((-)?[0-9]\\\\d*\\\\.?\\\\d*)", "o$1o");
        String[] esp = expre.trim().split("o");

        for (int i = 0; i < esp.length; i++) {
            String s = esp[i].trim();

            if (isNamber(s)) {
                // 如果是数字则输出
                sb.add(s);
            } else if (!s.isEmpty()) {

                if (s.charAt(0) == ')') {
                    while (stack.peek().charAt(0) != '(') {
                        sb.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                        while (!stack.isEmpty() && !isMaxExp(s.charAt(0), stack.peek().charAt(0))) {
                            sb.add(stack.pop());
                        }
                        stack.push(s);
                    } else {
                        stack.push(s);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.add(stack.pop());
        }
        return sb;
    }

    // 判断是否是数字
    private static boolean isNamber(String str) {
        try {
            Double.parseDouble(str);

        } catch (RuntimeException e) {
            return false;
        }
        ;
        return true;
    }

    // 判断是否进栈
    private static boolean isMaxExp(char exp1, char exp2) {
        if (exp1 == '(')
            return true;
        if (exp2 == ')')
            return true;
        if (transExp(exp1) > transExp(exp2))
            return true;
        return false;
    }

    private static int transExp(char exp) {
        int re = 0;
        switch (exp) {

            case '×':
            case '÷':
                re = 2;
                break;
            case '+':
            case '－':
                re = 1;
                break;
        }
        return re;
    }

}
