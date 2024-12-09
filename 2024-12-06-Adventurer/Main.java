import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // do this once
        Scanner userInput = new Scanner(System.in);

        // You can do the rest many times:

        System.out.println("Enter username");
        // Read one line of user input
        String userName = userInput.nextLine();
        // Do something with the input
        System.out.println("Username is: " + userName);
    }
}