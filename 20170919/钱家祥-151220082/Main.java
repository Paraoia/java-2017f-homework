package com.hulu;

public class Main {
	public static void main(String[] args) {
		Hulu[] hulu = new Hulu[7];
		for (int i = 0; i < 7; i++) {
			hulu[i] = new Hulu(i);
		}
		Sort sort = new Sort();
		sort.randomOrder(hulu);
		System.out.println("随机排序：");
		sort.showOrd(hulu);
		System.out.println("冒泡排序开始：");
		sort.bubbleSort(hulu);
		System.out.println("冒泡排序结束：");
		sort.showOrd(hulu);
		sort.randomOrder(hulu);
		System.out.println("随机排序：");
		sort.showCol(hulu);
		System.out.println("快速排序开始：");
		sort.quickSort(hulu, 0, hulu.length - 1);
		System.out.println("快速排序结束：");
		sort.showCol(hulu);
	}
}
