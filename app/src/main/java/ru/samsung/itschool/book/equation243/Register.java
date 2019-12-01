package ru.samsung.itschool.book.equation243;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity implements View.OnClickListener {
    static final int RESULT_OK=1;
    EditText nameV;
    EditText passwordV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

        Button register=findViewById(R.id.button);
        register.setOnClickListener(this);

        nameV=findViewById(R.id.name);
        passwordV=findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        String name=nameV.getText().toString();
        String password = passwordV.getText().toString();

        Intent i = new Intent(Register.this,Dnevnik.class);
        startActivity(i);
<<<<<<< develop
        i.putExtra("na",name);
        i.putExtra("pa",password);
=======
>>>>>>> Dz3.1Norm

    }
}
