package com.sk.jarvis.array;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class DynamicArray <T> implements Array<T>{
    private int capacity=10;
    private int size =0;
    private static int growthFactor = 2;
    private T[] array;
    private  Logger log = Logger.getLogger("DynamicArray");

    public DynamicArray(){
        this.array = (T[]) new Object[capacity];
    }
    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        if(isFull()){
            resize();
        }
        this.array[size] = element;
        this.size++;
    }

    @Override
    public T get(int index) {
        return this.array[index];
    }

    @Override
    public void put(int index, T element) {
        this.array[index] = element;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void remove(int index) {
        if(index>=size){
            log.info("Invalid index");
        }else{
            for(int j=index+1;j<this.size-1;j++){
                this.array[j-1] = this.array[j];
            }
        }
        this.size--;
    }

    private boolean isFull(){
        return this.size == this.capacity;
    }

    private void resize(){
        int newCapacity = capacity* growthFactor;
        T[] newArray = (T[]) new Object[newCapacity];
        for(int i=0;i<this.size;i++){
            newArray[i] = this.array[i];
        }
        this.capacity = newCapacity;
        this.array = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for(int i=0;i<this.size;i++){
            action.accept(this.array[i]);
        }
    }

    class DynamicArrayIterator implements Iterator<T>{
        int i=0;
        @Override
        public boolean hasNext() {
            return i<size;
        }

        @Override
        public T next() {
            return array[i++];
        }
    }
}
