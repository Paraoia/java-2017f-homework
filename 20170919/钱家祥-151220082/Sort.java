package com.hulu;

import java.util.Random;

public class Sort {
	Sort() {
	}
	public void randomOrder(Hulu[] hulu) {
		int len = hulu.length;
		Hulu[] temp = hulu.clone();
		Random rd = new Random();
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			index = Math.abs(rd.nextInt() % len--);
			hulu[i] = temp[index];
			temp[index] = temp[len];
		}
	}	
	public void bubbleSort(Hulu[] hulu) {
		for (int i = 0; i < hulu.length - 1; i++) {
			for (int j = 0; j < hulu.length - i - 1; j++) {
				if (hulu[j].getOrder() > hulu[j + 1].getOrder()) {
					swap(hulu[j], hulu[j+1]);
					System.out.println(hulu[j].toOrdString() + " : " + (j+2) + "->" + (j+1));
					showOrd(hulu);
				}
			}
		}
	}
	public void quickSort(Hulu[] hulu, int left, int right) {
		if (left < right) {
			int mi = partition(hulu, left, right);
			quickSort(hulu, left, mi - 1);
			quickSort(hulu, mi + 1, right);
		}
		
	}
	private int partition(Hulu[] hulu, int left, int right) {
		Random rd = new Random();
		int ord = left + rd.nextInt(right - left + 1);
		swap(hulu[left], hulu[ord]);
		System.out.println(hulu[left].toOrdString() + " : " + (ord+1) + "->" + (left+1));
		showCol(hulu);
		Hulu pivot = hulu[left];
		int mi = left;
		for (int k = left + 1; k <= right; k++) {
			if (hulu[k].getOrder() < pivot.getOrder()) {
				swap(hulu[++mi], hulu[k]);
				if (mi != k) {
					System.out.println(hulu[mi].toOrdString() + " : " + (k+1) + "->" + (mi+1));
					showCol(hulu);
				}
			}
		}
		swap(hulu[mi], hulu[left]);
		System.out.println(hulu[mi].toOrdString() + " : " + (left+1) + "->" + (mi+1));
		showCol(hulu);
		return mi;
	}
	private void swap(Hulu a, Hulu b) {
		int order = a.getOrder();
		a.setOrder(b.getOrder());
		b.setOrder(order);
	}
	public void showOrd(Hulu[] hulu) {
		for (int i = 0; i < hulu.length; i++) {
			System.out.print(hulu[i].toOrdString() + " ");	
		}
		System.out.println();
	}
	public void showCol(Hulu[] hulu) {
		for (int i = 0; i < hulu.length; i++) {
			System.out.print(hulu[i].toColString() + " ");	
		}
		System.out.println();
	}
}
