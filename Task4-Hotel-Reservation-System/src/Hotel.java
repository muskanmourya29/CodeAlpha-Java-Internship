import java.util.ArrayList;

public class Hotel {

    ArrayList<Room> rooms;
    ArrayList<Reservation> reservations;

    public Hotel() {

        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        rooms.add(new Room(101, "Single", 1500));
        rooms.add(new Room(102, "Single", 1500));
        rooms.add(new Room(201, "Double", 2500));
        rooms.add(new Room(202, "Double", 2500));
        rooms.add(new Room(301, "Deluxe", 4000));
    }
}