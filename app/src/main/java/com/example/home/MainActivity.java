package com.example.home;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends FragmentActivity {
    float sum,a;
    int f=0;
    EditText edit;
    TextView text;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.text);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1: {
                        if(!edit.getText().toString().equals(""))
                            a = Float.parseFloat(edit.getText().toString());
                        f = 1;
                        sum += a;
                        text.setText("" + sum);
                        edit.setText("");
                        break;
                    }
                    case R.id.button2: {
                        if(!edit.getText().toString().equals(""))
                            a = Float.parseFloat(edit.getText().toString());
                        f = 2;
                        sum -= a;
                        text.setText("" + sum);
                        edit.setText("");
                        break;
                    }
                    case R.id.button3: {
                        if(!edit.getText().toString().equals(""))
                            a = Float.parseFloat(edit.getText().toString());
                        else{
                            a=1;
                        }
                        f = 3;
                        if(sum!=0) sum *= a;
                        else sum=a;
                        text.setText("" + sum);
                        edit.setText("");
                        break;
                    }
                    case R.id.button4: {
                        if(!edit.getText().toString().equals(""))
                            a = Float.parseFloat(edit.getText().toString());
                        f = 4;
                        if (sum != 0) {
                            sum /= a;
                        }
                        text.setText("" + sum);
                        edit.setText("");
                        break;
                    }
                    case R.id.button5: {
                        if(!edit.getText().toString().equals(""))
                            a = Float.parseFloat(edit.getText().toString());
                        switch (f) {
                            case 1: {
                                sum += a;

                                break;
                            }
                            case 2: {
                                sum -= a;
                                break;
                            }
                            case 3: {
                                sum *= a;

                                break;
                            }
                            case 4: {
                                if (sum != 0) {
                                    sum /= a;
                                }

                                break;
                            }
                            default:{
                                break;
                            }
                        }
                        text.setText("" + sum);
                        edit.setText("");
                        a=0;
                    }
                }
            }
        };
        b1.setOnClickListener(clickListener);
        b2.setOnClickListener(clickListener);
        b3.setOnClickListener(clickListener);
        b4.setOnClickListener(clickListener);
        b5.setOnClickListener(clickListener);


    }



}
