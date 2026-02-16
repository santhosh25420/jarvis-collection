package com.sk.jarvis.list;

import com.sk.jarvis.Node;

import java.util.Iterator;
import java.util.function.Consumer;

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
        Node<T> newNode = newNode(element);
        if(this.head != null){
            Node<T> current = this.head;
            this.head = newNode;
            this.head.setNext(current);
        }else{
            this.head = newNode;
        }
        this.size++;
    }

    @Override
    public void remove() {
        Node<T> current = this.head;
        while(current.getNext().getNext()!=null){
            current = current.getNext();
        }
        current.setNext(null);
        this.size--;
    }

    @Override
    public void removeAtBeginning() {
        Node<T> current = this.head;
        this.head = current.getNext();
        current.setNext(null);
        this.size--;
    }

    @Override
    public T get(int index) {
        if(index>= this.getSize()){
            return null;
        }
        if(index<=0 && this.head!=null){
            return this.head.getData();
        }else{
            int counter =0;
            Node<T> current = this.head;
            while(current.getNext()!=null && counter!= index){
                current = current.getNext();
                counter++;
            }
            return current.getData();
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void addAll(IList<? extends T> list) {
        for(T element: list){
            this.add(element);
            this.size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = this.head;
        while(current!=null){
            if(current.getData() == element){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    private Node<T> newNode(T element){
        return new Node<>(element);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        IList.super.forEach(action);
    }

    private class LinkedListIterator implements Iterator<T>{
        Node<T> current = head;
        @Override
        public boolean hasNext() {
            return current.getNext()!=null;
        }

        @Override
        public T next() {
            return current.getNext().getData();
        }
    }
}
