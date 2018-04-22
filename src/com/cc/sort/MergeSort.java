package com.cc.sort;

/**
 * �鲢����
 *
 * @author chencheng0816@gmail.com 
 * @date 2018��4��22�� ����3:53:54
 */
public class MergeSort {
	/**
	 * �鲢�������������ȶ���
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void sort(E[] e) {
		int length = e.length;
		E[] tmpArray = (E[]) new Comparable[length];
		
		mergeSort(e, tmpArray, 0, length - 1);		
	}
	
	/**
	 * ѭ���鲢�����÷��β���(divide-and-conquer)
	 * @param srcArray ԭ����
	 * @param resArray ��ʱ����
	 * @param left ԭ������ʼ��ʶ
	 * @param right ԭ���������ʶ
	 */
	private static <E extends Comparable<? super E>> void mergeSort(E[] srcArray, E[] resArray, int left, int right) {
		if (left < right) {		
			int center = (left + right) / 2;
			
			//��divite
			mergeSort(srcArray, resArray, left, center);
			mergeSort(srcArray, resArray, center +1, right);
			
			//��conquer
			merge(srcArray, resArray, left, center, right);
		}
	}
	
	/**
	 * �ϲ�����������������
	 * @param srcArray  ԭ����
	 * @param resArray ��ʱ����
	 * @param leftPos ԭ������ʼ��ʶ
	 * @param leftEnd ��һ�����н�����ʶ
	 * @param rightEnd ԭ���������ʶ
	 */
	private static <E extends Comparable<? super E>> void merge(E[] srcArray, E[] resArray, int leftPos, int leftEnd, int rightEnd) {
		int startPos = leftPos;  //save the start postion
		int endPos = rightEnd;  //save the end postion		
		int resPos = leftPos;
		int rightPos = leftEnd + 1;
		
		//main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if(srcArray[leftPos].compareTo(srcArray[rightPos]) < 0) {
				resArray[resPos++] = srcArray[leftPos++];
			} else {
				resArray[resPos++] = srcArray[rightPos++];
			}
		}
		
		while (leftPos <= leftEnd) {   //copy rest of left
			resArray[resPos++] = srcArray[leftPos++];
		}
		
		while (rightPos <= rightEnd) {   //copy rest of right
			resArray[resPos++] = srcArray[rightPos++];
		}
		
		//copy from resArray to srcArray
		for (; startPos <= endPos; startPos++) {
			srcArray[startPos] = resArray[startPos];
		}
	}
}
