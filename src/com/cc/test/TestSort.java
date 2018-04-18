package com.cc.test;

import java.util.Random;

import com.cc.sort.InsertionSort;

public class TestSort {

	public static void main(String[] args) {
		String[] test = {"81", "11", "96", "12",
				"35", "17", "95", "28", 
				"58", "41", "75", "15"};
		Random random = new Random();
		int tmp = random.nextInt(100);
		System.out.println(tmp);
		int[] arr = random.ints(10, 10, 100).toArray();
		
		for (String str : test) {
			System.out.print(str + ", ");
		}
		System.out.println();
		InsertionSort.shellSort(test);
		for (String str : test) {
			System.out.print(str + ", ");
		}
	}

}
