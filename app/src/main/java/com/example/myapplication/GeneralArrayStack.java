package com.example.myapplication;

import java.lang.reflect.Array;

public class GeneralArrayStack<T> {

    private static final int DEAULT_SIZE = 12;
    private T[] mArray;
    private int mCount;

    public GeneralArrayStack(Class<T> type){
        this(type,DEAULT_SIZE);
    }

    public GeneralArrayStack(Class<T> type, int deaultSize) {
//        mArray = new T[DEAULT_SIZE];
        mArray = (T[]) Array.newInstance(type,deaultSize);
        mCount = 0;
    }

    public void push(T value){
        mArray[mCount++] = value;
    }


    public T peek(){
        return mArray[mCount-1];
    }

    public T pop(){
        T value = mArray[mCount-1];
        mCount--;
        return value;
    }

}
