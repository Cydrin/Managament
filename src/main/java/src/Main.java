package src;

public class Main {
    public static void main(String[] args) {
        Boots kozaki = new Boots(12L, "kozaki", 120.5f, 0.5f, "red", 10, 41, true);
        System.out.println(kozaki.getPrice());
        kozaki.setPrice(53);
        System.out.println(kozaki.getPrice());

        User user = new User(1L, "Mike" ,"123j456j");
        Product product = new Product(150L, "Produkt", 150f, 25.5f, "white", 0);
        Cloth cloth = new Cloth(5L, "shorts", 20f, 30f, "haki", 24, "XXL", "leather");
        System.out.println(user.toString() + "\n" + product.toString() + "\n" + cloth.toString() + "\n" + kozaki.toString());

    }
}
