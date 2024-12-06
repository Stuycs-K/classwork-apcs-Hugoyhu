public class Driver {
    public static void main (String[] args) {
        Adventurer PDR_Andre = new Pathfinder("Andre", 100, 3, 5);
        Adventurer PDR_Robert = new Pathfinder("Robert", 150);

        System.out.println(report(PDR_Andre) + "\n");
        System.out.println(report(PDR_Robert));

        System.out.println("\n------------------");
        System.out.println(PDR_Andre.attack(PDR_Robert));
        System.out.println("------------------");

        System.out.println(report(PDR_Andre) + "\n");
        System.out.println(report(PDR_Robert));



        System.out.println("\n------------------");
        System.out.println(PDR_Robert.specialAttack(PDR_Andre));
        System.out.println("------------------");

        System.out.println(report(PDR_Andre) + "\n");
        System.out.println(report(PDR_Robert));

        
        System.out.println("\n------------------");
        System.out.println(PDR_Andre.support());
        System.out.println(PDR_Andre.specialAttack(PDR_Robert));
        System.out.println("------------------");

        System.out.println(report(PDR_Andre) + "\n");
        System.out.println(report(PDR_Robert));


        

    }

    public static String report (Adventurer person) {
        String out = "";
        out += "Name: " + person.getName() + " " + "\n";
        out += "Has " + person.getSpecial() + " " + person.getSpecialName() + " with a maximum capacity of " + person.getSpecialMax() + "\n";
        out += "HP: " + person.getHP() + "/" + person.getmaxHP();
        return out;
    } 
}