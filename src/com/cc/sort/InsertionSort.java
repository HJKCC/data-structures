package com.cc.sort;

public class InsertionSort {
	/**
	 * �򵥲��������ȶ���
	 */
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {		
		int j;
		int length = e.length;
		for (int i = 1; i < length; i++) {
			E tmp = e[i]; 
			for (j = i; j >= 1 && tmp.compareTo(e[j - 1]) < 0; j--) {  //���Ƚ�Ԫ��e[i]����ǰ���뵽���������еĺ���λ��
				e[j] = e[j - 1];
			}
			if (j != i) {
				e[j] = tmp;
			}
		}
	}
	
	/**
	 * ϣ�����򣨲��ȶ���
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void shellSort(E[] e) {
		int h, i, j;
		int length = e.length;
		for (h = length / 2; h > 0; h /= 2) {   //ϣ������h=length/2��Ȼ��ȡh/2
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
