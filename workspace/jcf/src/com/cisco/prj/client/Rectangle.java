package com.cisco.prj.client;

public class Rectangle {
    private int width;
    private  int breadth;

    public Rectangle() {
    }

    public Rectangle(int width, int breadth) {
        this.width = width;
        this.breadth = breadth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }


    @Override
    public boolean equals(Object obj) {
        Rectangle other = (Rectangle) obj;
        return (this.width == other.width) && (this.breadth == other.breadth);
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + breadth;
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", breadth=" + breadth +
                '}';
    }
}
