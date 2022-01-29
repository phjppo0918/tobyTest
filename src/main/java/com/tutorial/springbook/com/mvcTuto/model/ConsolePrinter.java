package com.tutorial.springbook.com.mvcTuto.model;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
