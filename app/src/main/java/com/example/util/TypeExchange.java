package com.example.util;

public class TypeExchange {

    /**
     * String 转 Float 类型
     *
     * @param num
     * @return
     */
    public float stringTofloat(String num) {
        float tynum = Float.parseFloat(num);
        return tynum;
    }


    /**
     * String 转 Double 类型
     *
     * @param num
     * @return
     */
    public double stringTodouble(String num) {
        double tynum = Double.valueOf(num);
        return tynum;
    }


    /**
     * String to int
     */
    public int stringToint(String num) {
        int tynum = Integer.parseInt(num);
        return tynum;
    }


    /**
     * float to String
     *
     * @param num
     * @return
     */
    public String floatToString(float num) {
        String tynum = String.valueOf(num);
        return tynum;
    }

    /**
     * double to String
     */
    public String doubleToString(double num) {
        String tynum = String.valueOf(num);
        return tynum;
    }

    /**
     * int to String
     *
     * @param num
     * @return
     */
    public String intToString(int num) {
        String tynum = String.valueOf(num);
        return tynum;
    }
}

