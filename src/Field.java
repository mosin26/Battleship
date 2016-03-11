import java.io.Serializable;

public class Field implements Serializable{
    public Cell[][] cells;
    public Ship[] ships;
    private static int numberOfShip=0;

    public Field() {
        cells = new Cell[10][10];
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                cells[i][j] = new Cell();
            }
        }
        ships = new Ship[10];
    }

    public void setShips(char c1, int d1, char c2, int d2, char c3, int d3, char c4, int d4, char c5, int d5,
                         char c6, int d6, char c7, int d7, char c8, int d8, char c9, int d9, char c10, int d10,
                         char c11, int d11, char c12, int d12, char c13, int d13, char c14, int d14, char c15, int d15,
                         char c16, int d16, char c17, int d17, char c18, int d18, char c19, int d19, char c20, int d20) {
        ships[0]= new Ship(cells[d1-1][c1-65], cells[d2-1][c2-65], cells[d3-1][c3-65], cells[d4-1][c4-65]);
        ships[1]= new Ship(cells[d5-1][c5-65], cells[d6-1][c6-65], cells[d7-1][c7-65]);
        ships[2]= new Ship(cells[d8-1][c8-65], cells[d9-1][c9-65], cells[d10-1][c10-65]);
        ships[3]= new Ship(cells[d11-1][c11-65], cells[d12-1][c12-65]);
        ships[4]= new Ship(cells[d13-1][c13-65], cells[d14-1][c14-65]);
        ships[5]= new Ship(cells[d15-1][c15-65], cells[d16-1][c16-65]);
        ships[6]= new Ship(cells[d17-1][c17-65]);
        ships[7]= new Ship(cells[d18-1][c18-65]);
        ships[8]= new Ship(cells[d19-1][c19-65]);
        ships[9]= new Ship(cells[d20-1][c20-65]);
    }
    public void setShips() {
        for(int i=0; i<4; i++) {
            int rand1, rand2;
            do {
                rand1 = (int) (Math.random() * 10);
                rand2 = (int) (Math.random() * 10);
            } while(cells[rand1][rand2].isShipped() || cells[rand1][rand2].isAreol());
            this.ships[numberOfShip++] = new Ship(cells[rand1][rand2]);
            if(!(rand2==9)) {cells[rand1][rand2+1].setAreol(true);}
            if(!(rand2==0)) {cells[rand1][rand2-1].setAreol(true);}
            if(!(rand1==0)) {cells[rand1-1][rand2].setAreol(true);}
            if(!(rand1==9)) {cells[rand1+1][rand2].setAreol(true);}
            if(!(rand1==0) && !(rand2==0)) {cells[rand1-1][rand2-1].setAreol(true);}
            if(!(rand1==0) && !(rand2==9)) {cells[rand1-1][rand2+1].setAreol(true);}
            if(!(rand1==9) && !(rand2==9)) {cells[rand1+1][rand2+1].setAreol(true);}
            if(!(rand1==9) && !(rand2==0)) {cells[rand1+1][rand2-1].setAreol(true);}
        }
        for(int i=0; i<3; i++) {
            int rand1, rand2;
            do {
                rand1 = (int) (Math.random() * 10);
                rand2 = (int) (Math.random() * 9);
            } while(cells[rand1][rand2].isShipped() || cells[rand1][rand2].isAreol() ||
                    cells[rand1][rand2+1].isShipped() || cells[rand1][rand2+1].isAreol());
            this.ships[numberOfShip++] = new Ship(cells[rand1][rand2], cells[rand1][rand2+1]);
            if(!(rand2+1==9)) {cells[rand1][rand2+2].setAreol(true);}
            if(!(rand2==0)) {cells[rand1][rand2-1].setAreol(true);}
            if(!(rand1==0)) {
                cells[rand1-1][rand2].setAreol(true);
                cells[rand1-1][rand2+1].setAreol(true);
            }
            if(!(rand1==9)) {
                cells[rand1+1][rand2].setAreol(true);
                cells[rand1+1][rand2+1].setAreol(true);
            }
            if(!(rand1==0) && !(rand2==0)) {cells[rand1-1][rand2-1].setAreol(true);}
            if(!(rand1==0) && !(rand2+1==9)) {cells[rand1-1][rand2+2].setAreol(true);}
            if(!(rand1==9) && !(rand2+1==9)) {cells[rand1+1][rand2+2].setAreol(true);}
            if(!(rand1==9) && !(rand2==0)) {cells[rand1+1][rand2-1].setAreol(true);}
        }
        for(int i=0; i<2; i++) {
            int rand1, rand2;
            do {
                rand1 = (int) (Math.random() * 8);
                rand2 = (int) (Math.random() * 10);
            } while(cells[rand1][rand2].isShipped() || cells[rand1][rand2].isAreol() ||
                    cells[rand1+1][rand2].isShipped() || cells[rand1+1][rand2].isAreol() ||
                    cells[rand1+2][rand2].isShipped() || cells[rand1+2][rand2].isAreol());
            this.ships[numberOfShip++] = new Ship(cells[rand1][rand2], cells[rand1+1][rand2],
                    cells[rand1+2][rand2]);
            if(!(rand2==9)) {
                cells[rand1][rand2+1].setAreol(true);
                cells[rand1+1][rand2+1].setAreol(true);
                cells[rand1+2][rand2+1].setAreol(true);
            }
            if(!(rand2==0)) {
                cells[rand1][rand2-1].setAreol(true);
                cells[rand1+1][rand2-1].setAreol(true);
                cells[rand1+2][rand2-1].setAreol(true);
            }
            if(!(rand1==0)) {cells[rand1-1][rand2].setAreol(true);}
            if(!(rand1+2==9)) {cells[rand1+3][rand2].setAreol(true);}
            if(!(rand1==0) && !(rand2==0)) {cells[rand1-1][rand2-1].setAreol(true);}
            if(!(rand1==0) && !(rand2==9)) {cells[rand1-1][rand2+1].setAreol(true);}
            if(!(rand1+2==9) && !(rand2==0)) {cells[rand1+3][rand2-1].setAreol(true);}
            if(!(rand1+2==9) && !(rand2==9)) {cells[rand1+3][rand2+1].setAreol(true);}
        }
        int rand1, rand2;
        do {
            rand1 = (int) (Math.random() * 10);
            rand2 = (int) (Math.random() * 7);
        } while(cells[rand1][rand2].isShipped() || cells[rand1][rand2].isAreol() ||
                cells[rand1][rand2+1].isShipped() || cells[rand1][rand2+1].isAreol() ||
                cells[rand1][rand2+2].isShipped() || cells[rand1][rand2+2].isAreol() ||
                cells[rand1][rand2+3].isShipped() || cells[rand1][rand2+3].isAreol());
        this.ships[numberOfShip++] = new Ship(cells[rand1][rand2], cells[rand1][rand2+1],
                cells[rand1][rand2+2], cells[rand1][rand2+3]);
    }

    public void viewField() {
        System.out.println("********************************");
        System.out.println("    A  B  C  D  E  F  G  H  I  J");
        for(int i=0; i<9; i++) {
            System.out.printf(" %d", i+1);
            for(int j=0; j<10; j++) {
                if(!this.cells[i][j].isUsed()&&!this.cells[i][j].isShipped()) {
                    System.out.printf("  ~");
                }
                if(!this.cells[i][j].isUsed()&&this.cells[i][j].isShipped()) {
                    System.out.printf("  •");
                }
                if(this.cells[i][j].isUsed()&&!this.cells[i][j].isShipped()) {
                    System.out.printf("  o");
                }
                if(this.cells[i][j].isUsed()&&this.cells[i][j].isShipped()) {
                    System.out.printf("  x");
                }
            }
            System.out.printf("\n");
        }
        System.out.printf("10");
        for(int j=0; j<10; j++) {
            if(!this.cells[9][j].isUsed()&&!this.cells[9][j].isShipped()) {
                System.out.printf("  ~");
            }
            if(!this.cells[9][j].isUsed()&&this.cells[9][j].isShipped()) {
                System.out.printf("  •");
            }
            if(this.cells[9][j].isUsed()&&!this.cells[9][j].isShipped()) {
                System.out.printf("  o");
            }
            if(this.cells[9][j].isUsed() &&this.cells[9][j].isShipped()) {
                System.out.printf("  x");
            }
        }
        System.out.println("\n********************************");
    }

    public boolean isEnd() {
        for (int i = 0; i < 10; i++) {
            if (!this.ships[i].isDead()) {return false;}
        }
        return true;
    }
}
