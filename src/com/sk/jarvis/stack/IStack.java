package com.sk.jarvis.stack;

import com.sk.jarvis.Node;

public interface IStack<T> extends Iterable<T>{

    public boolean push(T element);
    public Node<T> pop();
    public T peek();
    public int size();
    public boolean contains(T element);
    public void addAll(IStack<T> args);
    public boolean isEmpty();
}
