package com.cc.sort;

public class InsertionSort {
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {
		int j;
		int length = e.length;
		for (int i = 1; i < length; i++) {
			E tmp = e[i]; 
			for (j = i; j >= 1 && tmp.compareTo(e[j - 1]) < 0; j--) {
				e[j] = e[j - 1];
			}
			if (j != i) {
				e[j] = tmp;
			}
		}
	}
	
	public static <E extends Comparable<? super E>> void shellSort(E[] e) {
		int length = e.length;
		int h, j;
		for (h = length / 2; h > 0; h /= 2) {
			for (int i = h; i < length; i++) {
				E tmp = e[i];
				for (j = i; j >= h && tmp.compareTo(e[j - h]) < 0; j -= h) {
					e[j] = e[j - h];
				}
				if (j != i) {
					e[j] = tmp;
				}
			}
		}
	}
}
