public class Constable extends Character{

    //properties
    char jurisdiction;

    //abilities
    boolean arrest;

    public Constable(String name, char jurisdiction) {
        this.name = name;
        super.strength = 60;
        super.stamina = 60;
        super.speed = 20;
        super.attackPower = 5;
        this.jurisdiction = jurisdiction;
    }

    public boolean isArrest() {
        return arrest;
    }

    public void setArrest(boolean arrest) {
        if (arrest == true){
            System.out.println("You are under arrest!");
        }
    }
}
