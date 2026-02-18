package com.sk.jarvis.list;


import com.sk.jarvis.Node;

public interface IList<T> extends Iterable<T>{


    public void add(T element);
    public void addAtBeginning(T element);
    public void remove();
    public void removeAtBeginning();
    public T get(int index);
    public int getSize();
    public void addAll(IList<T> list);
    public boolean isEmpty();
    public boolean contains(T element);
    public Node<T> get();
}
