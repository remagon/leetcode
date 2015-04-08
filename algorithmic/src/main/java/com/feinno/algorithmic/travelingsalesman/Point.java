package com.feinno.algorithmic.travelingsalesman;

public class Point implements Comparable<Point> {
	private int x;

	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(Point other) {
		return Math.sqrt(Math.pow(getX() - other.getX(), 2) + Math.pow(getY() - other.getY(), 2));
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int compareTo(Point o) {
		return getX() - o.getX();
	}
}
