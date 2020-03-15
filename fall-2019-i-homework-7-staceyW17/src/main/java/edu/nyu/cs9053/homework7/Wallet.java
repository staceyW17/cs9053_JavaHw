package edu.nyu.cs9053.homework7;

import java.util.concurrent.atomic.AtomicReference;

public class Wallet<T> implements ArrayCreator<T> {

    private AtomicReference<T>[] values;
    private int nextPointer;
    private static final int INIT_SIZE = 5;

    Wallet(ArrayCreator<T> creator) {
        this.values = (AtomicReference<T>[]) creator.create(INIT_SIZE);
        this.nextPointer = 0;
    }

    public boolean add(T value){
        if(contain(value) || this.nextPointer >size() || value == null){
            return false;
        }
        else{
            this.values[this.nextPointer].set(value);
            this.nextPointer++;
            return true;
        }
    }

    public boolean contain(T value){
        if(value != null){
            for(int i = 0; i< size(); i++){
                if (value == this.values[i]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean remove(T value){
        if(value != null){
            boolean move = false;
            int j = 0;
            for(int i = 0;i < size();i++){
                if(value == this.values[i]){
                    this.values[i] = null;
                    move = true;
                    j = i;

                }
            }
            if(move){
                for(int i = j ;i < size();i++){
                    this.values[i] = this.values[i++];
                }
                this.nextPointer--;
                return true;
            }
        }

        return false;
    }

    public T get(int index){
        if(index >= this.values.length|| index < 0){
            return null;
        }
        return (T) this.values[index];
    }


    public int size(){
        return this.nextPointer;
    }


}
