package com.example.matthewyamamoto.calc;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import java.math.BigInteger;
import android.widget.Chronometer;
import android.os.SystemClock;



public class MainActivity extends AppCompatActivity {

    private int num, denom;
    public String test(double d){
        String s = String.valueOf(d);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        int denom = 1;
        for (int i = 0; i < digitsDec; i++) {
            d *= 10;
            denom *= 10;
        }

        int num = (int) Math.round(d);

        BigInteger b1 = BigInteger.valueOf(num);
        BigInteger b2 = BigInteger.valueOf(denom);
        BigInteger gcd = b1.gcd(b2);
        int g = gcd.intValue();

        this.num = num / g;
        this.denom = denom /g;
        return String.valueOf(this.num) + "/" + String.valueOf(this.denom);
    }
    double num1 = 0;
    double num2 = 0;
    double num3 = 0;
    double num4 = 0;
    double num5 = 0;
    double num6 = 0;
    double num7 = 0;
    double num8 = 0;
    double num9 = 0;
    double num0 = 0;
    double x = 0;
    double y = 0;
    double sign = 0;
    double result = 0;
    double fractions = 0;
    String display = "";
    long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button start = (Button) findViewById(R.id.start);
        final Button stop = (Button) findViewById(R.id.stop);
        final Button restart = (Button) findViewById(R.id.reset);
        final Chronometer focus = (Chronometer) findViewById(R.id.chron);

        final TextView text = (TextView) findViewById(R.id.text2);
        final Button button1 = (Button) findViewById(R.id.one);
        final Button button2 = (Button) findViewById(R.id.two);
        final Button button3 = (Button) findViewById(R.id.three);
        final Button button4 = (Button) findViewById(R.id.four);
        final Button button5 = (Button) findViewById(R.id.five);
        final Button button6 = (Button) findViewById(R.id.six);
        final Button button7 = (Button) findViewById(R.id.seven);
        final Button button8 = (Button) findViewById(R.id.eight);
        final Button button9 = (Button) findViewById(R.id.nine);
        final Button button0 = (Button) findViewById(R.id.zero);
        final Button Clear = (Button) findViewById(R.id.clear);
        final Button Enter = (Button) findViewById(R.id.Enter);
        final Button add = (Button) findViewById(R.id.add);
        final Button subtract = (Button) findViewById(R.id.subtract);
        final Button multiply = (Button) findViewById(R.id.multiply);
        final Button divide = (Button) findViewById(R.id.divide);
        final Button fraction = (Button) findViewById(R.id.fraction);
        final Button root = (Button) findViewById(R.id.root);
        final Button Delete = (Button) findViewById(R.id.Delete);
        final Button decimal = (Button) findViewById(R.id.decimal);

        focus.setBase(SystemClock.elapsedRealtime());
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                focus.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                focus.start();            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                timeWhenStopped = focus.getBase() - SystemClock.elapsedRealtime();
                focus.stop();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                focus.stop();
                focus.setBase(SystemClock.elapsedRealtime());
                timeWhenStopped = 0;            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    x = Double.parseDouble(display);
                    sign = 1;
                } catch(NumberFormatException nfe) {
                    text.setText("ERROR");
                }
                text.setText("+");
                display = "";
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    x = Double.parseDouble(display);
                    sign = 2;
                } catch(NumberFormatException nfe) {
                    text.setText("ERROR");
                }
                text.setText("-");
                display = "";
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    x = Double.parseDouble(display);
                    sign = 3;
                } catch (NumberFormatException nfe) {
                    text.setText("ERROR");
                }
                text.setText("*");
                display = "";
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    x = Double.parseDouble(display);
                    sign = 4;
                } catch (NumberFormatException nfe) {
                    text.setText("ERROR");
                }
                text.setText("/");
                display = "";
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    sign = 5;
                } catch(NumberFormatException nfe) {
                    text.setText("ERROR");
                }
                text.setText("sqrt");
                display = "";
            }
        });
        fraction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    fractions = Double.parseDouble(display);
                    sign = 6;
                } catch(NumberFormatException nfe) {
                    text.setText("ERROR");
                }
//                test(fractions);
                text.setText(test(fractions));
                display = "";
            }
        });
        Enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    y = Double.parseDouble(display);
                } catch(NumberFormatException nfe) {
                    text.setText("ERROR");
                }
                if(sign == 1){
                    result = x + y;
                    text.setText(String.valueOf(result));
                    display = String.valueOf(result);
                    sign = 0;
                }
                else if(sign == 2){
                    result = x - y;
                    text.setText(String.valueOf(result));
                    display = String.valueOf(result);
                    sign = 0;
                }
                else if(sign == 3){
                    result = x * y;
                    text.setText(String.valueOf(result));
                    display = String.valueOf(result);
                    sign = 0;
                }
                else if(sign == 4){
                    result = x / y;
                    text.setText(String.valueOf(result));
                    display = String.valueOf(result);
                    sign = 0;
                }
                else if(sign == 5){
                    result = Math.sqrt(y);
                    text.setText(String.valueOf(result));
                    display = String.valueOf(result);
                    sign = 0;
                }
                else if(sign == 6){
                    result = 0;
                    text.setText(String.valueOf(result));
                    display = String.valueOf(result);
                    sign = 0;
                }
                else{

                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num1 = 1;
                display = display + "1";
                text.setText(display);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num2 = 2;
                display = display + "2";
                text.setText(display);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num3 = 3;
                display = display + "3";
                text.setText(display);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num4 = 4;
                display = display + "4";
                text.setText(display);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num5 = 5;
                display = display + "5";
                text.setText(display);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num6 = 6;
                display = display + "6";
                text.setText(display);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num7 = 7;
                display = display + "7";
                text.setText(display);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num8 = 8;
                display = display + "8";
                text.setText(display);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num9 = 9;
                display = display + "9";
                text.setText(display);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                num0 = 0;
                display = display + "0";
                text.setText(display);
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            public String method(String str) {
                if (str != null && str.length() > 0) {
                    str = str.substring(0, str.length() - 1);
                }
                return str;
            }

            public void onClick(View v) {
                display = method(display);
                text.setText(display);
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display = display + ".";
                text.setText(display);
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display = "";
                num1 = 0;
                num2 = 0;
                num3 = 0;
                num4 = 0;
                num5 = 0;
                num6 = 0;
                num7 = 0;
                num8 = 0;
                num9 = 0;
                num0 = 0;
                text.setText(display);
            }
        });



    }


}
