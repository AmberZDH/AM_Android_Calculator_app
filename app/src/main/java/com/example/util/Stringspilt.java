package com.example.util;

import java.util.ArrayList;

public class Stringspilt {
    /**
     * 用于表达式拆封 存入栈
     */

    private String formula;
    private String[] dir = {"+", "-", "*", "/", "(", ")", "^", "%"};

    public Stringspilt() {
    }

    public Stringspilt(String formula) {
        this.formula = formula;
    }


    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * 拆开表达式
     *
     * @return
     */
    public ArrayList<String> getArrFormula() {
        ArrayList<String> arr = new ArrayList<>();
        String str = "";
        char[] chararr = this.formula.toCharArray();
        for (int i = 0; i < chararr.length; i++) {
            if (judgeChar(dir, (String.valueOf(chararr[i])))) {
                if (str != "")
                    arr.add(str);
                arr.add(String.valueOf(chararr[i]));
                str = "";
            } else {
                if (i == chararr.length) {
                    str += chararr[i];
                    arr.add(str);
                }
                str += chararr[i];

            }
            //将最后一组数加入数组
            if (i == chararr.length - 1 && str != "") {
                arr.add(str);
            }

        }
        return arr;
    }


    private boolean judgeChar(String[] str, String ch) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(ch)) {
                return true;
            }
        }
        return false;
    }
}




