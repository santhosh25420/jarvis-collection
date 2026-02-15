package com.sk.jarvis.array;

public interface Array<T> extends Iterable<T> {

    public void add( T element);
    public T get(int index);
    public void put(int index, T element);
    public int getSize();
    public void remove(int index);

}
