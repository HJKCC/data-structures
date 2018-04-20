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
			//依次将较大的元素交换到e[length-1-i]
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
	
	/**
	 * 快速排序，主方法（不稳定）
	 * @param e
	 * @param j 
	 * @param i 
	 */
	public static <E extends Comparable<? super E>> void quickSort(E[] e) {
		quickSort(e, 0, e.length - 1);
	}
	
	public static <E extends Comparable<? super E>> void quickSort(E[] e, int i, int j) {
		
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
