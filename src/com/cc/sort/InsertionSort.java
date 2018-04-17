package com.cc.sort;

public class InsertionSort {
	public static <E extends Comparable<? super E>> void sort(E[] e) {
		int j;
		int length = e.length;
		for (int i = 1; i < length; i++) {
			E tmp = e[i]; 
			for (j = i; j > 0 && e[j].compareTo(e[j - 1]) < 0; j--) {
				e[j] = e[j - 1];
			}
			e[j] = tmp;
		}
	}
}
