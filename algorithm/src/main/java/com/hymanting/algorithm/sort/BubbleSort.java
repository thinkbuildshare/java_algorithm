package com.hymanting.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author hxchen
 * @Date 2021/2/25
 * yes
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 10, 1, 20};
        sort(a);
        System.out.println(Arrays.toString(a));

        int[] a2 = {4, 5, 6, 7, 8};
        sortV2(a2);
        System.out.println(Arrays.toString(a2));
    }


    // 冒泡排序基础版
    // 一组数5, 8, 10, 1, 20
    // 两两比较，小的挪到左边，直到所有数有序
    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length - 1; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    //冒泡排序优化版，对于某一轮如果已经排好序了，则直接返回
    public static void sortV2(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            boolean allOrdered = true;
            for(int j = i + 1; j < arr.length - 1; j++) {
                if(arr[i] > arr[j]) {
                    allOrdered = false;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if(allOrdered) {
                break;
            }
        }
    }

    public <T> void sort(T[] arr) {

    }
}

