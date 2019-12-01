package ru.samsung.itschool.book.equation243;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    // Вызывается при создании Активности

    EditText name;
    EditText password;
    TextView result;
    Button button1;
    int Re_Ok=1;
    final int RESULT_OK=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        result = (TextView) findViewById(R.id.result);
        button1=(Button) findViewById(R.id.button7);

        button1.setOnClickListener(this);

    }

    public void onClick(View v) {
        if(v.getId()==R.id.button7) {
            if ( (password.getText().toString()).equals("toor")) {
                result.setTextColor(Color.GREEN);
                result.setText("Верно");
                Intent i = new Intent(MainActivity.this,Dnevnik.class);
                startActivity(i);

            } else {
                result.setTextColor(Color.RED);
                result.setText("Вы ошиблись в логине или пароле");

                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);

            }
        }
    }

}
