package com.example.myapplication;

import java.util.Stack;

public class    Myqueen {

    private Stack stackIn = new Stack();
    private Stack stackOut =new Stack();

    public void push(Integer n){
        while (!stackOut.empty()){
            stackIn.push(stackOut.pop());
        }
        stackIn.push(n);

    }

    public Object pop(){
        while (!stackIn.empty()){
            stackOut.push(stackIn.pop());
        }

        return stackOut.pop();
    }

}
