package com.example.myapplication.eventbus;

public class MessageEvent {

    private String mes;

    public MessageEvent(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
