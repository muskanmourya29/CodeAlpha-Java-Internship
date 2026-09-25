public class Reservation {

    String customerName;
    String phoneNumber;
    Room room;
    int nights;
    double totalAmount;

    public Reservation(
        String customerName,
        String phoneNumber,
        Room room,
        int nights
    ) {

        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.room = room;
        this.nights = nights;

        this.totalAmount = room.price * nights;
    }
}