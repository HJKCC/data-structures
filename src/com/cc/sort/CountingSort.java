package com.cc.sort;

/**
 * 计数排序算法：令 待排序数组有n 个 [min, max]之间的整数时，则：
 * 算法时间复杂度为O(n+max-min)，其排序速度快于任何比较排序算法；
 * 空间复杂度为O(n+max-min)；
 * 适用于元素值比较集中的场景。
 *
 * @author chencheng0816@gmail.com 
 * @date 2018年4月23日 上午10:03:49
 */
public class CountingSort {
	/**
	 * 计数排序具体实现
	 * 
	 * @param src
	 * @return
	 */
	public static void sort(int[] src) {
		int min = src[0];
		int max = src[0];
		int srcLength = src.length;
		
		//1、查找最大值和最小值
		for (int i = 0; i < srcLength; i++) {
			if (src[i] < min) {
				min = src[i];
			}
			if (src[i] > max) {
				max = src[i];
			}
		}
		
		//2、对待排序数组元素遍历，依次将临时数组中下标为 src[i]-min的 元素加1
		int tmpLength = max - min + 1;
		int[] tmpArray = new int[tmpLength];		
		for (int i = 0; i < srcLength; i++) {
			int tmpIndex = src[i] - min;
			tmpArray[tmpIndex]++;
		}
		
		//3、遍历临时数组，将排序后的元素依次存入原数组
		int j = 0;
		for (int i = 0; i < tmpLength; i++) {
			while (tmpArray[i] > 0) {
				src[j++] = i + min;
				tmpArray[i]--;
			}
		}
	}
}
