
/**
 * ============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue (Version 5.0)
 * ============================================================
 * Use Case 5: Booking Request (First-Come-First-Served)
 *
 * Description:
 * This program demonstrates how booking requests are collected
 * and stored using a Queue to ensure FIFO ordering.
 *
 * No inventory updates or allocation is performed here.
 *
 * @author Developer
 * @version 5.0
 * ============================================================
 */

import java.util.LinkedList;
import java.util.Queue;

/* =========================
   RESERVATION CLASS
   ========================= */
class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

/* =========================
   BOOKING REQUEST QUEUE
   ========================= */
class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request (enqueue)
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Request added for: " + reservation.getGuestName());
    }

    // View all requests
    public void displayQueue() {
        System.out.println("\n--- Booking Request Queue (FIFO Order) ---");

        if (requestQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
        }

        for (Reservation r : requestQueue) {
            r.displayReservation();
        }
    }

    // Peek next request (without removing)
    public Reservation peekNext() {
        return requestQueue.peek();
    }
}

/* =========================
   MAIN APPLICATION CLASS
   ========================= */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   BOOKING REQUEST QUEUE SYSTEM");
        System.out.println("========================================");

        // Initialize queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Simulate booking requests (arrival order matters)
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        // Add requests to queue
        queue.addRequest(r1);
        queue.addRequest(r2);
        queue.addRequest(r3);

        // Display queue
        queue.displayQueue();

        // Show next request to be processed
        System.out.println("\nNext request to process:");
        Reservation next = queue.peekNext();
        if (next != null) {
            next.displayReservation();
        }

        System.out.println("\nSystem execution completed.");
    }
}