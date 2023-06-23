package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] intArray = {20,1,-15,7,-22,35,55};

        bubbleSort(intArray);

        selectionSort(intArray);

        insertionSort(intArray);

        shellSort(intArray);

        quickSort(intArray);
    }

    private static void quickSort(int[] intArray) {
        long start = System.nanoTime();

        int pivot = intArray[0];

        int i = 0;

        int j = intArray.length;

        if (j - start < 2 )     {
            long elapsedTime = System.nanoTime() - start;
            System.out.println(String.format("[%s] Merge Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
            return;
        }




        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("[%s] Merge Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
    }

    private static void mergeSort(int[] intArray){
        long start = System.nanoTime();




        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("[%s] Merge Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
    }

    private static void mergeSortRecursive(int[] intArray, int start, int end){
        if (end - start < 2){
            return;
        }

        int mid = (start + end) / 2;

        mergeSortRecursive(intArray, start, mid);
        mergeSortRecursive(intArray, mid, end);
        merge(intArray, start,mid,end);
    }

    private static void merge(int[] intArray, int start, int mid, int end) {

        if(intArray[mid-1] <= intArray[mid]){
            return;
        }

    }

    private static void shellSort(int[] intArray){
        long start = System.nanoTime();


        for(int gap = intArray.length / 2; gap > 0; gap /= 2){


            for(int i = gap; i < intArray.length; i++){
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement){
                    intArray[i] = intArray[j - gap];
                    j -= gap;
                }

                intArray[j] = newElement;
            }


        }

        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("[%s] Shell Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
    }

    private static void insertionSort(int[] intArray){
        long start = System.nanoTime();

        for(int unsortedIndex = 1; unsortedIndex < intArray.length; unsortedIndex++){
            int newElement = intArray[unsortedIndex];
            int i;
                for (i = unsortedIndex; i > 0 && intArray[i - 1] > newElement; i--){
                    intArray[i] = intArray[i-1];
                }
            intArray[i] = newElement;
        }

        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("[%s] Insertion Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
    }

    private static void bubbleSort(int[] intArray) {
        long start = System.nanoTime();

        for(int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--){

            for (int i = 0; i < lastUnsortedIndex ; i++){
                if (intArray[i] > intArray[i + 1]){
                    swap(intArray,i,i+1);
                }
            }

        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("[%s] Bubble Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
    }

    private static void selectionSort(int[] intArray){
        long start = System.nanoTime();

        for(int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--){
            int maxValue = 0;
            for (int i = 1; i <= lastUnsortedIndex ; i++){
                if (intArray[i] > intArray[maxValue]){
                    maxValue = i;
                }
            }
            swap(intArray,maxValue,lastUnsortedIndex);
        }

        long elapsedTime = System.nanoTime() - start;
        System.out.println(String.format("[%s] Selection Sort Array: %s",elapsedTime, Arrays.toString(intArray)));
    }

    private static void swap(int[] intArray, int p1, int p2){

        int temp = intArray[p1];

        intArray[p1] = intArray[p2];
        intArray[p2] = temp;

    }

}