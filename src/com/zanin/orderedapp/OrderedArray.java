package com.zanin.orderedapp;

public class OrderedArray {
    private long[] listNumber;
    private int amountElements;
    public OrderedArray(int max){
        listNumber = new long[max];
        amountElements = 0;
    }
    public int size(){
        return amountElements;
    }
    public int findKey(long searchKey) {
        int lowerBound = 0;
        int upperBound = amountElements - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (listNumber[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return amountElements;
            } else {
                if (listNumber[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int j;
        for(j=0; j< amountElements; j++){
            if(listNumber[j] > value){
                break;
            }
        }
        for(int k = amountElements; k>j; k--){
            listNumber[k] = listNumber[k-1];
        }
        listNumber[j] = value;
        amountElements++;
    }

    public boolean delete(long value){
        int j = findKey(value);
        if(j== amountElements){
            return false;
        } else {
            for(int k = j; k< amountElements; k++){
                listNumber[k] = listNumber[k+1];
            }
        amountElements--;
        return true;
        }
    }

    public void display(){
        for(int j = 0; j< amountElements; j++){
            System.out.print(listNumber[j] + " ");
        }
        System.out.println();
    }
}

