package com.qunar.ben.leetcode;

/**
 * Created by ben on 2017/2/7.
 */
public class HeapSort {
    public  static void  sort(int[] arr ,int i){
        int l = i+1;
        for(int m=l/2-1; m>=0 ; m--) heapify(arr,l,m);
    }

    public  static  void heapify(int[] arr, int n ,int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && arr[left]>arr[largest]) largest = left;
        if(right<n && arr[right] >arr[largest]) largest =right;
        if(largest != i){
            int tmp =arr[i] ;
            arr[i] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, n, largest);

        }

    }



    public  static  void heapSort(int[] arr){
        for (int i=arr.length-1;i>=1;i--){
            sort(arr,i);
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] =tmp;

        }
    }

    public static void main(String[] args) {
        int[] arr  =  new int[] {5,3,9,4,6,45};
        heapSort(arr);
        for (int i: arr
             ) {
            System.out.println(i);
        }
    }
}
