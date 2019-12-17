package com.example.calculator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bean.CalFormula;
import com.example.util.Calprepare;
import com.example.util.Stringspilt;
import com.example.util.TypeExchange;

import java.util.EmptyStackException;

import static android.content.ContentValues.TAG;

public class Main2Activity extends Activity implements View.OnClickListener {

    Button[] buttons = new Button[41];
    int[] ids = new int[]{
            R.id.left_parenthesis, R.id.right_parenthesis, R.id.one_divide_by_x, R.id.binary, R.id.octal, R.id.dollar, R.id.euro,
            R.id.square, R.id.cube, R.id.power_function, R.id.c, R.id.division, R.id.multi, R.id.del,
            R.id.factorial, R.id.square_root, R.id.radica_sign, R.id.seven, R.id.eight, R.id.nine, R.id.sub,
            R.id.e, R.id.e_x, R.id.ln, R.id.four, R.id.five, R.id.six, R.id.plus,
            R.id.sin, R.id.cos, R.id.tan, R.id.one, R.id.two, R.id.three, R.id.percent, R.id.equal,
            R.id.log, R.id.pai, R.id.RAD, R.id.zero, R.id.point
    };

    TextView textView_input;
    TextView textView_output;
    String input_strings;
    String output_strings;
    Calprepare calprepare = new Calprepare();
    TypeExchange typeExchange = new TypeExchange();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //删除标题栏
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main2);

        //判断当前屏幕方向进行调整
        Configuration configuration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = configuration.orientation; //获取屏幕方向
        if (ori == configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
        }

        //加载所有button操作
        for (int i = 0; i < ids.length; i++) {

            buttons[i] = findViewById(ids[i]);//ID为Integer类型
            buttons[i].setOnClickListener(this);
        }

        textView_input = findViewById(R.id.input_view);
        textView_output = findViewById(R.id.output_view);

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                //************************************* Numbers区域 ***************************************
                case R.id.one:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("1");
                    else
                        textView_input.setText(textView_input.getText().toString() + "1");
                    break;
                case R.id.two:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("2");
                    else
                        textView_input.setText(textView_input.getText().toString() + "2");
                    break;
                case R.id.three:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("3");
                    else
                        textView_input.setText(textView_input.getText().toString() + "3");
                    break;
                case R.id.four:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("4");
                    else
                        textView_input.setText(textView_input.getText().toString() + "4");
                    break;
                case R.id.five:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("5");
                    else
                        textView_input.setText(textView_input.getText().toString() + "5");
                    break;
                case R.id.six:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("6");
                    else
                        textView_input.setText(textView_input.getText().toString() + "6");
                    break;
                case R.id.seven:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("7");
                    else
                        textView_input.setText(textView_input.getText().toString() + "7");
                    break;
                case R.id.eight:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("8");
                    else
                        textView_input.setText(textView_input.getText().toString() + "8");
                    break;
                case R.id.nine:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("9");
                    else
                        textView_input.setText(textView_input.getText().toString() + "9");
                    break;
                case R.id.zero:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("0");
                    else
                        textView_input.setText(textView_input.getText().toString() + "0");
                    break;


                //************************************* 功能区域 ***************************************

                case R.id.binary:
                    String str1 = textView_input.getText().toString();
                    int num1 = typeExchange.stringToint(str1);
                    textView_output.setText(Integer.toBinaryString(num1));
                    break;

                case R.id.octal://长度km - m
                    String str2 = textView_input.getText().toString();
                    double num2=typeExchange.stringTodouble(str2)*1000;
                    textView_output.setText(typeExchange.doubleToString(num2));
                    break;

                case R.id.euro://m3
                    String str3 = textView_input.getText().toString();
                    double num3 = typeExchange.stringTodouble(str3) * typeExchange.stringTodouble(str3)*typeExchange.stringTodouble(str3);
                    textView_output.setText(typeExchange.doubleToString(num3));
                    break;

                case R.id.dollar:
                    String str4 = textView_input.getText().toString();
                    double num4 = typeExchange.stringTodouble(str4) * 7.0256;
                    textView_output.setText(typeExchange.doubleToString(num4));
                    break;

                case R.id.c:
                    textView_input.setText("0");
                    textView_output.setText("");
                    break;

                case R.id.del:
                    String s = textView_input.getText().toString();
                    textView_input.setText(s.substring(0, s.length() - 1));
                    break;

                case R.id.point:

                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("0.");
                    else
                        textView_input.setText(textView_input.getText().toString() + ".");
                    break;

                case R.id.percent:
                    textView_input.setText(textView_input.getText().toString() + "%");
                    break;

                case R.id.plus:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("+");
                    else
                        textView_input.setText(textView_input.getText().toString() + "+");
                    break;

                case R.id.sub:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("-");
                    else
                        textView_input.setText(textView_input.getText().toString() + "-");
                    break;

                case R.id.division:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("÷");
                    else
                        textView_input.setText(textView_input.getText().toString() + "÷");
                    break;

                case R.id.multi:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("×");
                    else
                        textView_input.setText(textView_input.getText().toString() + "×");
                    break;

                case R.id.left_parenthesis:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("(");
                    else
                        textView_input.setText(textView_input.getText().toString() + "(");
                    break;

                case R.id.right_parenthesis:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText(")");
                    else
                        textView_input.setText(textView_input.getText().toString() + ")");
                    break;

                case R.id.one_divide_by_x:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("^(-1)");
                    else
                        textView_input.setText(textView_input.getText().toString() + "^(-1)");
                    break;

                case R.id.square:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("^(2)");
                    else
                        textView_input.setText(textView_input.getText().toString() + "^(2)");
                    break;

                case R.id.cube:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("^(3)");
                    else
                        textView_input.setText(textView_input.getText().toString() + "^(3)");
                    break;

                case R.id.power_function:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("^(");
                    else
                        textView_input.setText(textView_input.getText().toString() + "^(");
                    break;

                case R.id.factorial:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("!");
                    else
                        textView_input.setText(textView_input.getText().toString() + "!");
                    break;

                case R.id.square_root:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("^(1÷2)");
                    else
                        textView_input.setText(textView_input.getText().toString() + "^(1÷2)");
                    break;

                case R.id.radica_sign:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("^(1÷");
                    else
                        textView_input.setText(textView_input.getText().toString() + "^(1÷");
                    break;

                case R.id.e:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("e");
                    else
                        textView_input.setText(textView_input.getText().toString() + "e");
                    break;

                case R.id.e_x:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("e^(");
                    else
                        textView_input.setText(textView_input.getText().toString() + "e^(");
                    break;

                case R.id.ln:
                    if (textView_input.getText().toString().equals("0"))
                        break;
                    else {
                        double cal_out = typeExchange.stringTofloat(textView_output.getText().toString());
                        output_strings = typeExchange.doubleToString(Math.exp(cal_out));
                        textView_output.setText(output_strings);
                        break;
                    }

                case R.id.log:
                    if (textView_input.getText().toString().equals("0")) {
                        textView_input.setText("log(");
                        break;
                    } else {
                        textView_input.setText(textView_input.getText().toString() + "log(");
                        break;
                    }

                case R.id.sin:
                    if (textView_input.getText().toString().equals("0")) {
                        textView_input.setText("sin(");
                        break;
                    } else {
                        textView_input.setText(textView_input.getText().toString() + "sin(");
                        break;
                    }

                case R.id.cos:
                    if (textView_input.getText().toString().equals("0")) {
                        textView_input.setText("cos(");
                        break;
                    } else {
                        textView_input.setText(textView_input.getText().toString() + "cos(");
                        break;
                    }

                case R.id.tan:
                    if (textView_input.getText().toString().equals("0")) {
                        textView_input.setText("tan(");
                        break;
                    } else {
                        textView_input.setText(textView_input.getText().toString() + "tan(");
                        break;
                    }


                case R.id.pai:
                    if (textView_input.getText().toString().equals("0"))
                        textView_input.setText("π");
                    else
                        textView_input.setText(textView_input.getText().toString() + "π");
                    break;
                case R.id.RAD:
                    break;


                case R.id.equal:
                    input_strings = textView_input.getText().toString();

                    if (input_strings.contains("×")) {
                        input_strings = input_strings.replaceAll("×", "*");
                    }
                    if (input_strings.contains("÷")) {
                        input_strings = input_strings.replaceAll("÷", "/");
                    }
                    if (input_strings.contains("%")) {
                        input_strings = input_strings.replaceAll("%", "*0.01");
                    }

                    /**
                     * sin
                     */
                    if (input_strings.contains("sin")) {
                        input_strings = input_strings.replace("sin", "s");
                        String cal_num = "";
                        boolean sin = false;
                        //  获取 sin括号内的数
                        for (int i = 0; i < input_strings.length(); i++) {
                            if (input_strings.charAt(i) == 's') {
                                cal_num += input_strings.charAt(i);
                                sin = true;
                                continue;
                            }
                            if (sin = true) {
                                cal_num += input_strings.charAt(i);
                            }
                            if (sin = true && input_strings.charAt(i) == ')') {
                                sin = false;
                                break;
                            }
                        }
                        String sin_strings = calprepare.cal_sin(input_strings);
                        input_strings = input_strings.replace(cal_num, sin_strings);
                    }

                    /**
                     * cos
                     */
                    if (input_strings.contains("cos")) {
                        input_strings = input_strings.replace("cos", "c");
                        String cal_num = "";
                        boolean cos = false;
                        //  获取 sin括号内的数
                        for (int i = 0; i < input_strings.length(); i++) {
                            if (input_strings.charAt(i) == 'c') {
                                cal_num += input_strings.charAt(i);
                                cos = true;
                                continue;
                            }
                            if (cos = true) {
                                cal_num += input_strings.charAt(i);
                            }
                            if (cos = true && input_strings.charAt(i) == ')') {
                                cos = false;
                                break;
                            }
                        }
                        String cos_strings = calprepare.cal_cos(input_strings);
                        input_strings = input_strings.replace(cal_num, cos_strings);
                    }

                    /**
                     * tan
                     */
                    if (input_strings.contains("tan")) {
                        input_strings = input_strings.replace("tan", "t");
                        String cal_num = "";
                        boolean tan = false;
                        //  获取 tan括号内的数
                        for (int i = 0; i < input_strings.length(); i++) {
                            if (input_strings.charAt(i) == 't') {
                                cal_num += input_strings.charAt(i);
                                tan = true;
                                continue;
                            }
                            if (tan = true) {
                                cal_num += input_strings.charAt(i);
                            }
                            if (tan = true && input_strings.charAt(i) == ')') {
                                tan = false;
                                break;
                            }
                        }
                        String tan_strings = calprepare.cal_tan(input_strings);
                        Log.d(TAG, "tan is " + tan_strings + "\t" + cal_num);
                        input_strings = input_strings.replace(cal_num, tan_strings);
                    }

                    /**
                     * log
                     */
                    if (input_strings.contains("log")) {
                        input_strings = input_strings.replace("log", "l");
                        String cal_num = "";
                        boolean log = false;
                        //  获取 sin括号内的数
                        for (int i = 0; i < input_strings.length(); i++) {
                            if (input_strings.charAt(i) == 'l') {
                                cal_num += input_strings.charAt(i);
                                log = true;
                                continue;
                            }
                            if (log = true) {
                                cal_num += input_strings.charAt(i);
                            }
                            if (log = true && input_strings.charAt(i) == ')') {
                                log = false;
                                break;
                            }
                        }
                        String log_strings = calprepare.cal_log(input_strings);
                        input_strings = input_strings.replace(cal_num, log_strings);
                    }
                    if (input_strings.contains("π")) {
                        input_strings = input_strings.replace("π", typeExchange.doubleToString(Math.PI));
                    }
                    if (input_strings.contains("e")) {
                        input_strings = input_strings.replaceAll("e", typeExchange.doubleToString(Math.E));
                    }


                    System.out.println("input_strings = " + input_strings);
                    //中缀转后缀
                    Stringspilt preExp = new Stringspilt(input_strings);
                    CalFormula calFormula = new CalFormula();
                    String[] post_fix = calFormula.prefix_To_postfix(preExp.getArrFormula());
                    output_strings = typeExchange.doubleToString(calFormula.calPostfix(post_fix));

                    //计算后缀
                    textView_output.setText(output_strings);
                    break;

            }
        } catch (EmptyStackException e1) {
            textView_input.setText("0");
            textView_output.setText("error");
        } catch (NumberFormatException e2) {
            textView_input.setText("0");
            textView_output.setText("error");
        }


    }
}
