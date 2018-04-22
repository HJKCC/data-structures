package com.cc.sort;

/**
 * ѡ�������򣺰��� ��ѡ������ �� ������
 *
 * @author chencheng0816@gmail.com 
 * @date 2018��4��22�� ����3:54:24
 */
public class SelectSort {
	/**
	 * ��ѡ�����򣨲��ȶ���
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {
		int length = e.length;
		for (int i = 0; i < length; i++) {
			int min = i;   //�����СԪ�ص��±�
			for (int j = i + 1; j < length; j++) {  //ѡ��ʣ��δ������������СԪ�ص��±�
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
	 * �������ȶ��� O(N*logN)
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
	 * ����Ԫ��ֵ
	 */
	private static <E extends Comparable<? super E>> void swap(E[] e, int i, int j) {
		E tmp = e[i];
		e[i] = e[j];
		e[j] = tmp;
	}
}
