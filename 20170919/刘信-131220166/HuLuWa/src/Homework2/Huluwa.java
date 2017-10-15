package Homework2;

public class Huluwa{
	String name;
	int number;
	String color;
	
	Huluwa(int number, String name, String color){
		this.number = number;
		this.name = name;
		this.color = color;
	}
	
	public void SayChange(int from, int to){
		System.out.println(this.name + ":" + from + "->" + to);
	}
	
	public void SayName(){
		System.out.println(this.name);
	}
	
	public void SayColor(){
		System.out.println(this.color);
	}
}