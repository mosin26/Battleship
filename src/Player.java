import java.io.*;
import java.util.Scanner;

public class Player implements Serializable{
    private Field field;

    public Player(char c1, int d1, char c2, int d2, char c3, int d3, char c4, int d4, char c5, int d5,
                  char c6, int d6, char c7, int d7, char c8, int d8, char c9, int d9, char c10, int d10,
                  char c11, int d11, char c12, int d12, char c13, int d13, char c14, int d14, char c15, int d15,
                  char c16, int d16, char c17, int d17, char c18, int d18, char c19, int d19, char c20, int d20) {
        Field field = new Field();
        setField(field);
        this.getField().setShips(c1, d1, c2, d2, c3, d3, c4, d4, c5, d5, c6, d6, c7, d7, c8, d8, c9, d9, c10, d10,
                c11, d11, c12, d12, c13, d13, c14, d14, c15, d15, c16, d16, c17, d17, c18, d18, c19, d19, c20, d20);
    }

    public int makeMove(Field field) throws StringIndexOutOfBoundsException {
        int m, n;
        Scanner in = new Scanner(System.in);
        System.out.printf("\nВведите координаты: ");
        try {
            String s = in.nextLine();
            s = s.toUpperCase();
            if(s.charAt(0)=='S') {
                System.out.println("\nСохранение... Выход из игры.");
                return 1;
            }
            if(s.length()==1) {
                n = (int) s.charAt(0) - 65;
                m = (int) s.charAt(1) - 1;
            } else {
                n = (int) s.charAt(0) - 65;
                s = s.substring(1);
                m = Integer.valueOf(s) - 1;
            }
            if(field.cells[m][n].isShipped()) {
                int numberOfShip = 10;
                for(int i=0; i<10; i++) {
                    for (int j = 0; j < field.ships[i].cells.length; j++) {
                        if (field.ships[i].cells[j] == field.cells[m][n]) {
                            numberOfShip = i;
                        }
                    }
                }
                System.out.println("\nВы попали");
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
                    if(numberOfShip<4) {
                        if(!(n==9)) {field.cells[m][n+1].setUsed(true);}
                        if(!(n==0)) {field.cells[m][n-1].setUsed(true);}
                        if(!(m==0)) {field.cells[m-1][n].setUsed(true);}
                        if(!(m==9)) {field.cells[m+1][n].setUsed(true);}
                        if(!(m==0) && !(n==0)) {field.cells[m-1][n-1].setUsed(true);}
                        if(!(m==0) && !(n==9)) {field.cells[m-1][n+1].setUsed(true);}
                        if(!(m==9) && !(n==9)) {field.cells[m+1][n+1].setUsed(true);}
                        if(!(m==9) && !(n==0)) {field.cells[m+1][n-1].setUsed(true);}
                    }
                    if(numberOfShip>3 && numberOfShip<7) {
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
                    if(numberOfShip>6 && numberOfShip<9) {
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
                    if(numberOfShip==9) {
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
                    System.out.println("Вы убили корабль!");
                }
                field.viewField();
                makeMove(field);
                return 2;
            } else {
                System.out.println("\nВы промахнулись!");
                field.cells[m][n].setUsed(true);
                field.viewField();
            }
        } catch (StringIndexOutOfBoundsException e1) {
            System.out.println("\nПовторите ввод!");
            makeMove(field);
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("\nПовторите ввод!");
            makeMove(field);
        } catch (NumberFormatException e3) {
            System.out.println("\nПовторите ввод!");
            makeMove(field);
        }
        return 0;
    }

    public Field getField() {return field;}
    public void setField(Field field) {this.field = field;}
}
