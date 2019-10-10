package com.example.demo.config;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * author:lizhaojie
 * 创建日期:2019/9/24-14:01
 */
public class demo {
    public static void main(String[] args) {
//        String str = "abbaccdeff";
//        String c = "";
//        for (int i = 0; i < str.length(); i++) {
//            String temp = str.substring(0, i) + str.substring(i + 1);
//            int idx = temp.indexOf(str.charAt(i));
//            if (idx == -1) {//剩下的字符串中没有，就是唯一的
//                c = String.valueOf(str.charAt(i));
//                //System.out.println(c);
//                break;
//            }
//
//        }
//        System.out.println(c);
        int[] array = {12, 25, 65, 7, 8, 94, 4, 2, 18, 19};
        //冒泡排序
//        boolean flag;
//        for (int i = 0; i < array.length-1; i++) {
//            flag = false;
//            for (int j = 0; j < array.length - 1 - i; j++) {
//                if (array[j] > array[j + 1]){
//                    int t = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = t;
//                    flag = true;
//                }
//            }
//            if(!flag){
//                break;
//            }
//            for (int l = 0; l < array.length; l++) {
//                System.out.print(array[l] + " ,");
//            }
//            System.out.println("");
//        }

        //选择排序
//        for (int i = 0; i < array.length - 1; i++) {
//            int maxIndex = i;
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] > array[maxIndex]) {
//                    maxIndex = j;
//                }
//            }
//            if (maxIndex != i) {
//                int t = array[i];
//                array[i] = array[maxIndex];
//                array[maxIndex] = t;
//            }
//            for (int l = 0; l < array.length; l++) {
//                System.out.print(array[l] + " ,");
//           }
//            System.out.println("");
//        }


//        //插入排序
//        for(int i = 0;i<array.length-1;i++){
//            for (int j = i+1;j>0;j--){
//                if(array[j]<array[j-1]){
//                    int t = array[j-1];
//                    array[j-1] = array[j];
//                    array[j] = t;
//                }
//            }
//            for (int l = 0; l < array.length; l++) {
//                System.out.print(array[l] + " ,");
//            }
//            System.out.println("");
//        }

        //希尔排序
//        int incre = array.length;
//        while (true) {
//            incre = incre / 2;
//            for (int k = 0; k < incre; k++) {
//                for (int i = k + incre; i < array.length; i += incre) {
//                    for (int j = i; j > k; j -= incre) {
//                        if (array[j] < array[j - incre]) {
//                            int temp = array[j - incre];
//                            array[j - incre] = array[j];
//                            array[j] = temp;
//                        } else {
//                            break;
//                        }
//                    }
//                }
//            }if(incre == 1){
//                break;
//            }
//            for (int l = 0; l < array.length; l++) {
//                System.out.print(array[l] + " ,");
//            }
//            System.out.println("");
//        }

        //快速排序
        quickSort(array,0,array.length-1);
        for (int l = 0; l < array.length; l++) {
                System.out.print(array[l] + " ,");
        }
    }

    public static void quickSort(int a[], int l, int r) {
        if (l >= r)
            return;
        int i = l;
        int j = r;
        int key = a[l];
        while (i<j){
            while (i<j&&a[j]>=key)
                j--;
                if(i<j){
                    a[i] = a[j];
                    i++;
                }
                while(i<j&&a[i]<key)
                    i++;
                if(i<j){
                    a[j] = a[i];
                    j--;
                }
        }
        a[i] = key;
        quickSort(a,l,i-1);
        quickSort(a,i+1,r);
    }
    //二分查找法
     public  static  int binarySearch(int[] array,int value){
        int low = 0;
        int high = array.length - 1;

        while(low<=high){
            int middle = low+((high-low)>>1);
            if(value == array[middle]){
                return middle;
            }
            if(value>array[middle]){
                low = middle+1;
            }
            if(value<array[middle]){
                high = middle-1;
            }
        }
        return -1;
     }
}
