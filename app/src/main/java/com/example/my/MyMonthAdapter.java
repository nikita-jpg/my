package com.example.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyMonthAdapter extends ArrayAdapter<Person> {
    public MyMonthAdapter(@NonNull Context context, Person[] resource) {
        super(context, R.layout.adapter_item,resource);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final Person month = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

// Заполняем адаптер
        ((TextView) convertView.findViewById(R.id.textView_name)).setText(month.name);
        ((TextView) convertView.findViewById(R.id.textView_money)).setText(String.valueOf(month.money));
        ((TextView) convertView.findViewById(R.id.textView_country)).setText(String.valueOf(month.country));
// Выбираем картинку для месяца

        return convertView;
    }
}
