package com.cc.sort;

public class SelectSort {
	/**
	 * ºÚµ•—°‘Ò≈≈–Ú
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {
		int length = e.length;
		for (int i = 0; i < length; i++) {
			int min = i;
			for (int j = i + 1; j < length; j++) {
				if (e[min].compareTo(e[j]) > 0) {
					min = j;
				}
			}
			if (min != i) {
				swap(e, min, i);
			}
		}
	}
	
	/**
	 * ∂—≈≈–Ú
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void heapSort(E[] e) {
	}
	
	/**
	 * Ωªªª‘™Àÿ÷µ
	 */
	private static <E extends Comparable<? super E>> void swap(E[] e, int i, int j) {
		E tmp = e[i];
		e[i] = e[j];
		e[j] = tmp;
	}
}
