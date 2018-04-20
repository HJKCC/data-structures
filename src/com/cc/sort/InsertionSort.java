package com.cc.sort;

public class InsertionSort {
	/**
	 * 简单插入排序（稳定）
	 */
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {		
		int j;
		int length = e.length;
		for (int i = 1; i < length; i++) {
			E tmp = e[i]; 
			for (j = i; j >= 1 && tmp.compareTo(e[j - 1]) < 0; j--) {  //将比较元素e[i]逐渐向前插入到已排序序列的合适位置
				e[j] = e[j - 1];
			}
			if (j != i) {
				e[j] = tmp;
			}
		}
	}
	
	/**
	 * 希尔排序（不稳定）
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void shellSort(E[] e) {
		int h, i, j;
		int length = e.length;
		for (h = length / 2; h > 0; h /= 2) {   //希尔增量h=length/2，然后取h/2
			for (i = h; i < length; i++) {
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
