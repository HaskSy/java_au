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
        size = array3d.length *
                array3d[0].length *
                array3d[0][0].length;
        matrix = 0;
        row = 0;
        col = 0;
    }

    private int prevMatrix;
    private int prevRow;
    private int prevCol;


    @Override
    public boolean hasNext() {
        return index < size - 1;
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
        if (col >= array3d[0][0].length) {
            col = 0;
            row++;
        }
        if (row >= array3d[0].length) {
            row = 0;
            matrix++;
        }

        if (element == null && this.hasNext()) {
            this.next();
        }
        return element;
    }

    @Override
    public void remove() {
        array3d[prevMatrix][prevRow][prevCol] = null;
    }
}
