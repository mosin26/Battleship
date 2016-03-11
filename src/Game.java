import java.io.*;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("log.txt");
        FileOutputStream stream = new FileOutputStream(file, true);
        OutputStreamWriter osw = new OutputStreamWriter(stream, "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        System.out.println("Новая игра - 'N'\nЗагрузить - 'L'");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s.toUpperCase();
        if(s.charAt(0)=='N') {
            bw.write("\nНовая игра: \n");
            Player player = new Player('A', 1, 'A', 2, 'A', 3, 'A', 4, 'C', 1, 'D', 1, 'E', 1, 'B', 10, 'C', 10, 'D', 10,
                    'J', 7, 'J', 8, 'J', 2, 'J', 3, 'F', 5, 'E', 5, 'E', 8, 'A', 8, 'B', 6, 'G', 8);
            Computer computer = new Computer();
            for (int i = 0; i < 100; i++) {
                System.out.println("Ваш ход: ");
                computer.getField().viewField();
                if(player.makeMove(computer.getField())==1) {
                    FileOutputStream fos1 = new FileOutputStream("temp1.out");
                    ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                    oos1.writeObject(player);
                    oos1.flush();
                    oos1.close();
                    FileOutputStream fos2 = new FileOutputStream("temp2.out");
                    ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
                    oos2.writeObject(computer);
                    oos2.flush();
                    oos2.close();
                    bw.write(i+1 + ": сохранение\n");
                    bw.close();
                    System.exit(0);
                }
                if (computer.getField().isEnd()) {
                    System.out.println("ПОБЕДА!");
                    return;
                }
                System.in.read();
                System.out.println("Ход бота:");
                player.getField().viewField();
                computer.makeMove(player.getField());
                bw.write(i+1 + ": ход бота\n");
                bw.close();
                if (player.getField().isEnd()) {
                    System.out.println("ПОРАЖЕНИЕ!");
                    return;
                }
                System.in.read();
            }
        }
        if(s.charAt(0)=='L') {
            bw.write("\nПродолжение игры: \n");
            System.out.println("\nЗагрузка...");
            FileInputStream fis1 = new FileInputStream("temp1.out");
            ObjectInputStream oin1 = new ObjectInputStream(fis1);
            Player player = (Player) oin1.readObject();
            FileInputStream fis2 = new FileInputStream("temp2.out");
            ObjectInputStream oin2 = new ObjectInputStream(fis2);
            Computer computer = (Computer) oin2.readObject();
            for (int i = 0; i < 100; i++) {
                System.out.println("Ваш ход: ");
                computer.getField().viewField();
                if(player.makeMove(computer.getField())==1) {
                    FileOutputStream fos1 = new FileOutputStream("temp1.out");
                    ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                    oos1.writeObject(player);
                    oos1.flush();
                    oos1.close();
                    FileOutputStream fos2 = new FileOutputStream("temp2.out");
                    ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
                    oos2.writeObject(computer);
                    oos2.flush();
                    oos2.close();
                    bw.close();
                    System.exit(0);
                }
                if (computer.getField().isEnd()) {
                    System.out.println("ПОБЕДА!");
                    bw.close();
                    return;
                }
                System.in.read();
                System.out.println("Ход бота:");
                player.getField().viewField();
                computer.makeMove(player.getField());
                if (player.getField().isEnd()) {
                    System.out.println("ПОРАЖЕНИЕ!");
                    bw.close();
                    return;
                }
                System.in.read();
            }
        }
        bw.close();
    }
}
