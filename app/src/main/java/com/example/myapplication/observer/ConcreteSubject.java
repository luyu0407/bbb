package com.example.myapplication.observer;

public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.response();
        }
    }
}
