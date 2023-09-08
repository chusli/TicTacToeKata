package org.ase.coaching;

import java.util.Arrays;
import java.util.List;

public class Field {

    Cell[][] cells = new Cell[][]{{
            new Cell(),
            new Cell(),
            new Cell()}, {
            new Cell(),
            new Cell(),
            new Cell()}, {
            new Cell(),
            new Cell(),
            new Cell()}};

    public List<Cell> getCells() {
        return Arrays.stream(cells).flatMap(Arrays::stream).toList();
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }
}
