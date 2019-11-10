package ru.samsung.itschool.book.cells;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;

import task.Stub;
import task.Task;

public class Dz111PoleGme extends Activity implements OnClickListener,
        OnLongClickListener {

    private int WIDTH = 10;
    private int HEIGHT = 15;

    private Button[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();

    }

    int rand(){
        Random random=new Random();

        return (int)(Math.random()*10);
    }
    void generate() {

        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
            }
        for(int i=0;i<5;i++){
            cells[rand()][rand()].setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public boolean onLongClick(View v) {

        return false;
    }

    @Override
    public void onClick(View v) {
        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);
        int color = 0;

            for (int j = 0; j < WIDTH; j++) {
                color = ((ColorDrawable)cells[tappedY][j].getBackground()).getColor();
                if (color == Color.WHITE) cells[tappedY][j].setBackgroundColor(Color.BLACK);
                else cells[tappedY][j].setBackgroundColor(Color.WHITE);
            }
            for (int i = 0; i < HEIGHT; i++) {
                color = ((ColorDrawable) cells[i][tappedX].getBackground()).getColor();
                if (color == Color.WHITE) cells[i][tappedX].setBackgroundColor(Color.BLACK);
                else cells[i][tappedX].setBackgroundColor(Color.WHITE);
            }

    }

	/*
     * NOT FOR THE BEGINNERS
	 * ==================================================
	 */

    int getX(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[1]);
    }

    int getY(View v) {
        return Integer.parseInt(((String) v.getTag()).split(",")[0]);
    }

    void makeCells() {
        cells = new Button[HEIGHT][WIDTH];
        GridLayout cellsLayout = (GridLayout) findViewById(R.id.CellsLayout);
        cellsLayout.setColumnCount(WIDTH);
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
                cells[i][j].setTag(i + "," + j);
                cellsLayout.addView(cells[i][j]);
            }
    }

}