package com.DailyAssignment.java;

import java.util.Scanner;

public class SearchIndex {

    // Returns index of key in arr[l..h]
    // if key is present, otherwise returns -1
    static int search(int arr[], int l, int h, int key)
    {
        if (l > h)
            return -1;
 
        int mid = (l + h) / 2;
        if (arr[mid] == key)
            return mid;
 
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) {
            /* As this subarray is sorted, we
               can quickly check if key lies in
               half or other half */
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);
            /*If key not lies in first half subarray,
           Divide other half  into two subarrays,
           such that we can quickly check if key lies
           in other half */
            return search(arr, mid + 1, h, key);
        }
 
        /* If arr[l..mid] first subarray is not sorted,
           then arr[mid... h] must be sorted subarray*/
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);
 
        return search(arr, l, mid - 1, key);
    }
 
    // main function
    public static void main(String args[])
    {
    	System.out.println("ENter the lenghth of an array:");//taking array lenght from user
    	Scanner sc= new Scanner(System.in);//scanner class to accept the number
    	int n= sc.nextInt();
    	
    	System.err.println("\nEnter the numbers of array: ");//taking the array 
    	
    	int[] arr= new int[n];
    	for (int i=0;i<n;i++)
    	{
    		arr[i] = sc.nextInt();
    	}
        System.out.println("\nENter the Target NUmber :");//taking the target number to find the occurrence
        int key = sc.nextInt();
       
        int i = search(arr, 0, n - 1, key);//calling the function to search the index
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}