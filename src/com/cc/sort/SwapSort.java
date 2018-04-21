package com.cc.sort;

import java.util.Arrays;

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
	 */
	public static <E extends Comparable<? super E>> void quickSort(E[] e) {
		quickSort(e, 0, e.length - 1);
	}
	
	/**
	 * 循环对分区快排
	 * @param e
	 * @param left
	 * @param right
	 */
	private static <E extends Comparable<? super E>> void quickSort(E[] e, int left, int right) {
		if(left >= right) {
			return;
		}
		
		//分区
		int dividePos = divide(e, left, right);
		Arrays.asList(e).stream().forEach(s -> System.out.print(s + ","));
		System.out.println();
		
		//拆分递归
		quickSort(e, left, dividePos - 1);
		quickSort(e, dividePos + 1, right);
	}
	
	/**
	 * 对输入序列进行分区调整
	 * @param e
	 * @param left
	 * @param right
	 * @return
	 */
	private static <E extends Comparable<? super E>> int divide(E[] e, int left, int right) {
		//采用三数中值分割法取枢纽元：将左、中、右三个元素按中小大排序
		int center = (left + right) / 2;
		if (e[left].compareTo(e[center]) > 0) {
			swap(e, left, center);
		}
		if (e[center].compareTo(e[right]) > 0) {
			swap(e, center, right);
		}
		if (e[left].compareTo(e[center]) < 0) {
			swap(e, left, center);
		}
		int tmpPos = left;  //枢纽元下标
		E tmp = e[left];  //枢纽元值
		
		left++;
		//分区调整核心代码
		while(left < right) {
			while(left < right && e[left].compareTo(tmp) <= 0) left++;
			while(left < right && e[right].compareTo(tmp) >= 0) right--;
			if (left < right) {
				swap(e, left, right);
			}			
		}
		
		//调整枢纽元至左右分区之间
		swap(e, tmpPos, --left);
		
		return left;
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
