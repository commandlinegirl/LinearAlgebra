package com.commandlinegirl.jLinalg.datastructures;

public class SimpleMatrix implements Matrix {

    private final double[][] data;
    private final int rowCount;
    private final int colCount;
    private final int size;

    public SimpleMatrix(double[][] data) {
        validate(data);
        this.data = data;
        this.rowCount = data.length;
        this.colCount = rowCount == 0 ? 0 : data[0].length;
        this.size = rowCount * colCount;
    }

    private void validate(double[][] data) {
        if (data == null)
            throw new IllegalArgumentException("data is null");
    }

    public int rowCount() {
        return rowCount;
    }

    public int colCount() {
        return colCount;
    }

    public int size() {
        return size;
    }

    public double[] getRow(int rowNumber) {
        return new double[0];
    }

    public double[] getColumn(int colNumber) {
        return new double[0];
    }

    public int rank() {
        return 0;
    }

    public boolean isSingular() {
        return false;
    }
}
