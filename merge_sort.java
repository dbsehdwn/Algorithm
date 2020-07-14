package com.example.algo;
import java.util.*;

public class mergesort {
    public static void main(String[] args) {
        int SIZE = (int) (Math.random() * 50) + 1;

        int[] r_data = new int[SIZE];
        int[] sort_data = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            r_data[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(r_data));
        sort_data = splite_merge(r_data);
        System.out.println(Arrays.toString(sort_data));


    }

    public static int[] splite_merge(int[] data){
        int size = data.length;
        if(size == 1){
            return data;
        }else{
            int mid = (int)(size/2);
            int[] left = new int[mid-1];
            int[] right = new int[size - mid];
            left = splite_merge(Arrays.copyOf(data,mid));
            right = splite_merge(Arrays.copyOfRange(data,mid,size));
            return merge(left,right);
        }

    }

    public static int[] merge(int[] left, int[] right){
        int l_size = left.length;
        int r_size = right.length;
        int[] data = new int[l_size + r_size];

        int l_index = 0;
        int r_index = 0;
        int d_index = 0;

        while(l_index < l_size && r_index < r_size){
            //System.out.println("1 : "+l_index+" , "+ d_index +" , "+r_index);
            if(left[l_index] >= right[r_index]){
                data[d_index] = right[r_index];
                d_index++;
                r_index++;
            }else{
                data[d_index] = left[l_index];
                d_index++;
                l_index++;
            }

        }

        while(l_index < l_size){
            //System.out.println("2 : "+l_index+" , "+ d_index +" , "+r_index);
            data[d_index] = left[l_index];
            d_index++;
            l_index++;
        }

        while(r_index < r_size){
            //System.out.println("3 : "+l_index+" , "+ d_index +" , "+r_index);
            data[d_index] = right[r_index];
            d_index++;
            r_index++;
        }


        return data;
    }
}
