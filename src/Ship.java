import java.io.Serializable;

public class Ship implements Serializable{
    public Cell[] cells;
    private boolean dead;

    public Ship(Cell cell1) {
        cell1.setShipped(true);
        cells = new Cell[1];
        this.cells[0] = cell1;
        this.setDead(false);
    }
    public Ship(Cell cell1, Cell cell2) {
        cell1.setShipped(true);
        cell2.setShipped(true);
        cells = new Cell[2];
        this.cells[0] = cell1;
        this.cells[1] = cell2;
        this.setDead(false);
    }
    public Ship(Cell cell1, Cell cell2, Cell cell3) {
        cell1.setShipped(true);
        cell2.setShipped(true);
        cell3.setShipped(true);
        cells = new Cell[3];
        this.cells[0] = cell1;
        this.cells[1] = cell2;
        this.cells[2] = cell3;
        this.setDead(false);
    }
    public Ship(Cell cell1, Cell cell2, Cell cell3, Cell cell4) {
        cell1.setShipped(true);
        cell2.setShipped(true);
        cell3.setShipped(true);
        cell4.setShipped(true);
        cells = new Cell[4];
        this.cells[0] = cell1;;
        this.cells[1] = cell2;;
        this.cells[2] = cell3;;
        this.cells[3] = cell4;;
        this.setDead(false);
    }

    public void setDead(boolean dead) {this.dead = dead;}
    public boolean isDead() {
        for (int i = 0; i < this.cells.length; i++) {
            if (!this.cells[i].isUsed()) {
                return false;
            }
        }
        return true;
    }
}
