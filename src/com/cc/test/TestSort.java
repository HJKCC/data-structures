package com.cc.test;

import java.util.Random;

import com.cc.sort.CountingSort;
import com.cc.sort.InsertionSort;
import com.cc.sort.MergeSort;
import com.cc.sort.SelectSort;
import com.cc.sort.SwapSort;

public class TestSort {

	public static void main(String[] args) {
		String[] test = {"81", "11", "96", "12",
				"35", "17", "95", "28", 
				"58", "41", "75", "15"};
		int[] src = {121, 24, 34, 45, 34, 67, 45, 56, 87, 75, 9, 63};
		
		
		for (int str : src) {
			System.out.print(str + ", ");
		}
		System.out.println();
		
//		InsertionSort.shellSort(test);
//		SwapSort.bubbleSort(test);
//		SwapSort.quickSort(test);
//		SelectSort.heapSort(test);
//		MergeSort.sort(test);
		CountingSort.sort(src);
		
		for (int str : src) {
			System.out.print(str + ", ");
		}
	}
}
