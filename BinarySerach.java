package com.example.algo;

import java.util.*;

public class binarysearch {
    public static void main(String[] args){

        int SIZE = (int) (Math.random() * 50) + 1;

        int[] r_data = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            r_data[i] = (int) (Math.random() * 100);
        }

        Arrays.sort(r_data);
        System.out.println(Arrays.toString(r_data));

        boolean search = b_search(r_data,1);
        System.out.println(search);



    }

    public static boolean b_search(int[] arr, int n){
        int size = arr.length;
        if(size == 1 ){
            if(arr[0] == n)
                return true;
            else
                return false;
        }else{
            int mid = (int)(size/2);
            if(arr[mid] == n){
                return true;
            }
            else if(arr[mid] > n){
                int[] left = Arrays.copyOf(arr,mid);
                return b_search(left,n);
            }else if(arr[mid] < n){
                int[] right = Arrays.copyOfRange(arr,mid,size);
                return b_search(right, n);
            }else{
                return false;
            }
        }
    }

}
