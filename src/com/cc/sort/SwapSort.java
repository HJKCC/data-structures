package com.cc.sort;

public class SwapSort {
	/**
	 * ð������(�ȶ�)
	 */
	public static <E extends Comparable<? super E>> void bubbleSort(E[] e) {
		int length = e.length;
		for (int i = 1; i < length; i++) {
			//������ʶ
			boolean flag = true;
			//���ν��ϴ��Ԫ�ؽ�����e[length-1-i]
			for (int j = 0; j < length - i; j++) {
				if (e[j].compareTo(e[j + 1]) > 0) {
					swap(e, j, j + 1);
					flag = false;
				}
			}
			
			//�������ѭ��δ��������˵�����������
			if (flag) {
				break;  
			}
		}
	}
	
	/**
	 * �������������������ȶ���
	 * @param e
	 * @param j 
	 * @param i 
	 */
	public static <E extends Comparable<? super E>> void quickSort(E[] e) {
		quickSort(e, 0, e.length - 1);
	}
	
	private static <E extends Comparable<? super E>> void quickSort(E[] e, int left, int right) {
		if(left >= right) {
			return;
		}
		
		int dividePos = divide(e, left, right);
		
		quickSort(e, left, dividePos - 1);
		quickSort(e, dividePos + 1, right);
	}
	
	private static <E extends Comparable<? super E>> int divide(E[] e, int left, int right) {
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
		int tmpPos = left;
		E tmp = e[left];
		left++;
		while(left < right) {
			while(left < right && e[left].compareTo(tmp) <= 0) left++;
			while(left < right && e[right].compareTo(tmp) >= 0) right--;
			swap(e, left, right);
			left++;
			right--;
		}
		swap(e, tmpPos, left);
		return left;
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
