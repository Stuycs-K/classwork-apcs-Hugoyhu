import java.time.LocalTime;

public class ColorDemo {
    public static final String escape = "\u001b[";
    public static final Integer BLACK = 0;
    public static final Integer RED = 1;
    public static final Integer GREEN = 2;
    public static final Integer YELLOW = 3;
    public static final Integer BLUE = 4;
    public static final Integer MAGENTA = 5;
    public static final Integer CYAN = 6;
    public static final Integer WHITE = 7;

    public static final Integer textOffset = 30;
    public static final Integer brightTextOffset = 90;
    public static final Integer backgroundOffset = 40;
    public static final Integer brightBackgroundOffset = 100;


    public static final String[] zero = {
        " ... ",
        ".   .",
        "..  .",
        ". . .",
        ".  ..",
        ".   .",
        " ... "};

    public static final String[] one = {
        "  .  ",
        " ..  ",
        "  .  ",
        "  .  ",
        "  .  ",
        "  .  ",
        " ... "};

    public static final String[] two = {
        " ... ",
        ".   .",
        "    .",
        "   . ",
        "  .  ",
        " .   ",
        "....."};

    public static final String[] three = {
        " ... ",
        ".   .",
        "    .",
        "  .. ",
        "    .",
        ".   .",
        " ... "};

    public static final String[] four = {
        "   . ",
        "  .. ",
        " . . ",
        ".  . ",
        ".....",
        "   . ",
        "   . "};

    public static final String[] five = {
        ".....",
        ".    ",
        ".    ",
        ".... ",
        "    .",
        "    .",
        ".... "};

    public static final String[] six = {
        " ... ",
        ".   .",
        ".    ",
        ".... ",
        ".   .",
        ".   .",
        " ... "};

    public static final String[] seven = {
        ".....",
        "    .",
        "   . ",
        "  .  ",
        "  .  ",
        "  .  ",
        "  .  "};

    public static final String[] eight = {
        " ... ",
        ".   .",
        ".   .",
        " ... ",
        ".   .",
        ".   .",
        " ... "};

    public static final String[] nine = {
        " ... ",
        ".   .",
        ".   .",
        " ....",
        "    .",
        ".   .",
        " ... "};

    public static final String[][] mapper = {zero, one, two, three, four, five, six, seven, eight, nine};

    public static String reset() {
        return "0";
    }
    public static String resetText() {
        return "39";
    }
    public static String resetBackground() {
        return "49";
    }
    public static String bold() {
        return "1";
    }
    public static void resetAll() {
        System.out.print("\u001b[0m");
    }

    public static String OutputString(
        int textColor, boolean brightText, int backgroundColor, boolean brightBackground
    ) {
        String out = "";
        if (brightText) {
            out += textColor + brightTextOffset;
        } else {
            out += textColor + textOffset;
        }

        out += ";";

        if (brightBackground) {
            out += backgroundColor + brightBackgroundOffset;
        } else {
            out += backgroundColor + backgroundOffset;
        }

        return out;
    }

    public static String begin () {
        return escape;
    }

    public static String endText () {
        return "m";
    }

    public static void writeDigit (String[] lines, int dotColor, int spaceColor, int digit) {
        String[] d = mapper[digit];
        for (int line = 0; line < lines.length; line++) {
            String dLine = d[line];
            for (int i = 0; i < dLine.length(); i++) {
                // each pixel:
                char current = dLine.charAt(i);
                if (current == '.') {
                    lines[line] += escape + OutputString(0, false, dotColor, false) + "m ";
                } else {
                    lines[line] += escape + OutputString(0, false, spaceColor, false) + "m ";
                }
                lines[line] += "\u001b[0m";
            }
        }
    }

    public static void padSpace (String[] lines, String padding) {
        for (int line = 0; line < lines.length; line++) {
            lines[line] += padding;
        }
    }

    public static void writeTime (int hourDot, int hourSpace, int minuteDot, int minuteSpace) {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();


        int hourd0 = hour / 10;
        int hourd1 = hour % 10;

        int mind0 = minute / 10;
        int mind1 = minute % 10;

        int secd0 = second / 10;
        int secd1 = second % 10;

        String[] writeOut = {
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        };

        String padStr = escape + OutputString(0, false, ColorDemo.BLACK, false) + "m  ";
        writeDigit(writeOut, hourDot, hourSpace, hourd0);
        padSpace(writeOut, padStr);
        writeDigit(writeOut, hourDot, hourSpace, hourd1);
        padSpace(writeOut, padStr);
        writeDigit(writeOut, minuteDot, minuteSpace, mind0);
        padSpace(writeOut, padStr);
        writeDigit(writeOut, minuteDot, minuteSpace, mind1);
        padSpace(writeOut, padStr);
        writeDigit(writeOut, hourDot, hourSpace, secd0);
        padSpace(writeOut, padStr);
        writeDigit(writeOut, hourDot, hourSpace, secd1);



        for (int i = 0; i < writeOut.length; i++) {
            System.out.println(writeOut[i]);
        }
    }

    public static void printColor (String text, int textColor, boolean brightText, int backgroundColor, boolean brightBackground) {
        String out = "";
        out += begin();
        out += OutputString(textColor, brightText, backgroundColor, brightBackground);
        out += endText();
        out += text;
        System.out.print(out);
        resetAll();
    }


    public static void main (String[] args) {

        writeTime(ColorDemo.GREEN, ColorDemo.BLACK, ColorDemo.RED, ColorDemo.BLACK);



        // ColorDemo.printColor(
        //     "Hello World!",
        //     ColorDemo.RED,
        //     false,
        //     ColorDemo.GREEN,
        //     false

        // );

        // System.out.print("\u001b[31mRed");
        // System.out.print(" \u001b[0mfish ");
        // System.out.print("\u001b[34mBlue");
        // System.out.print(" \u001b[0mfish ");//reset to defaults!
    }

}
