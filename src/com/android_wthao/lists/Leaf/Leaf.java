package com.android_wthao.lists.Leaf;

public class Leaf {

	private String name;
	private String text;
	private int number;

	public Leaf(String name, String text, int number) {
		super();
		this.text = name;
		this.name = text;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
