package com.test;

public class HDTV implements Comparable<HDTV> {
	private int size;
	private String brand;

	public HDTV(int size, String brand) {
		this.size = size;
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public boolean equals(Object o) {
		HDTV other = (HDTV) o;
		if(this.brand != other.brand) {
			return false;
		}
		else if(this.size != other.size) {
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(HDTV tv) {

		if (this.getSize() > tv.getSize())
			return 1;
		else if (this.getSize() < tv.getSize())
			return -1;
		else {
			return this.brand.compareTo(tv.brand);
		}
	}
}