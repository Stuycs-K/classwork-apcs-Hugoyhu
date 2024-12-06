public class Pathfinder extends Adventurer{
    // Pathfinders can heal allies
    private int heal = 5;
    private int healMax = 10;

    public Pathfinder (String name) {
        super(name, 100);
    }

    public Pathfinder (String name, int hp) {
        super(name, hp);
    }

    public Pathfinder (String name, int hp, int heal, int healMax) {
        super(name, hp);
        this.heal = heal;
        this.healMax = healMax;
    }

    @Override
    public String getSpecialName() {
        return "Pathfinder";
    }

    @Override
    public int getSpecial() {
        return this.heal;
    }

    @Override
    public void setSpecial(int n) {
        restoreSpecial(n);
    }

    @Override
    public int getSpecialMax () {
        return this.healMax;
    }

    @Override
    public String attack(Adventurer other) {
        other.applyDamage(5);
        return "Pathfinder " + this.getName() + " attacks " + other.getSpecialName() + " " + other.getName() + " and inflicts 5hp damage.";
    }

    @Override
    public String support(Adventurer other) {
        if (this.getSpecial() > 0) {
            other.setHP(other.getHP() + 15);
            this.setSpecial(this.getSpecial() - 1);
            return "Pathfinder " + this.getName() + " heals " + other.getSpecialName() + " " + other.getName() + " and heals 15hp.";
        }

        return "No healing resources available.";
    }

    @Override
    public String support() {
        if (this.getSpecial() > 0) {
            this.setHP(this.getHP() + 15);
            this.setSpecial(this.getSpecial() - 1);
            return "Pathfinder " + this.getName() + " heals themselves by 15hp.";
        }

        return "No healing resources available.";
    }

    public String specialAttack(Adventurer other) {
        if (this.getSpecial() > 1) {
            other.applyDamage(50);
            this.setSpecial(this.getSpecial() - 2);
            return "Pathfinder " + this.getName() + " attacks " + other.getSpecialName() + " " + other.getName() + " and inflicts 50hp damage.";
        }

        return "Insufficient special resources available. 2 needed, " + this.getSpecial() + " available.";
    }







}
