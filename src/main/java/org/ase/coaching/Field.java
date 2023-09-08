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

    Integer[][] winConditionLines = new Integer[][]{{
            0, 1, 2}, { // row1
            3, 4, 5}, { // row2
            6, 7, 8}, { // row3
            0, 3, 6}, { // column1
            1, 4, 7}, { // column2
            2, 5, 8}, { // column3
            0, 4, 8}, { // diagonal top left bottom right
            2, 4, 6}};

    public List<Cell> getCells() {
        return Arrays.stream(cells).flatMap(Arrays::stream).toList();
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

    public Player getWinner() {
        var cells = getCells();
        for (Integer[] i : winConditionLines) {
            List<Cell> candidateCells = Arrays.stream(i).map(cells::get).toList();
            List<Player> players = candidateCells.stream().map(Cell::getPlayer).toList();
            if (players.stream().allMatch(player -> player == Player.X)) {
                return Player.X;
            } else if (players.stream().allMatch(player -> player == Player.O)) {
                return Player.O;
            }
        }
        return Player.Empty;
    }
}
