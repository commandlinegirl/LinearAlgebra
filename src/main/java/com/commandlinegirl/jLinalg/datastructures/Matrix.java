package com.commandlinegirl.jLinalg.datastructures;

interface Matrix {

    int size();
    int rowCount();
    int colCount();
    double[] getRow(int rowNumber);
    double[] getColumn(int colNumber);
    int rank();
    boolean isSingular();

}
