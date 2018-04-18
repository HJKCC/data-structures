package com.cc.sort;

public class SwapSort {
	/**
	 * 冒泡排序(稳定)
	 */
	public static <E extends Comparable<? super E>> void bubbleSort(E[] e) {
		int length = e.length;
		for (int i = 1; i < length; i++) {
			//交换标识
			boolean flag = true;
			
			for (int j = 0; j < length - i; j++) {
				if (e[j].compareTo(e[j + 1]) > 0) {
					swap(e, j, j + 1);
					flag = false;
				}
			}
			
			//如果本次循环未交换，则说明已完成排序
			if (flag) {
				break;  
			}
		}
	}
	
	public static <E extends Comparable<? super E>> void quickSort(E[] e) {
		
	}
	
	/**
	 * 交换元素值
	 */
	private static <E extends Comparable<? super E>> void swap(E[] e, int i, int j) {
		E tmp = e[i];
		e[i] = e[j];
		e[j] = tmp;
	}
}
