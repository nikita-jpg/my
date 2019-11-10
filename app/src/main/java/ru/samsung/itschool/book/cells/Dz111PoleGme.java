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
        OnLongClickListener, Clean {

    private int WIDTH = 10;
    private int HEIGHT = 15;

    private Button[][] cells;
    private int[][] mas=new int[HEIGHT][WIDTH];

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
    protected void generate() {

        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
            }
        for(int i=0;i<5;i++){
            mas[rand()][rand()]=9;
        }
        int chet=0;
        //Заполнение поля
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                chet = 0;
                if (mas[i][j] != 9) {
                    //Верхняя клетка
                    if (0 <= i - 1) if (mas[i - 1][j] == 9) chet++;

                    //Верхние диагонали
                    if ((j + 1 <= WIDTH - 1) && (0 <= i - 1)) {
                        if (mas[i - 1][j + 1] == 9) chet++;
                    }
                    if ((0 <= j - 1) && (0 <= i - 1)) {
                        if (mas[i - 1][j - 1] == 9) chet++;
                    }

                    //клетки справа и слева
                    if (j + 1 <= WIDTH - 1) {
                        if (mas[i][j + 1] == 9) chet++;
                    }
                    if (0 <= j - 1) {
                        if (mas[i][j - 1] == 9) chet++;
                    }

                    //Нижняя клетка
                    if (i + 1 <= HEIGHT - 1) if (mas[i + 1][j] == 9) chet++;

                    //Нижние диагонали
                    if ((j + 1 <= WIDTH - 1) && (i + 1 <= HEIGHT - 1)) {
                        if (mas[i + 1][j + 1] == 9) chet++;
                    }
                    if ((0 <= j - 1) && (i + 1 <= HEIGHT - 1)) {
                        if (mas[i + 1][j - 1] == 9) chet++;
                    }
                    mas[i][j] = chet;
                }
            }
        }
    }


    public void clean(View v,int i,int j){
        cells[i][j+1].setBackgroundColor(Color.GREEN);
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

        if(mas[tappedY][tappedX]==9){
           for(int i=0;i<HEIGHT;i++)
               for(int j=0;j<WIDTH;j++){
                   cells[i][j].setBackgroundColor(Color.BLACK);
               }
        }
        else if(mas[tappedY][tappedX] == 0){
            cells[tappedY][tappedX].setBackgroundColor(Color.GRAY);
            clean(v,tappedY,tappedX);
        }
        else{
            cells[tappedY][tappedX].setTextColor(Color.RED);
            cells[tappedY][tappedX].setText(Integer.toString(mas[tappedY][tappedX]));
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