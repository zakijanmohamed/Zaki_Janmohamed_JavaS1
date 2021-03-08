public class IceCreamPos {
    double pricePerScoop;
    int numberOfScoops;
    double priceForCone;
    int numberOfCones;
    double pricePerTopping;
    int numberOfToppings;
    double PriceForLargeShake;
    double PriceForSmallShake;
    double PriceForSundae;
    double PriceForBananaSplit;
    double PriceForIceCreamCake;

    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    public int getNumberOfScoops() {
        return numberOfScoops;
    }

    public void setNumberOfScoops(int numberOfScoops) {
        this.numberOfScoops = numberOfScoops;
    }

    public double getPriceForCone() {
        return priceForCone;
    }

    public void setPriceForCone(double priceForCone) {
        this.priceForCone = priceForCone;
    }

    public int getNumberOfCones() {
        return numberOfCones;
    }

    public void setNumberOfCones(int numberOfCones) {
        this.numberOfCones = numberOfCones;
    }

    public double getPricePerTopping() {
        return pricePerTopping;
    }

    public void setPricePerTopping(double pricePerTopping) {
        this.pricePerTopping = pricePerTopping;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public double getPriceForLargeShake() {
        return PriceForLargeShake;
    }

    public void setPriceForLargeShake(double priceForLargeShake) {
        PriceForLargeShake = priceForLargeShake;
    }

    public double getPriceForSmallShake() {
        return PriceForSmallShake;
    }

    public void setPriceForSmallShake(double priceForSmallShake) {
        PriceForSmallShake = priceForSmallShake;
    }

    public double getPriceForSundae() {
        return PriceForSundae;
    }

    public void setPriceForSundae(double priceForSundae) {
        PriceForSundae = priceForSundae;
    }

    public double getPriceForBananaSplit() {
        return PriceForBananaSplit;
    }

    public void setPriceForBananaSplit(double priceForBananaSplit) {
        PriceForBananaSplit = priceForBananaSplit;
    }

    public double getPriceForIceCreamCake() {
        return PriceForIceCreamCake;
    }

    public void setPriceForIceCreamCake(double priceForIceCreamCake) {
        PriceForIceCreamCake = priceForIceCreamCake;
    }

    public IceCreamPos(double pricePerScoop, int numberOfScoops, double priceForCone, int numberOfCones, double pricePerTopping, int numberOfToppings) {
        this.pricePerScoop = pricePerScoop;
        this.numberOfScoops = numberOfScoops;
        this.priceForCone = priceForCone;
        this.numberOfCones = numberOfCones;
        this.pricePerTopping = pricePerTopping;
        this.numberOfToppings = numberOfToppings;
    }
}
