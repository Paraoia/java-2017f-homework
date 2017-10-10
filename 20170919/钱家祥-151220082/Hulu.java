package com.hulu;

//葫芦娃类
public class Hulu {
	private int order;
	Hulu() {
		
	}
	Hulu(int order) {
		if (check(order)) {
			this.order = order;
		}
		else {
			System.out.println("输入有误！");
		}
	}
	private boolean check(int num) {
		if (num >= 0 && num < 7) {
			return true;
		}
		else 
			return false;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public String toOrdString() {
		switch(order) {
		case 0: return "老大";
		case 1: return "老二";
		case 2: return "老三";
		case 3: return "老四";
		case 4: return "老五";
		case 5: return "老六";
		case 6: return "老七";
		}
		return null;
	}
	
	public String toString() {
		switch(order) {
		case 0: return "老大";
		case 1: return "老二";
		case 2: return "老三";
		case 3: return "老四";
		case 4: return "老五";
		case 5: return "老六";
		case 6: return "老七";
		}
		return null;
	}
	
	public String toColString() {
		switch(order) {
		case 0: return "红色";
		case 1: return "橙色";
		case 2: return "黄色";
		case 3: return "绿色";
		case 4: return "青色";
		case 5: return "蓝色";
		case 6: return "紫色";
		}
		return null;
	}
	
}
