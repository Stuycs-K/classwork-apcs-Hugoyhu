public class Pathfinder extends Adventurer{
    // Pathfinders can heal allies
    private int heal = 5;
    private int healMax = 10;

    public Pathfinder (String name) {
        super("Pathfinder " + name, 100);
    }

    public Pathfinder (String name, int hp) {
        super("Pathfinder " + name, hp);
    }

    public Pathfinder (String name, int hp, int heal, int healMax) {
        super("Pathfinder " + name, hp);
        this.heal = heal;
        this.healMax = healMax;
    }

    @Override
    public String getSpecialName() {
        return "healing";
    }

    @Override
    public int getSpecial() {
        return this.heal;
    }

    @Override
    public void setSpecial(int n) {
        this.heal = n;
    }

    @Override
    public int getSpecialMax () {
        return this.healMax;
    }

    @Override
    public String attack(Adventurer other) {
        other.applyDamage(5);
        return this.getName() + " attacks " + other.getName() + " and inflicts 5hp damage.";
    }

    @Override
    public String support(Adventurer other) {
        if (this.getSpecial() > 0) {
            other.setHP(other.getHP() + 15);
            this.setSpecial(this.getSpecial() - 1);
            return this.getName() + " heals " + other.getName() + " and heals 15hp.";
        }

        return "No healing resources available.";
    }

    @Override
    public String support() {
        if (this.getSpecial() > 0) {
            this.setHP(this.getHP() + 25);
            this.setSpecial(this.getSpecial() - 1);
            return this.getName() + " heals themselves by 25hp.";
        }

        return "No healing resources available.";
    }

    public String specialAttack(Adventurer other) {
        if (this.getSpecial() > 2) {
            other.applyDamage(50);
            this.setSpecial(this.getSpecial() - 3);
            return this.getName() + " attacks " + other.getName() + " and inflicts 50hp damage.";
        }

        return "Insufficient " +  this.getSpecialName() + " resources available. 3 needed, " + this.getSpecial() + " available.";
    }







}
