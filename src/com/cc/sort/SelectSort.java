package com.cc.sort;

public class SelectSort {
	/**
	 * ��ѡ�����򣨲��ȶ���
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
	 * �������ȶ���
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
	 * ����(�󶥶�)
	 * @param e ����
	 * @param i ������Ԫ�ر�ʶ
	 * @param n ���鳤��
	 */
	private static <E extends Comparable<? super E>> void percolateDown(E[] e, int i, int length) {
		int largest = i;
		int left = 2 * i + 1;
		int right = left + 1;
		
		if (left < length && e[largest].compareTo(e[left]) < 0) {
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
	 * ����Ԫ��ֵ
	 */
	private static <E extends Comparable<? super E>> void swap(E[] e, int i, int j) {
		E tmp = e[i];
		e[i] = e[j];
		e[j] = tmp;
	}
}
