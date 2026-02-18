package com.sk.jarvis.stack;

import com.sk.jarvis.Node;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListStack<T> implements IStack<T> {

    private Node<T> top;
    private int size;

    public LinkedListStack(){
        this.top = null;
    }

    public LinkedListStack(T element){
        push(element);
    }

    @Override
    public boolean push(T element) {
        Node<T> newNode = Node.of(element);
        if (!this.isEmpty()) {
            newNode.setNext(this.top);
        }
        this.top = newNode;
        this.size++;
        return true;
    }

    @Override
    public Node<T> pop() {
        if(!isEmpty()){
            Node<T> temp = this.top;
            this.top = temp.getNext();
            //temp.setNext(null);
            this.size--;
            return temp;
        }
        return null;
    }

    @Override
    public T peek() {
        return this.top.getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T element) {
        Node<T> temp = this.top;
        while(temp.getNext()!=null){
            if(temp.getData().equals(element)){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public void addAll(IStack<T> args) {
        Node<T> temp = this.top;
        Node<T> newTop = args.pop();
        while(newTop!=null){
            newTop.setNext(temp);
            this.top = newTop;
            temp =this.top;
            newTop = args.pop();
            this.size++;
        }

    }

    @Override
    public boolean isEmpty() {
        return this.size ==0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListStackIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        IStack.super.forEach(action);
    }

    private class LinkedListStackIterator implements Iterator<T>{
        Node<T> topper= top;

        @Override
        public boolean hasNext() {
            return topper.getNext()!=null;
        }

        @Override
        public T next() {
            T result = topper.getData();
            topper = topper.getNext();
            return result;
        }
    }

}
