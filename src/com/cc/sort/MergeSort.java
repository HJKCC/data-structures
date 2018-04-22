package com.cc.sort;

/**
 * 归并排序
 *
 * @author chencheng0816@gmail.com 
 * @date 2018年4月22日 下午3:53:54
 */
public class MergeSort {
	/**
	 * 归并排序，主方法（稳定）
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void sort(E[] e) {
		int length = e.length;
		E[] tmpArray = (E[]) new Comparable[length];
		
		mergeSort(e, tmpArray, 0, length - 1);		
	}
	
	/**
	 * 循环归并，采用分治策略(divide-and-conquer)
	 * @param srcArray 原数组
	 * @param resArray 临时数组
	 * @param left 原数组起始标识
	 * @param right 原数组结束标识
	 */
	private static <E extends Comparable<? super E>> void mergeSort(E[] srcArray, E[] resArray, int left, int right) {
		if (left < right) {		
			int center = (left + right) / 2;
			
			//分divite
			mergeSort(srcArray, resArray, left, center);
			mergeSort(srcArray, resArray, center +1, right);
			
			//治conquer
			merge(srcArray, resArray, left, center, right);
		}
	}
	
	/**
	 * 合并两个排序后的子序列
	 * @param srcArray  原数组
	 * @param resArray 临时数组
	 * @param leftPos 原数组起始标识
	 * @param leftEnd 第一个序列结束标识
	 * @param rightEnd 原数组结束标识
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
