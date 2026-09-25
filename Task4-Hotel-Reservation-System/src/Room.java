public class Room {

    int roomNumber;
    String roomType;
    double price;
    boolean available;

    public Room(int roomNumber, String roomType, double price) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = true;
    }
}