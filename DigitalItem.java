public class DigitalItem extends Item {
    private String downloadLink;

    public DigitalItem(String name, double basePrice, String downloadLink) {
        super(name, basePrice);
        this.downloadLink = downloadLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public double calculateFinalPrice() {
        return getBasePrice();
    }
}
