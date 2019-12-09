package ru.samsung.itschool.book.equation243;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Dnevnik extends Activity implements View.OnClickListener {
    Button pon_One_Dz_Btn;
    Button save_Btn;
    EditText btn_Text;
    String a;
    AlertDialog.Builder bilder;
    AlertDialog al;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dnevnik);

        pon_One_Dz_Btn = findViewById(R.id.ponOneDzBtn);
        pon_One_Dz_Btn.setOnClickListener(this);

        save_Btn=findViewById(R.id.saveBtn);
        btn_Text=findViewById(R.id.ponPervDzText);

        bilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.activity_dz, null);
        bilder.setView(view)
                .setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        al = bilder.create();
        al.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.ponOneDzBtn):
                al.show();
                break;
        }
    }
}
