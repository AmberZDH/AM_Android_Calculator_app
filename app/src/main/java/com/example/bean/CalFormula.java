package com.example.bean;

import com.example.util.TypeExchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CalFormula {
    private Map<String, Integer> dict = new HashMap<String, Integer>();
    private TypeExchange typeExchange = new TypeExchange();

    public CalFormula() {

    }

    /**
     * 创建字典记录符号优先级
     *
     * @return
     */
    public Map<String, Integer> getDict() {
        dict.put("^", 4);
        dict.put("s", 4);
        dict.put("c", 4);
        dict.put("t", 4);
        dict.put("*", 3);
        dict.put("/", 3);
        dict.put("+", 2);
        dict.put("-", 2);
        dict.put("(", 1);
        dict.put(")", 1);
        return dict;
    }

    /**
     * 中缀表达式转后缀表达式
     *
     * @param array
     * @return
     */
    public String[] prefix_To_postfix(ArrayList<String> array) {
        Object[] objectsarr = array.toArray();
        String[] arr = new String[objectsarr.length];
        for (int h = 0; h < objectsarr.length; h++) {
            arr[h] = String.valueOf(objectsarr[h]);
        }
        Stack<String> charstack = new Stack<>();
        Stack<String> formulastack = new Stack<>();
        Map dic = getDict();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
            if (i == 0 && dic.containsKey(arr[i]) == false) {
                formulastack.push(arr[i]);
                continue;
            }
            switch (arr[i]) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "s":
                case "c":
                case "t":
                    boolean pan1 = false;

                    //如果符号栈为null允许添加字符
                    if (charstack.isEmpty() || (int) dic.get(arr[i]) > (int) dic.get(charstack.peek())) {
                        charstack.push(arr[i]);
                        break;
                    }

                    //如果当前符号优先值 < 栈顶元素优先值
                    while (!pan1 && (int) dic.get(arr[i]) <= (int) dic.get(charstack.peek())) {
                        formulastack.push(charstack.pop());
                        if (charstack.isEmpty()) {
                            pan1 = true;
                        }
                    }
                    if (pan1 = true) {//将小的元素添加回符号栈
                        charstack.add(arr[i]);
                    }

                    break;
                case "(":
                    charstack.push(arr[i]);
                    break;
                case ")":
                    //将栈顶的运算符依次弹出并输出，直至遇到左括号[左括号弹出但不输出]
                    while (true) {
                        String s = charstack.pop();
                        if (s.equals("(")) {
                            break;
                        } else {
                            formulastack.add(s);
                        }
                    }
                    break;

                default:
                    //传入数
                    formulastack.add(arr[i]);
                    break;
            }


            //最后一个字符的时候符号栈不为空时
            while (i == arr.length - 1 && !charstack.empty()) {
                formulastack.add(charstack.pop());
            }
        }

        //变换表达式顺序
        String[] postfix = new String[formulastack.size()];
        for (int k = postfix.length - 1; k >= 0; k--) {
            postfix[k] = formulastack.pop();
        }
        return postfix;
    }


    /**
     * 后缀表达式计算
     *
     * @param postfixList
     * @return
     */
    public double calPostfix(String[] postfixList) {
        Stack<Double> sumStack = new Stack<>();
        double sum = 0;
        double result = 0;
        Map dic = getDict();

        for (int i = 0; i < postfixList.length; i++) {
            if (!dic.containsKey(postfixList[i])) {
                //类型转换
                sumStack.add(typeExchange.stringTodouble(postfixList[i]));
            } else {
                double num1 = sumStack.pop();
                double num2 = sumStack.pop();


                switch (postfixList[i]) {
                    case "+":
                        result = num2 + num1;
                        break;

                    case "-":
                        result = num2 - num1;
                        break;

                    case "*":
                        result = num2 * num1;
                        break;

                    case "/":
                        result = num2 / num1;
                        break;

                    case "^":
                        result = Math.pow(num2, num1);
                        break;

                    default:
                        System.out.println("something wrong in your postfix!");
                }
                sumStack.push(result);
            }
        }
        sum = sumStack.pop();
        return sum;
    }


}
