import java.io.IOException;
import java.io.Serializable;

public class Computer implements Serializable{
    private Field field;

    public Computer() {
        Field field = new Field();
        setField(field);
        this.getField().setShips();
    }

    public void makeMove(Field field) throws IOException {
        System.in.read();
        int m, n;
        do {
            n = (int) (Math.random() * 10);
            m = (int) (Math.random() * 10);
        } while(field.cells[m][n].isUsed());
        int numberOfShip = 10;
        if (field.cells[m][n].isShipped()) {
            for(int i=0; i<10; i++) {
                for (int j = 0; j < field.ships[i].cells.length; j++) {
                    if (field.ships[i].cells[j] == field.cells[m][n]) {
                        numberOfShip = i;
                    }
                }
            }
            System.out.println("Бот попал!");
            field.cells[m][n].setUsed(true);
            for(int i=0; i<10; i++) {
                for(int j=0; j<10; j++) {
                    if(field.ships[numberOfShip].cells[0]==field.cells[i][j]) {
                        m=i;
                        n=j;
                    }
                }
            }
            if(field.ships[numberOfShip].isDead()) {
                if(numberOfShip>5) {
                    if(!(n==9)) {field.cells[m][n+1].setUsed(true);}
                    if(!(n==0)) {field.cells[m][n-1].setUsed(true);}
                    if(!(m==0)) {field.cells[m-1][n].setUsed(true);}
                    if(!(m==9)) {field.cells[m+1][n].setUsed(true);}
                    if(!(m==0) && !(n==0)) {field.cells[m-1][n-1].setUsed(true);}
                    if(!(m==0) && !(n==9)) {field.cells[m-1][n+1].setUsed(true);}
                    if(!(m==9) && !(n==9)) {field.cells[m+1][n+1].setUsed(true);}
                    if(!(m==9) && !(n==0)) {field.cells[m+1][n-1].setUsed(true);}
                }
                if(numberOfShip>2 && numberOfShip<6) {
                    if(!(n+1==9)) {field.cells[m][n+2].setUsed(true);}
                    if(!(n==0)) {field.cells[m][n-1].setUsed(true);}
                    if(!(m==0)) {
                        field.cells[m-1][n].setUsed(true);
                        field.cells[m-1][n+1].setUsed(true);
                    }
                    if (!(m==9)) {
                        field.cells[m+1][n].setUsed(true);
                        field.cells[m+1][n+1].setUsed(true);
                    }
                    if(!(m==0) && !(n==0)) {field.cells[m-1][n-1].setUsed(true);}
                    if(!(m==0) && !(n+1==9)) {field.cells[m-1][n+2].setUsed(true);}
                    if(!(m==9) && !(n+1==9)) {field.cells[m+1][n+2].setUsed(true);}
                    if(!(m==9) && !(n==0)) {field.cells[m+1][n-1].setUsed(true);}
                }
                if(numberOfShip>0 && numberOfShip<3) {
                    if(!(n==9)) {
                        field.cells[m][n+1].setUsed(true);
                        field.cells[m+1][n+1].setUsed(true);
                        field.cells[m+2][n+1].setUsed(true);
                    }
                    if(!(n==0)) {
                        field.cells[m][n-1].setUsed(true);
                        field.cells[m+1][n-1].setUsed(true);
                        field.cells[m+2][n-1].setUsed(true);
                    }
                    if(!(m==0)) {field.cells[m-1][n].setUsed(true);}
                    if(!(m+2==9)) {field.cells[m+3][n].setUsed(true);}
                    if(!(m==0) && !(n==0)) {field.cells[m-1][n-1].setUsed(true);}
                    if(!(m==0) && !(n==9)) {field.cells[m-1][n+1].setUsed(true);}
                    if(!(m+2==9) && !(n==0)) {field.cells[m+3][n-1].setUsed(true);}
                    if(!(m+2==9) && !(n==9)) {field.cells[m+3][n+1].setUsed(true);}
                }
                if(numberOfShip==0) {
                    if(!(m==9)) {
                        field.cells[m+1][n].setUsed(true);
                        field.cells[m+1][n+1].setUsed(true);
                        field.cells[m+1][n+2].setUsed(true);
                        field.cells[m+1][n+3].setUsed(true);
                    }
                    if(!(m==0)) {
                        field.cells[m-1][n].setUsed(true);
                        field.cells[m-1][n+1].setUsed(true);
                        field.cells[m-1][n+2].setUsed(true);
                        field.cells[m-1][n+3].setUsed(true);
                    }
                    if(!(n==0)) {field.cells[m][n-1].setUsed(true);}
                    if(!(n+3==9)) {field.cells[m][n+4].setUsed(true);}
                    if(!(m==0)&&!(n==0)) {field.cells[m-1][n-1].setUsed(true);}
                    if(!(m==0)&&!(n+3==9)) {field.cells[m-1][n+4].setUsed(true);}
                    if(!(m==9)&&!(n==0)) {field.cells[m+1][n-1].setUsed(true);}
                    if(!(m==9)&&!(n+3==9)) {field.cells[m+1][n+4].setUsed(true);}
                }
                System.out.println("Бот убил корабль!");
            }
            field.viewField();
            makeMove(field);
        } else {
            System.out.println("Бот промахнулся!");
            field.cells[m][n].setUsed(true);
            field.viewField();
        }
    }

    public void setField(Field field) {this.field = field;}
    public Field getField() {return field;}
}
