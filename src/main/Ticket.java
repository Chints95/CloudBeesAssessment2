package main;

public class Ticket extends User {
    String fromStation = "London";
    String toStation = "France";
    String price = "20$";

    String seat;
    String section;

    public void setSeat(String seat, String section) {
        this.seat = seat;
        this.section = section;
    }
    public String[] getSeat() {
        return new String [] {seat,section};
    }
    public void printReceipt() {
        System.out.println("Booking Receipt are:");
        System.out.println("FromStation: "+ fromStation);
        System.out.println("toStation: "+ toStation);
        System.out.println("main.User First Name: "+ getUserFirstName());
        System.out.println("main.User Last Name: "+ getUserLastName());
        System.out.println("main.User Email: "+ getUserEmail());
        System.out.println("Price Paid: "+ price);
    }

    public void printBooking() {
        System.out.println("Booking Details for main.User: "+ getUserEmail());
        System.out.println("main.User First Name: "+ getUserFirstName());
        System.out.println("main.User Last Name: "+ getUserLastName());
        System.out.println("main.User Email: "+ getUserEmail());
        System.out.println("Seat Detail: "+ getSeat()[0]);
    }
}
