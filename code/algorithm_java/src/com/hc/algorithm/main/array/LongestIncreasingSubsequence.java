package com.hc.algorithm.main.array;

/**
 * 给定一个整数列表，找出它的长度最长的递增子序列
 * */
public class LongestIncreasingSubsequence {

    public static void solve(int[] array) {
        // lengthArray store the longest increase subsequence of each element in array[]
        int[] lengthArray = new int[array.length];
        // set the longest increase subsequence of each element to 1 by default
        for (int i = 0; i < lengthArray.length; i++) {
            lengthArray[i] = 1;
        }

        // previousElementArray store the previous element's index in array[]
        int[] previousElementArray = new int[array.length];
        // set index to 0 by default
        for (int i = 0; i < previousElementArray.length; i++) {
            previousElementArray[i] = 0;
        }

        // loop array[], for each element in array[], find out the length of longest increase subsequence for it,
        // and find out it's preview element's index in the increase subsequence

        for (int i = 1; i < array.length; i++) {  // start from 1
            // for each element in array[], compare it with all previous element in array[]
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    int length = lengthArray[j] + 1;
                    if (length >= lengthArray[i]) {  // always record the latest element
                        lengthArray[i] = length;
                        previousElementArray[i] = j;
                    }
                }
            }
        }

        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < lengthArray.length; i++) {
            if (lengthArray[i] > maxLength) {
                maxLength = lengthArray[i];
                maxIndex = i;
            }
        }
        System.out.println("longest increase subsequence length is " + maxLength);  // longest increase subsequence length is 5

        int[] result = new int[maxLength];
        int index = maxIndex;
        for (int k = result.length - 1; k >= 0; k--) {
            result[k] = array[index];
            index = previousElementArray[index];
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");  // 1 2 5 6 9
        }
    }

    public static void main(String args[]) {
        int X[] = {3,1,2,5,0,6,4,9};
        solve(X);
    }

}
