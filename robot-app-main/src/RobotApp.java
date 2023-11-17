import java.util.Scanner;

import Model.Layout;
import Model.Position;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args) {
        new RobotApp();
    }

    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    public RobotApp() {
        // contoh konfigurasi (inisiasi object layout) area permainan: X = 10, Y = 10, icon area yang tidak ditempati robot adalah '*'
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot('o', new Position(0, 0)); // Misalnya, robot dimulai di posisi (0, 0)
        this.scanner = new Scanner(System.in);
        String instruction = "";
        System.out.println("-------- Permainan Dimulai --------");
        do {
            draw();
            instruction = waitInstruction();
            if (!instruction.equals("x")) {
                executeInstruction(instruction);
            }
        } while (!instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukan instruksi: ");
        return scanner.nextLine();
    }

    private void executeInstruction(String instruction) {
        if (instruction.length() < 2) {
            System.out.println("Input tidak valid. Masukkan banyaknya langkah!");
            return;
        }
        char arah = instruction.charAt(0);
        int langkah;
        try {
            langkah = Integer.parseInt(instruction.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan nomor step yang benar!");
            return;
        }

        
        int newX = robot.getPosition().getX();
        int newY = robot.getPosition().getY();

        switch (arah) {
            case 'w':
                newX -= langkah;
                break;
            case 'a':
                newY -= langkah;
                break;
            case 's':
                newX += langkah;
                break;
            case 'd':
                newY += langkah;
                break;
            default:
                System.out.println("Masukan Antara W, A, S, D");
            return;
    }

    // Memeriksa batas area permainan
    if (isValidPosition(newX, newY)) {
        robot.getPosition().setX(newX);
        robot.getPosition().setY(newY);
    } else {
        System.out.println("Robot tidak dapat keluar dari area permainan!");
    }
}

// Menambahkan metode untuk memeriksa apakah posisi baru valid atau tidak
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < layout.getMaxX() && y >= 0 && y < layout.getMaxY();
}
        

    private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        for (int i = 0; i < layout.getMaxX(); i++) {
            for (int j = 0; j < layout.getMaxY(); j++) {
                if (i == robot.getPosition().getX() && j == robot.getPosition().getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(layout.getArea()[i][j]);
                }
            }
            System.out.println();
        }
    }
}