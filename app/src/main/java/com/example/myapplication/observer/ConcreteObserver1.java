package com.example.myapplication.observer;

public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("ConcreteObserver1 观察者类1 响应");
    }
}
