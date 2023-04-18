package objects;

public class Result {

    private String name;
    private double price;
    private String link;

    public Result(String name, double price, String link) {
        this.name = name;
        this.price = price;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }
}
