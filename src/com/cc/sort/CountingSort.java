package com.cc.sort;

/**
 * ���������㷨���� ������������n �� [min, max]֮�������ʱ����
 * �㷨ʱ�临�Ӷ�ΪO(n+max-min)���������ٶȿ����καȽ������㷨��
 * �ռ临�Ӷ�ΪO(n+max-min)��
 * ������Ԫ��ֵ�Ƚϼ��еĳ�����
 *
 * @author chencheng0816@gmail.com 
 * @date 2018��4��23�� ����10:03:49
 */
public class CountingSort {
	/**
	 * �����������ʵ��
	 * 
	 * @param src
	 * @return
	 */
	public static void sort(int[] src) {
		int min = src[0];
		int max = src[0];
		int srcLength = src.length;
		
		//1���������ֵ����Сֵ
		for (int i = 0; i < srcLength; i++) {
			if (src[i] < min) {
				min = src[i];
			}
			if (src[i] > max) {
				max = src[i];
			}
		}
		
		//2���Դ���������Ԫ�ر��������ν���ʱ�������±�Ϊ src[i]-min�� Ԫ�ؼ�1
		int tmpLength = max - min + 1;
		int[] tmpArray = new int[tmpLength];		
		for (int i = 0; i < srcLength; i++) {
			int tmpIndex = src[i] - min;
			tmpArray[tmpIndex]++;
		}
		
		//3��������ʱ���飬��������Ԫ�����δ���ԭ����
		int j = 0;
		for (int i = 0; i < tmpLength; i++) {
			while (tmpArray[i] > 0) {
				src[j++] = i + min;
				tmpArray[i]--;
			}
		}
	}
}
