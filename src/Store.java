import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Client> clients;

    public Store() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void displayClientCarts() {
        for (Client client : clients) {
            System.out.println(client.getCartDetails());
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        Client client = new Client(1, "Lisbon", "Lisboa", 5);
        client.getCart().addItem(new Item(1, "Potion of Healing", "potions", 10.0, 2));
        store.addClient(client);
        store.displayClientCarts();
    }
}

class Client {
    private int id;
    private String city;
    private String district;
    private int loyaltyYears;
    private Cart cart;

    public Client(int id, String city, String district, int loyaltyYears) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.loyaltyYears = loyaltyYears;
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public String getCartDetails() {
        return cart.toString();
    }
}

class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }
        return sb.toString();
    }
}

class Item {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Item(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
