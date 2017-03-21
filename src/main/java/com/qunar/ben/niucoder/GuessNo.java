package com.qunar.ben.niucoder;

/**
 * Created by ben on 2017/3/9.
 */
public class GuessNo {
    public static void main(String[] args) {

        int[] arr ={3,7,8,2,1,9,6,4};
        int res =0;
        int min =0;
        int max =0;
        for (int val:arr){
            min = val<min?val:min;
            max = val>max?val:max;
            res^=val;
        }
        for(int i=min;i<=max;i++){
            res^=i;
        }
        System.out.print(res);

//        quicksort(arr,0,arr.length-1);
//        for (int val:arr){
//            System.out.println(val);
//        }
    }

    public  static void quicksort(int[] arr, int low, int high){
        int start = low;
        int end = high;
        if(low<high){
            int p = arr[low];

            while (low<high){
                while (low<high&&arr[high]>=p) --high;
                arr[low] = arr[high];
//                while (low<high&&arr[low]<=p) ++low;
                arr[high] = arr[low];

            }
            arr[low] =p;
            quicksort(arr,start,low-1);
            quicksort(arr,low+1,end);
        }

    }

    public  void getNum(){
        int[] arr ={3,7,8,5,2,1,9,5,4};
        int min =0;
        int max=0;
        int[] res = new int[2];
        quicksort(arr,0,arr.length-1);
        for (int val:arr){
            System.out.println(val);
        }
        for (int val:arr){
            min = val<min?val:min;
            max = val>max?val:max;
        }

        int  interval = max -min +1;
        if (interval==arr.length){
            res[0]= max+1;
            res[1] = min-1;
        }else {
            for (int i=0;i<interval;i++){
            }
        }

    }
}
