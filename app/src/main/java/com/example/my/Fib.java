package com.example.my;

import java.util.ArrayList;

public class Fib {
    public void Fib(){
        ArrayList<Long> list = new ArrayList<>();
        list.add((long) 1);
        list.add((long) 2);
        for(int i=1;i<99;i++){
            list.add(list.get(i-1)+list.get(i));
        }

    }
}
