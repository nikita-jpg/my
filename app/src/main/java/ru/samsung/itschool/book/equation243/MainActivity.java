package ru.samsung.itschool.book.equation243;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity  {
    // Вызывается при создании Активности

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
        final EditText name= (EditText) findViewById(R.id.name);
        final EditText password= (EditText) findViewById(R.id.password);
        final TextView result = (TextView) findViewById(R.id.result);
        Button button1=(Button) findViewById(R.id.button7);

        View.OnClickListener onClickListener =new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button7) {
                    if ( (password.getText().toString()).equals("toor")) {
                        result.setTextColor(Color.GREEN);
                        result.setText("Верно");

                    } else {
                        result.setTextColor(Color.RED);
                        result.setText("Вы ошиблись в логине или пароле");
                        name.setText("");
                        password.setText("");
                    }
                }
            }
        };
        button1.setOnClickListener(onClickListener);

    }
}
