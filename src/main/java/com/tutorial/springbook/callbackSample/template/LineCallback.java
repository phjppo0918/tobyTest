package com.tutorial.springbook.callbackSample.template;

public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
