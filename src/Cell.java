import java.io.Serializable;

public class Cell implements Serializable{
    private boolean shipped;
    private boolean used;
    private boolean areol;

    public Cell() {
        setUsed(false);
        setShipped(false);
        setAreol(false);
    }

    public void setUsed(boolean used) {this.used = used;}
    public boolean isUsed() {return used;}
    public boolean isShipped() {return shipped;}
    public void setShipped(boolean shipped) {this.shipped = shipped;}
    public void setAreol(boolean areol) {this.areol = areol;}
    public boolean isAreol() {return areol;}
}
