public class Driver {
    public static void main (String[] args) {
        Adventurer PFDR_Andre = new Pathfinder("Andre", 100, 3, 5);
        Adventurer PFDR_Robert = new Pathfinder("Robert", 150);

        System.out.println(report(PFDR_Andre));

    }

    public static String report (Adventurer person) {
        String out = "";
        out += "Name: " + person.getName() + " " + "\n";
        out += "Has " + person.getSpecial() + " " + person.getSpecialName() + " with a maximum capacity of " + person.getSpecialMax();
        return out;
    } 
}