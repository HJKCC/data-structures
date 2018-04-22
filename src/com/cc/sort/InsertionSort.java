package com.cc.sort;

/**
 * 插入类排序：包含 简单插入排序 和 希尔排序
 *
 * @author chencheng0816@gmail.com 
 * @date 2018年4月22日 下午3:51:58
 */
public class InsertionSort {
	/**
	 * 简单插入排序（稳定）
	 */
	public static <E extends Comparable<? super E>> void simpleSort(E[] e) {		
		int j;
		int length = e.length;
		for (int i = 1; i < length; i++) {			
			E tmp = e[i];   //缓存比较元素值e[i]
			
			//将已排序序列元素依次与缓存值tmp 比较
			for (j = i; j >= 1 && tmp.compareTo(e[j - 1]) < 0; j--) {  
				e[j] = e[j - 1];
			}	
			
			//将缓存值tmp赋值给指定元素
			if (j != i) {
				e[j] = tmp;
			}
		}
	}
	
	/**
	 * 希尔排序（不稳定）
	 * @param e
	 */
	public static <E extends Comparable<? super E>> void shellSort(E[] e) {
		int h, i, j;
		int length = e.length;
		for (h = length / 2; h > 0; h /= 2) {   //希尔增量h=length/2，然后取h/2
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
