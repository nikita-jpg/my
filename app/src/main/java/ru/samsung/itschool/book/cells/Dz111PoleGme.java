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
        OnLongClickListener{

    private int WIDTH = 10;
    private int HEIGHT = 15;
    public boolean log = false;

    private Button[][] cells;
    private int[][] mas=new int[HEIGHT][WIDTH];
    public int colBomb=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        makeCells();

        generate();

    }

    int rand(int max){
        Random random=new Random();

        return (int)(Math.random()*10);
    }
    protected void generate() {

        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(this);
                cells[i][j].setOnLongClickListener(this);
            }
        for(int i=0;i<15;i++){
            mas[rand(10)][rand(15)]=9;
        }
        for(int i=0;i<HEIGHT;i++){
            for(int j=0;j<WIDTH;j++){
                if(mas[i][j]==9)colBomb++;
            }
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


    public boolean clean(View v,int i,int j){
        //Верхняя клетка
        if (0 <= i - 1&& mas[i-1][j]!=10 ) {
            if (mas[i - 1][j] == 0) {
                mas[i-1][j]=10;
                clean( v,i-1, j);
            }
            else if (mas[i - 1][j] != 9 && 0<mas[i-1][j]) {
                mas[i-1][j]*=-1;
            }
        }

        //Верхние диагонали
        if ((j + 1 <= WIDTH - 1) && (0 <= i - 1)&& mas[i-1][j+1]!=10) {
            if (mas[i - 1][j+1] == 0) {
                mas[i-1][j+1]=10;
                clean(v,i-1, j+1);
            }
            else if (mas[i - 1][j+1] != 9 && 0<mas[i-1][j+1]) {
                mas[i-1][j+1]*=-1;
            }
        }
        if ((0 <= j - 1) && (0 <= i - 1)&& mas[i-1][j-1]!=10) {
            if (mas[i - 1][j-1] == 0) {
                mas[i-1][j-1]=10;
                clean(v,i-1, j-1);
            }
            else if (mas[i - 1][j-1] != 9 && 0<mas[i-1][j-1]) {
                mas[i-1][j-1]*=-1;
            }
        }

        //клетки справа и слева
        if (j + 1 <= WIDTH - 1 && mas[i][j+1]!=10) {
            if (mas[i][j+1] == 0) {
                mas[i][j+1]=10;
                clean(v,i, j+1);
            }
            else if (mas[i][j+1] != 9 && 0<mas[i][j+1]) {
                mas[i][j+1]=10;
            }
        }
        if (0 <= j - 1&& mas[i][j-1]!=10) {
            if (mas[i][j-1] == 0) {
                mas[i][j-1]=10;
                clean(v,i, j-1);
            }
            else if (mas[i][j-1] != 9 && 0<mas[i][j-1]) {
                mas[i][j-1]*=-1;
            }
        }

        //Нижняя клетка
        if (i + 1 <= HEIGHT - 1 && mas[i+1][j]!=10) if (mas[i + 1][j] == 9){
            if (mas[i + 1][j] == 0) {
                mas[i+1][j]=10;
                clean(v,i+1, j);
            }
            else if (mas[i + 1][j] != 9 && 0<mas[i+1][j]) {
                mas[i+1][j]*=-1;
            }
        }

        //Нижние диагонали
        if ((j + 1 <= WIDTH - 1) && (i + 1 <= HEIGHT - 1)&& mas[i+1][j+1]!=10) {
            if (mas[i + 1][j+1] == 0) {
                mas[i+1][j+1]=10;
                clean(v,i+1, j+1);

            }
            else if (mas[i + 1][j+1] != 9 && 0<mas[i+1][j+1]) {
                mas[i+1][j+1]*=-1;
            }
        }
        if ((0 <= j - 1) && (i + 1 <= HEIGHT - 1) && mas[i+1][j-1]!=10) {
            if (mas[i + 1][j-1] == 0) {
                mas[i+1][j-1]=10;
                clean(v,i+1, j-1);
            }
            else if (mas[i + 1][j-1] != 9 && 0<mas[i+1][j-1]) {
                mas[i+1][j-1]*=-1;
            }
        }
        return true;
    }

    @Override
    public boolean onLongClick(View v) {
        if(!log) {
            Button tappedCell = (Button) v;

            int tappedX = getX(tappedCell);
            int tappedY = getY(tappedCell);

            cells[tappedY][tappedX].setBackgroundColor(Color.BLUE);
            int chet = 0;
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    int color = ((ColorDrawable) cells[i][j].getBackground()).getColor();
                    if ((color == Color.BLUE) && (mas[i][j] == 9)) chet++;
                }
            }
            if (chet == colBomb) {
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        cells[i][j].setTextColor(Color.WHITE);
                        cells[i][j].setText("0");
                        cells[i][j].setBackgroundColor(Color.WHITE);
                    }
                }
                log = true;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(!log) {
            Button tappedCell = (Button) v;

            int tappedX = getX(tappedCell);
            int tappedY = getY(tappedCell);

            if (mas[tappedY][tappedX] == 9) {

                System.exit(0);
                for (int i = 0; i < HEIGHT; i++)
                    for (int j = 0; j < WIDTH; j++) {
                        if (mas[i][j] == 9) cells[i][j].setBackgroundColor(Color.BLACK);
                    }

            } else if (mas[tappedY][tappedX] == 0) {
                cells[tappedY][tappedX].setBackgroundColor(Color.GRAY);
                mas[tappedY][tappedX] = 10;
                clean(v, tappedY, tappedX);
                for (int i = 0; i < HEIGHT; i++)
                    for (int j = 0; j < WIDTH; j++) {
                        if (mas[i][j] == 10) cells[i][j].setBackgroundColor(Color.GRAY);
                        else if (mas[i][j] < 0) {
                            mas[i][j] *= -1;
                            cells[i][j].setBackgroundColor(Color.GRAY);

                            cells[i][j].setTextColor(Color.RED);
                            cells[i][j].setText(Integer.toString(mas[i][j]));
                        }
                    }
            } else {
                cells[tappedY][tappedX].setBackgroundColor(Color.GRAY);
                cells[tappedY][tappedX].setTextColor(Color.RED);
                cells[tappedY][tappedX].setText(Integer.toString(mas[tappedY][tappedX]));
            }

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