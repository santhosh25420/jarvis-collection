package com.sk.jarvis.list;

import com.sk.jarvis.Node;

public class LinkedList<T> implements IList<T>{


    private int size;
    private Node<T> head;

    public LinkedList(){
        this.head =null;
    }

    public LinkedList(T element){
        add(element);
    }

    @Override
    public Node<T> get(){
        return this.head;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = newNode(element);
        if(this.isEmpty()){
            this.head = newNode;
        }else{
            Node<T> current = this.head;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size++;
    }

    @Override
    public void addAtBeginning(T element) {

    }

    @Override
    public void remove() {

    }

    @Override
    public void removeAtBeginning() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void removeAt(int index) {

    }

    @Override
    public void addAt(int index, T element) {

    }

    @Override
    public void addAll(IList<? extends T> list) {

    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    private Node<T> newNode(T element){
        return new Node<>(element);
    }
}
