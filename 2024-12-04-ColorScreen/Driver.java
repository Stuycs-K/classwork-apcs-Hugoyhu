import java.util.Random;

public class Driver {
    public static void drawBorder(int color) {
        // 80 x 30

        System.out.print(Text.HIDE_CURSOR);

        Text.color(Text.background(color));

        // Text.go(0,0);

        // for (int i = 0; i < 30; i++) {
        //     for (int j = 0; j < 80; j++) {
        //         System.out.print(" ");
        //     }
        // }

        Text.color(Text.background(color));
        Text.go(1, 1);
        for (int j = 0; j < 80; j++) {
            System.out.print(" ");
        }

        for (int i = 2; i < 30; i++) {
            Text.go(i, 1);
            System.out.print(" ");
            Text.go(i, 80);
            System.out.print(" ");
        }

        // for (int i = 1; i < 29; i++) {
        //     Text.erase(i+1, 2, 78);
        // }

        Text.color(Text.background(color));
        Text.go(30, 1);
        for (int j = 0; j < 80; j++) {
            System.out.print(" ");
        }

        System.out.print(Text.RESET);

    }

    public static int[] random3 () {
        Random rng = new Random();
        int[] l = new int[3];

        for (int i = 0; i < 3; i++) {
            l[i] = rng.nextInt(100);
        }

        return l;
    }

    public static void print3 (int[] args) {
        int n0 = args[0];
        int n1 = args[1];
        int n2 = args[2];

        Text.go(1, 18);
        System.out.print(n0);

        Text.go(1, 38);
        System.out.print(n1);

        Text.go(1, 58);
        System.out.print(n2);

        System.out.print(Text.RESET);

    }

    public static void main(String[] args) {

        int[] out3 = random3();
        // System.out.println(test[0] + " " + test[1] + " " + test[2]);
        print3(out3);

        //drawBorder(Text.CYAN);
    }
}
