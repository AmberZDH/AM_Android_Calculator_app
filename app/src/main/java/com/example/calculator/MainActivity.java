package com.example.calculator;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.R.id;
import com.example.util.TypeExchange;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView textView;
    private Button[] buttons = new Button[20];
    private AlertDialog.Builder builder;

    TypeExchange typeExchange = new TypeExchange();
    String mathtype = null;
    boolean cal_label = false;
    float num1, num2;


    int[] ids = new int[]{
            R.id.AC, R.id.plus_minus, R.id.percent,R.id.division,
            R.id.multi, R.id.sub, R.id.plus, R.id.point, R.id.equal,
            R.id.one, R.id.two, R.id.three, R.id.four, R.id.five,
            R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero, id.help
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //判断当前屏幕方向进行调整
        Configuration configuration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = configuration.orientation; //获取屏幕方向
        if (ori == configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }

        textView = findViewById(id.num_edit);

        //加载所有button操作
        for (int i = 0; i < ids.length; i++) {

            buttons[i] = findViewById(ids[i]);//ID为Integer类型
            buttons[i].setOnClickListener(this);
        }


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            System.out.println("amber");
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }


    @Override
    public void onClick(View view) {
//        String sense = textView.getText().toString();
        if (textView.getText().toString().equals("Infinity")) {
            textView.setText("0");
            num1 = 0;
            num2 = 0;
        }
        switch (view.getId()) {

            case R.id.help:
                showTwo();
                break;

                //************************************* Numbers区域 ***************************************
            case R.id.one:
                if (textView.getText().toString().equals("0"))
                    textView.setText("1");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("1");
                    else textView.setText(textView.getText().toString() + "1");
                else
                    textView.setText(textView.getText().toString() + "1");
                break;

            case R.id.two:
                if (textView.getText().toString().equals("0"))
                    textView.setText("2");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("2");
                    else textView.setText(textView.getText().toString() + "2");
                else
                    textView.setText(textView.getText().toString() + "2");
                break;

            case R.id.three:
                if (textView.getText().toString().equals("0"))
                    textView.setText("3");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("3");
                    else textView.setText(textView.getText().toString() + "3");
                else
                    textView.setText(textView.getText().toString() + "3");
                break;

            case R.id.four:
                if (textView.getText().toString().equals("0"))
                    textView.setText("4");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("4");
                    else textView.setText(textView.getText().toString() + "4");
                else
                    textView.setText(textView.getText().toString() + "4");
                break;

            case R.id.five:
                if (textView.getText().toString().equals("0"))
                    textView.setText("5");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("5");
                    else textView.setText(textView.getText().toString() + "5");
                else
                    textView.setText(textView.getText().toString() + "5");
                break;

            case R.id.six:
                if (textView.getText().toString().equals("0"))
                    textView.setText("6");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("6");
                    else textView.setText(textView.getText().toString() + "6");
                else
                    textView.setText(textView.getText().toString() + "6");
                break;

            case R.id.seven:
                if (textView.getText().toString().equals("0"))
                    textView.setText("7");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("7");
                    else textView.setText(textView.getText().toString() + "7");
                else
                    textView.setText(textView.getText().toString() + "7");
                break;

            case R.id.eight:
                if (textView.getText().toString().equals("0"))
                    textView.setText("8");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("8");
                    else textView.setText(textView.getText().toString() + "8");
                else
                    textView.setText(textView.getText().toString() + "8");
                break;

            case R.id.nine:
                if (textView.getText().toString().equals("0"))
                    textView.setText("9");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("9");
                    else textView.setText(textView.getText().toString() + "9");
                else
                    textView.setText(textView.getText().toString() + "9");
                break;

            case R.id.zero:
                if (textView.getText().toString().equals("0"))
                    textView.setText("0");
                else if (mathtype != null)
                    if (typeExchange.stringTofloat(textView.getText().toString()) == num1)
                        textView.setText("0");
                    else textView.setText(textView.getText().toString() + "0");
                else
                    textView.setText(textView.getText().toString() + "0");
                break;


            //************************************* 功能区域 ***************************************

            case R.id.AC:
                num1 = 0;
                num2 = 0;
                textView.setText("0");
                break;

            case id.point:
                if (textView.getText().toString().contains("."))
                    break;
                if (textView.getText().toString().equals("0"))
                    textView.setText("0.");
                else
                    textView.setText(textView.getText().toString() + ".");
                break;

            case id.plus_minus:
                float num_plus_minus = 0;
                num_plus_minus = typeExchange.stringTofloat(textView.getText().toString());
                num_plus_minus *= -1;
                if ((int) num_plus_minus == num_plus_minus)
                    textView.setText(typeExchange.intToString((int) num_plus_minus));
                else
                    textView.setText(typeExchange.floatToString(num_plus_minus));
                break;

            case id.percent:
//                percent = "%";
                float num_percent = 0;
                num_percent = typeExchange.stringTofloat(textView.getText().toString());
                num_percent /= 100;
                textView.setText(typeExchange.floatToString(num_percent));
                break;

            case R.id.plus:
                num1 = typeExchange.stringTofloat(textView.getText().toString());
                mathtype = "+";
//                textView.setText("0");
                cal_label = true;
                break;

            case R.id.sub:
                num1 = typeExchange.stringTofloat(textView.getText().toString());
                mathtype = "-";
//                textView.setText("0");
                break;

            case id.multi:
                num1 = typeExchange.stringTofloat(textView.getText().toString());
                mathtype = "*";
//                textView.setText("0");
                break;

            case id.division:
                num1 = typeExchange.stringTofloat(textView.getText().toString());
                mathtype = "/";
//                textView.setText("0");
                break;

            case id.equal:
                num2 = typeExchange.stringTofloat(textView.getText().toString());

                if (mathtype == null) {
                    num1 = num2;

                } else {
                    switch (mathtype) {
                        case "+":
                            num1 += num2;
                            break;

                        case "-":
                            num1 -= num2;
                            break;

                        case "*":
                            num1 *= num2;
                            break;

                        case "/":
                            num1 /= num2;
                            break;


                        default:
                            break;
                    }
                }


                if ((int) num1 == num1)
                    textView.setText(typeExchange.intToString((int) num1));
                else
                    textView.setText(typeExchange.floatToString(num1));
                //防止连续点击"="而进行连续运算
                num1 = 0;
                mathtype = null;
                break;
        }

    }

    private void showTwo() {

        builder = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("帮助")
                .setMessage("计算器的使用\n" +
                        "横屏简单计算器，竖屏复杂计算器").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
                        Toast.makeText(MainActivity.this, "关闭", Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }
}
