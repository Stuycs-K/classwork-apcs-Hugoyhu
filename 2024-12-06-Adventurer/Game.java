import java.util.Scanner;

class Game {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Adventurer Conan = new CodeWarrior("Conan", 25, "Ruby");
        Adventurer John = new Pathfinder("John", 25);

        while (true) {
            System.out.println(charInfo(Conan));
            System.out.println(charInfo(John));

            System.out.println("Type: (a)ttack / (sp)ecial / (su)pport\" / quit");

            try {
                String option = userInput.nextLine();

                if (option.equals("a")) {
                    System.out.println(Conan.attack(John));
                } else if (option.equals("sp")) {
                    System.out.println(Conan.specialAttack(John));
                } else if (option.equals("su")) {
                    System.out.println(Conan.support());
                } else if (option.equals("quit")) {
                    break;
                } else {
                    System.out.println("Invalid Command.");
                }

                if (John.getHP() > 0) {
                    double x = Math.random();
                    if (x < 0.33) {
                        System.out.println(John.attack(Conan));
                    } else if (x < 0.67) {
                        System.out.println(John.specialAttack(Conan));
                    } else {
                        System.out.println(John.support());
                    }
                } else {
                    System.out.println(John.getName() + " has died.");
                    break;
                }

                if (Conan.getHP() <= 0) {
                    System.out.println(Conan.getName() + " has died.");
                    break;
                }

            } catch (Exception e) {
                System.out.println("String expected");
            }

            System.out.println("\n");
        }
    }

    public static String charInfo(Adventurer c) {
        String out = c.getName() + ", " + c.getHP() + "/" + c.getmaxHP() + " HP, " + c.getSpecial() + "/"
                + c.getSpecialMax() + " " + c.getSpecialName();
        return out;
    }
}