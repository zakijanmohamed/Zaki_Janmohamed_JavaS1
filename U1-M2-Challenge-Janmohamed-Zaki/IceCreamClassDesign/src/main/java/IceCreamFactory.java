public class IceCreamFactory {
    String flavorOfIceCream;
    double pricePerGallon;
    double pricePer5Gallons;
    double PricePerSpecialFlavor;
    String specialFlavorName;
    double deliveryFee;

    public String getFlavorOfIceCream() {
        return flavorOfIceCream;
    }

    public void setFlavorOfIceCream(String flavorOfIceCream) {
        this.flavorOfIceCream = flavorOfIceCream;
    }

    public double getPricePerGallon() {
        return pricePerGallon;
    }

    public void setPricePerGallon(double pricePerGallon) {
        this.pricePerGallon = pricePerGallon;
    }

    public double getPricePer5Gallons() {
        return pricePer5Gallons;
    }

    public void setPricePer5Gallons(double pricePer5Gallons) {
        this.pricePer5Gallons = pricePer5Gallons;
    }

    public double getPricePerSpecialFlavor() {
        return PricePerSpecialFlavor;
    }

    public void setPricePerSpecialFlavor(double pricePerSpecialFlavor) {
        this.PricePerSpecialFlavor = pricePerSpecialFlavor;
    }

    public String getSpecialFlavorName() {
        return specialFlavorName;
    }

    public void setSpecialFlavorName(String specialFlavorName) {
        this.specialFlavorName = specialFlavorName;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }


    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public IceCreamFactory(String flavorOfIceCream, double pricePerGallon, double pricePer5Gallons) {
        this.flavorOfIceCream = flavorOfIceCream;
        this.pricePerGallon = pricePerGallon;
        this.pricePer5Gallons = pricePer5Gallons;
    }


}

