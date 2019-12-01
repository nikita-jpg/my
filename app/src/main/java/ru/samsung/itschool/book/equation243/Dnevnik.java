package ru.samsung.itschool.book.equation243;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class Dnevnik extends Activity {
    TextView dear;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dnevnik);
<<<<<<< develop
        dear=findViewById(R.id.dear);
        Intent i = new Intent();
        dear.setText("Dear, "+i.getStringExtra("na")+i.getStringExtra("pa"));
=======
>>>>>>> Dz3.1Norm
    }
}
