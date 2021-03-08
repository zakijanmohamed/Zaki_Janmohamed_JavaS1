class Character {
    //properties
    String name;
    int strength;
    int health = 100;
    int stamina;
    int speed;
    int attackPower;

    //abilities
    boolean run;
    boolean attack;
    boolean heal;
    boolean decreaseHealth;
    boolean increaseStamina;
    boolean decreaseStamina;

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
       if (run == true){
           System.out.println("I am running!");
       }
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        if (attack == true){
            attackPower+=1;
        }
        else{attackPower-=1;}
    }

    public boolean isHeal() {
        return heal;
    }

    public void setHeal(boolean heal) {
        if (heal == true){
            health+=1;
        }
    }

    public boolean isDecreaseHealth() {
        return decreaseHealth;
    }

    public void setDecreaseHealth(boolean decreaseHealth) {
        if (decreaseHealth == true){
            health-=1;
        }
    }

    public boolean isIncreaseStamina() {
        return increaseStamina;
    }

    public void setIncreaseStamina(boolean increaseStamina) {

        if (increaseStamina == true) {
            stamina +=1;
        }

    }

    public boolean isDecreaseStamina() {
        return decreaseStamina;
    }

    public void setDecreaseStamina(boolean decreaseStamina) {
       if (decreaseStamina == true){
           stamina -=1;
       }
    }
}
