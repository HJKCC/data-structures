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
	
	public static <E extends Comparable<? super E>> void quickSort(E[] e, int i, int j) {
		
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
