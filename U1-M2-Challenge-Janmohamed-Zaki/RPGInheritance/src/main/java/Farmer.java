public class Farmer extends Character  {

    //abilities

    boolean plow;
    boolean harvest;

    public Farmer(String name){
         this.name = name;
         super.strength =75;
         super.stamina = 75;
         super.speed = 10;
         super.attackPower = 1;

    }

    public boolean isPlow() {
        return plow;
    }

    public void setPlow(boolean plow) {
        if (plow == true){
            System.out.println("I am Plowing!");
        }
    }

    public boolean isHarvest() {
        return harvest;
    }

    public void setHarvest(boolean harvest) {
        if (harvest == true){
            System.out.println("I am Harvesting");
        }
    }
}
