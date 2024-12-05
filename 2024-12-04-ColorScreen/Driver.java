public class Driver {
    public static void drawBorder(int color) {
        // 80 x 30

        System.out.print(Text.HIDE_CURSOR);

        Text.color(Text.background(color));

        Text.go(0,0);

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 80; j++) {
                System.out.print(" ");
            }
        }

        for (int i = 1; i < 29; i++) {
            Text.erase(i+1, 2, 78);
        }

        Text.color(Text.background(color));
        Text.go(30, 0);
        for (int j = 0; j < 80; j++) {
            System.out.print(" ");
        }

        System.out.print(Text.RESET);

    }

    public static void main(String[] args) {
        drawBorder(Text.CYAN);
    }
}
