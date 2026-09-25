import java.util.Scanner;

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("      HOTEL RESERVATION SYSTEM");
            System.out.println("=================================");

            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. View Reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--------- AVAILABLE ROOMS ---------");

                    for (Room room : hotel.rooms) {

                        System.out.println(
                            "Room: " + room.roomNumber +
                            " | Type: " + room.roomType +
                            " | Price: ₹" + room.price +
                            " | Available: " + room.available
                        );
                    }

                    break;
                    case 2:

                 System.out.print("\nEnter room number: ");
                 int roomNumber = sc.nextInt();

                Room selectedRoom = null;

                // Find the room
                for (Room room : hotel.rooms) {

                if (room.roomNumber == roomNumber) {
                 selectedRoom = room;
                    break;
                   }
                }

                // Room not found
                if (selectedRoom == null) {
                    System.out.println("Room not found!");
                    break;
                }

                // Room already booked
                if (!selectedRoom.available) {
                    System.out.println("Room is already booked!");
                    break;
                }

                sc.nextLine();

                System.out.print("Enter customer name: ");
                String customerName = sc.nextLine();

                System.out.print("Enter phone number: ");
                String phoneNumber = sc.nextLine();

                System.out.print("Enter number of nights: ");
                int nights = sc.nextInt();

                if (nights <= 0) {
                    System.out.println("Number of nights must be greater than 0.");
                    break;
                }

                      // Create reservation
                      Reservation reservation = new Reservation(customerName,phoneNumber,selectedRoom,nights);

                      // Mark room as unavailable
                      selectedRoom.available = false;                   

                      // Add reservation
                      hotel.reservations.add(reservation);
             
                      System.out.println("\nRoom booked successfully!");
                      System.out.println("Customer: " + customerName);
                      System.out.println("Room: " + selectedRoom.roomNumber);
                      System.out.println("Nights: " + nights);
                      System.out.println("Total Amount: ₹" + reservation.totalAmount);

                       break;
                 
                                     case 3:

                       System.out.println("\n--------- RESERVATIONS ---------");

                       if (hotel.reservations.isEmpty()) {

                           System.out.println("No reservations found.");

                       } else {

                        for (Reservation r : hotel.reservations) {

                        System.out.println("Customer: " + r.customerName +" | Phone: " + r.phoneNumber +" | Room: " + r.room.roomNumber + " | Type: " + r.room.roomType +" | Nights: " + r.nights +" | Total: ₹" + r.totalAmount);
                         }
                     }

                     break;  
                     case 4:

    System.out.print("\nEnter room number to cancel reservation: ");
    int cancelRoomNumber = sc.nextInt();

    Reservation reservationToCancel = null;

    // Find reservation
    for (Reservation r : hotel.reservations) {

        if (r.room.roomNumber == cancelRoomNumber) {
            reservationToCancel = r;
            break;
        }
    }

    if (reservationToCancel == null) {

        System.out.println("No reservation found for this room.");

    } else {

        // Make room available again
        reservationToCancel.room.available = true;

        // Remove reservation
        hotel.reservations.remove(reservationToCancel);

        System.out.println("\nReservation cancelled successfully!");
        System.out.println("Room " + cancelRoomNumber + " is now available.");
    }

    break;

                case 5:
                    System.out.println("\nThank you for using the Hotel Reservation System!");
                    break;

                default:
                    System.out.println("\nFeature coming next!");
            }

        } while (choice != 5);

        sc.close();
    }
}