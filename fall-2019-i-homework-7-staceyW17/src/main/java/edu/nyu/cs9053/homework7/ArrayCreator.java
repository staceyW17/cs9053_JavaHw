package edu.nyu.cs9053.homework7;

public interface ArrayCreator<T> {
    default T[] create(int arraySize){
        return (T[])new Object[arraySize];
    }
}
