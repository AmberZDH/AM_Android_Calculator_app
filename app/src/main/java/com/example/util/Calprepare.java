package com.example.util;

import com.example.bean.CalFormula;

public class Calprepare {
    public String cal_sin(String num_string) {

        TypeExchange typeExchange = new TypeExchange();

        boolean sin = false;
        String cal_num = "";

        //  获取 sin括号内的数
        for (int i = 0; i < num_string.length(); i++) {
            if (num_string.charAt(i) == 's') {
                sin = true;
                continue;
            }
            if (sin = true) {
                cal_num += num_string.charAt(i);
            }
            if (sin = true && num_string.charAt(i) == ')') {

                sin = false;
            }
        }

        //计算括号内的表达式
        Stringspilt calString = new Stringspilt(cal_num);
        CalFormula cal = new CalFormula();
        String[] expList = cal.prefix_To_postfix(calString.getArrFormula());

        //计算后缀表达式
        double sum_out = cal.calPostfix(expList);
        sum_out=Math.sin(sum_out);

        String out=typeExchange.doubleToString(sum_out);

        return num_string.replace("s"+cal_num, typeExchange.doubleToString(sum_out));
    }

    public String cal_cos(String num_string) {
        TypeExchange typeExchange = new TypeExchange();

        boolean cos = false;
        String cal_num = "";

        //  获取 sin括号内的数
        for (int i = 0; i < num_string.length(); i++) {
            if (num_string.charAt(i) == 'c') {
                cos = true;
                continue;
            }
            if (cos = true) {
                cal_num += num_string.charAt(i);
            }
            if (cos = true && num_string.charAt(i) == ')') {

                cos = false;
            }
        }

        //计算括号内的表达式
        Stringspilt calString = new Stringspilt(cal_num);
        CalFormula cal = new CalFormula();
        String[] expList = cal.prefix_To_postfix(calString.getArrFormula());

        //计算后缀表达式
        double sum_out = cal.calPostfix(expList);
        sum_out=Math.sin(sum_out);

        String out=typeExchange.doubleToString(sum_out);

        return num_string.replace("c"+cal_num, typeExchange.doubleToString(sum_out));
    }

    public String cal_tan(String num_string) {
//        TypeExchange typeExchange = new TypeExchange();
//
//        boolean tan = false;
//        String cal_num = "";
//
//        //  获取 sin括号内的数
//        for (int i = 0; i < num_string.length(); i++) {
//            if (num_string.charAt(i) == 't') {
//                tan = true;
//                continue;
//            }
//            if (tan = true) {
//                cal_num += num_string.charAt(i);
//            }
//            if (tan = true && num_string.charAt(i) == ')') {
//
//                tan = false;
//            }
//        }
//
//        //计算括号内的表达式
//        Stringspilt calString = new Stringspilt(cal_num);
//        CalFormula cal = new CalFormula();
//        String[] expList = cal.prefix_To_postfix(calString.getArrFormula());
//
//        //计算后缀表达式
//        double sum_out = cal.calPostfix(expList);
//        sum_out=Math.tan(sum_out);
//
//        String out=typeExchange.doubleToString(sum_out);
//
//        return num_string.replace("t"+cal_num, typeExchange.doubleToString(sum_out));
        TypeExchange typeExchange = new TypeExchange();

        boolean tan = false;
        String cal_num = "";

        //  获取 sin括号内的数
        for (int i = 0; i < num_string.length(); i++) {
            if (num_string.charAt(i) == 't') {
                tan = true;
                continue;
            }
            if (tan = true) {
                cal_num += num_string.charAt(i);
            }
            if (tan = true && num_string.charAt(i) == ')') {

                tan = false;
            }
        }

        //计算括号内的表达式
        Stringspilt calString = new Stringspilt(cal_num);
        CalFormula cal = new CalFormula();
        String[] expList = cal.prefix_To_postfix(calString.getArrFormula());

        //计算后缀表达式
        double sum_out = cal.calPostfix(expList);
        sum_out=Math.tan(sum_out);

        String out=typeExchange.doubleToString(sum_out);

        return num_string.replace("t"+cal_num, typeExchange.doubleToString(sum_out));
    }

    public String cal_log(String num_string) {
        TypeExchange typeExchange = new TypeExchange();

        boolean log = false;
        String cal_num = "";

        //  获取 sin括号内的数
        for (int i = 0; i < num_string.length(); i++) {
            if (num_string.charAt(i) == 'l') {
                log = true;
                continue;
            }
            if (log = true) {
                cal_num += num_string.charAt(i);
            }
            if (log = true && num_string.charAt(i) == ')') {

                log = false;
            }
        }

        //计算括号内的表达式
        Stringspilt calString = new Stringspilt(cal_num);
        CalFormula cal = new CalFormula();
        String[] expList = cal.prefix_To_postfix(calString.getArrFormula());

        //计算后缀表达式
        double sum_out = cal.calPostfix(expList);
        sum_out=Math.sin(sum_out);

        String out=typeExchange.doubleToString(sum_out);

        return num_string.replace("l"+cal_num, typeExchange.doubleToString(sum_out));
    }
}