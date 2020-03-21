package com.example.my;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ListView;

public class MainActivity extends Activity {
    String[] myArr = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv;
        lv = (ListView) findViewById(R.id.list_View);
        MyMonthAdapter adapter = new MyMonthAdapter(this,makeMonth());
        lv.setAdapter(adapter);

    }

    // Метод cоздания массива месяцев
    Person[] makeMonth() {
        Person[] arr = new Person[12];

// Названия месяцев
        String[] monthArr = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
// Среднесуточная температура
        double[] tempArr = {-12.7, -11.3, -4.5, 7.7, 19.3, 23.9, 23.5, 22.8, 16.0, 5.2, -0.3, -9.3};
// Количество дней
        int[] dayArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

// Сборка месяцев
        for (int i = 0; i < arr.length; i++) {
            Person month = new Person();
            month.name = "Bill Gates";
            month.money="100000$";
            month.country="USA";
            arr[i] = month;
        }
        return arr;
    }
}
