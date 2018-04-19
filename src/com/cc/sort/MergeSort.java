package com.cc.sort;

public class MergeSort {
	public static <E extends Comparable<? super E>> void sort(E[] e) {
		int length = e.length;
		E[] tmpArray = (E[]) new Comparable[length];
		
		mergeSort(e, tmpArray, 0, length - 1);		
	}
	
	private static <E extends Comparable<? super E>> void mergeSort(E[] srcArray, E[] resArray, int left, int right) {
		if (left < right) {		
			int center = (left + right) / 2;
			mergeSort(srcArray, resArray, left, center);
			mergeSort(srcArray, resArray, center +1, right);
			
			merge(srcArray, resArray, left, center, right);
		}
	}
	
	private static <E extends Comparable<? super E>> void merge(E[] srcArray, E[] resArray, int leftPos, int leftEnd, int rightEnd) {
		int startPos = leftPos;
		int endPos = rightEnd;
		int resPos = leftPos;
		int rightPos = leftEnd + 1;
		
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if(srcArray[leftPos].compareTo(srcArray[rightPos]) < 0) {
				resArray[resPos++] = srcArray[leftPos++];
			} else {
				resArray[resPos++] = srcArray[rightPos++];
			}
		}
		
		while (leftPos <= leftEnd) {
			resArray[resPos++] = srcArray[leftPos++];
		}
		
		while (rightPos <= rightEnd) {
			resArray[resPos++] = srcArray[rightPos++];
		}
		
		for (; startPos <= endPos; startPos++) {
			srcArray[resPos] = resArray[resPos];
		}
	}
}
