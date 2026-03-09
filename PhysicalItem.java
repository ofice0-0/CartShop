public class PhysicalItem extends Item {
    private double weight;

    public PhysicalItem(String name, double basePrice, double weight) {
        super(name, basePrice);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateFinalPrice() {
        double shippingFee = weight * 0.5;
        return getBasePrice() + shippingFee;
    }
}
