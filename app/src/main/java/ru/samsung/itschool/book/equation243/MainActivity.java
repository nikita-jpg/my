package ru.samsung.itschool.book.equation243;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
        public void solveEquation(View view) {
             // ax+b=c
            double a = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_a)).getText().toString());
            double b = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_b)).getText().toString());
            double c = Double.parseDouble( ((EditText)
                    findViewById(R.id.coefficient_c)).getText().toString());
            TextView result = (TextView) findViewById(R.id.result);
            double D=b*b-4*a*c;
            if(0<D){
                result.setText("X1 = " + String.valueOf((double)(-b-Math.sqrt(D))/(2*a)) +"\n"+"X2 = " + String.valueOf((double)(-b+Math.sqrt(D))/(2*a))  );

            }
            else if(D==0){
                result.setText("X = " + String.valueOf(  (double)(-b/(2*a)) ));
            }
            else result.setText("No ruts");

        }

}
