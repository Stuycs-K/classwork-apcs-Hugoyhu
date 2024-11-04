import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String text = "This is a sample\nOf how to read\ntext!";

        // creates a Scanner object to read throug the String
        Scanner input = new Scanner(text);

        // you don't want a for loop here unless you know the size of the data set
        printEachLine(input);

        printEachLine(new Scanner("This is a bunch of words"));

        Scanner sc2 = new Scanner("10.0 1.04 99.0 -3.0 4.2");
        System.out.println(sumString(sc2));
        
        input.close();
    }

    public static void printEachLine (Scanner input) {
        while (input.hasNext()) {
            System.out.println(input.next());
        }
    }

    public static Double sumString (Scanner input) {
        Double sum = 0.0;
        while (input.hasNext()) {
            sum+= input.nextDouble();
        }
        return sum;
    }

}