package com.cc.sort;

/**
 * 选择类排序：包含 简单选择排序 和 堆排序
 *
 * @author chencheng0816@gmail.com 
 * @date 2018年4月22日 下午3:54:24
 */
public class SelectSort {
	/**
	 * 简单选择排序（不稳定）
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {
		int length = e.length;
		for (int i = 0; i < length; i++) {
			int min = i;   //缓存较小元素的下标
			for (int j = i + 1; j < length; j++) {  //选择剩余未排序序列中最小元素的下标
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
	 * 堆排序（稳定） O(N*logN)
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void heapSort(E[] e) {
		int length = e.length;
		
		//build the max heap
		for (int i = length / 2; i >= 0; i--) {
			percolateDown(e, i, length);
		}
		
		//delete root
		for (int j = length - 1; j > 0; j--) {
			swap(e, 0, j);
			percolateDown(e, 0, j);
		}
	}
	
	/**
	 * 下滤(大顶堆)
	 * @param e 数组
	 * @param i 待下滤元素标识
	 * @param n 数组长度
	 */
	private static <E extends Comparable<? super E>> void percolateDown(E[] e, int i, int length) {
		int left = 2 * i + 1;
		if (left >= length) {
			return;
		}
		
		int largest = i;
		int right = left + 1;
		
		if (e[largest].compareTo(e[left]) < 0) {
			largest = left;
		}
		if (right < length && e[largest].compareTo(e[right]) < 0) {
			largest = right;
		}
		if (largest != i) {
			swap(e, i, largest);
			percolateDown(e, largest, length);
		}
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
