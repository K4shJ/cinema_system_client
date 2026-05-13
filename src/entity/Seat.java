package entity;

import java.io.Serializable;

/**
 * 座位
 */
public class Seat implements Serializable {

    private int col;

    private int row;

    private String owner;

    public Seat(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return " ● ";
    }
}
