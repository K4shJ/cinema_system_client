package entity;

import java.io.Serializable;

/**
 * 放映厅
 */
public class FilmHall implements Serializable {

    private String id;

    private String name;

    private int totalRow;

    private int totalCol;

    private Seat[][] seats;

    public FilmHall(String id, String name, int totalRow, int totalCol) {
        this.id = id;
        this.name = name;
        this.totalRow = totalRow;
        this.totalCol = totalCol;
        this.seats = new Seat[totalRow][totalCol];
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j++) {
                this.seats[i][j] = new Seat(i, j);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getTotalCol() {
        return totalCol;
    }

    public void setTotalCol(int totalCol) {
        this.totalCol = totalCol;
    }

    /**
     * 展示座位信息
     */
    public void showSeats(){
        System.out.println(" ");
        for (int i = 0; i < totalCol; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < totalRow; i++) {
            System.out.print(i);
            for (int j = 0; j < totalCol; j++) {
                Seat seat = seats[i][j];
                if (seat.getOwner() != null) {
                    System.err.print(" ● ");
                } else System.out.print(" ● ");
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + totalRow * totalCol;
    }
}
