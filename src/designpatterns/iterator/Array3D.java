package designpatterns.iterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array3D<T> implements Iterator<T> {
    private int index = 0;
    private final T[][][] array3d;
    private final int size;
    private int matrix;
    private int row;
    private int col;

    public Array3D(T[][][] array3d) {
        this.array3d = array3d;
        this.size = size(array3d);
        this.matrix = 0;
        this.row = 0;
        this.col = 0;
    }

    private int prevMatrix;
    private int prevRow;
    private int prevCol;

    private int size(T[][][] array3d) {
        int counter = 0;
        for (T[][] array2d: array3d) {
            for (T[] array: array2d){
                    counter+=array.length;
                }
            }
        return counter;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public T next() {
        if (index >= size) {
            throw new NoSuchElementException();
        }
        T element = array3d[matrix][row][col];

        prevCol = col;
        prevRow = row;
        prevMatrix = matrix;

        index++;
        col++;
        if (col >= array3d[matrix][row].length) {
            col = 0;
            row++;
        }
        if (row >= array3d[matrix].length) {
            row = 0;
            matrix++;
        }

        if (element == null && this.hasNext()) {
            return this.next();
        }
        return element;
    }

    @Override
    public void remove() {
        array3d[prevMatrix][prevRow][prevCol] = null;
    }
}
