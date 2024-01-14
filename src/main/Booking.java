package main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Booking {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Map<String, Ticket> booking = new HashMap<String, Ticket>();
        Ticket[] sectionA = new Ticket[10];
        Ticket[] sectionB = new Ticket[10];

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Please enter 0 for exit App");
            System.out.println("Please enter 1 for ticket booking");
            System.out.println("Please enter 2 for show the booking receipt");
            System.out.println("Please enter 3 for all user's booking per section");
            System.out.println("Please enter 4 for remove user from train");
            System.out.println("Please enter 5 for modify user's seat");
            System.out.println("Please Enter Now: ");
            if(s.hasNextInt()) {
                ch = s.nextInt();
                switch (ch) {
                    case 0:
                        System.out.println("Tata!");
                        return;

                    case 1:
                        System.out.println("Starting Ticket Booking!");
                        Ticket newTicket = new Ticket();
                        String[] emptySeat = findNextEmptySeat(sectionA, sectionB);
                        if (emptySeat == null) {
                            System.out.println("No seats Available, Sorry!  Exiting Now...");
                            break;
                        } else {
                            System.out.println("Enter User's First Name: ");
                            newTicket.setUserFirstName(s1.next());

                            System.out.println("Enter User's Last Name: ");
                            newTicket.setUserLastName(s1.next());

                            System.out.println("Enter User's Email: ");
                            String emailBooking = s1.next();
                            newTicket.setUserEmail(emailBooking);

                            newTicket.setSeat(emptySeat[0],emptySeat[1]);
                            if (emptySeat[1].equals("A")) {
                                sectionA[parseInt(emptySeat[0])-1] = newTicket;
                            } else {
                                sectionB[parseInt(emptySeat[0])-1] = newTicket;
                            }
                            booking.put(emailBooking, newTicket);
                            System.out.println("Ticket Booked!");
                            newTicket.printBooking();
                        }
                        break;
                    case 2:
                        if(booking.isEmpty()){
                            System.out.println("There are no Booking to show. Exiting Now...");
                        }else {
                            System.out.println("Please Enter User email: ");
                            String emailReceipt = s1.next();
                            if (booking.containsKey(emailReceipt)) {
                                System.out.println("Booking Exists for user");
                                booking.get(emailReceipt).printReceipt();
                            } else {
                                System.out.println("No Booking exist for the use. Exiting now ");
                                break;
                            }
                        }
                        break;

                    case 3:
                        if(booking.isEmpty()){
                            System.out.println("There are no Booking to show. Exiting Now...");
                        }else {
                            System.out.println("Please enter section Value('A' or 'B')");
                            String sectionNo = s1.next();
                            if(sectionNo.equals("A") || sectionNo.equals("B")){
                                if (sectionNo.equals("A")) {
                                    for (int i = 0; i < sectionA.length; i++) {
                                        if (sectionA[i] != null) {
                                            sectionA[i].printBooking();
                                        }
                                    }
                                } else {
                                    for (int i = 0; i < sectionB.length; i++) {
                                        if (sectionB[i] != null) {
                                            sectionB[i].printBooking();
                                        }
                                    }
                                }
                            }else{
                                System.out.println("Invalid Section Value, it should be either 'A' or 'B'. Exiting Now...");
                            }
                        }
                        break;
                    case 4:
                        if(booking.isEmpty()){
                            System.out.println("There are no Booking exists. Exiting Now...");
                        }else {
                            System.out.println("Enter User email to remove booking: ");
                            String emailRemove = s1.next();
                            String[] seatRemove = booking.get(emailRemove).getSeat();
                            if (seatRemove[1].equals("A")) {
                                sectionA[parseInt(seatRemove[0])-1] = null;
                            } else {
                                sectionB[parseInt(seatRemove[0])-1] = null;
                            }
                            booking.remove(emailRemove);
                            System.out.println("Booking removed for user: "+ emailRemove);
                        }
                        break;
                    case 5:
                        if(booking.isEmpty()){
                            System.out.println("There are no Booking exists. Exiting Now...");
                        }
                        else if(booking.size() == sectionA.length+sectionB.length){
                            System.out.println("There are no empty seats available. Exiting Now...");
                        }
                        else{
                            System.out.println("Enter User email to modify booking: ");
                            String emailModify = s1.next();
                            String[] emptySeatModify = findNextEmptySeat(sectionA,sectionB);
                            if(emptySeatModify == null){
                                System.out.println("No seats Available so Can't modify Seat, Sorry!  Exiting Now...");
                                break;
                            }else {
                                System.out.println("New seat is: "+emptySeatModify[0]+" "+emptySeatModify[1]);
                                //removing existing booking
                                Ticket ticketModify = booking.get(emailModify);
                                String[] seatExisting=ticketModify.getSeat();
                                String secExisting=String.valueOf(seatExisting[1]);
                                String seatNoModify = seatExisting[0];
                                if(secExisting.equals("A")){
                                    sectionA[parseInt(seatNoModify)]=null;
                                }else{
                                    sectionB[parseInt(seatNoModify)]=null;
                                }

                                // Adding new booking
                                String emptySecModify=emptySeatModify[1];
                                String emptySeatNoModify = emptySeatModify[0];
                                if(emptySecModify.equals("A")){
                                    sectionA[parseInt(emptySeatNoModify)]=ticketModify;
                                }else{
                                    sectionB[parseInt(emptySeatNoModify)]=ticketModify;
                                }
                                ticketModify.setSeat(emptySeatNoModify,emptySecModify);
                                booking.put(emailModify,ticketModify);
                                System.out.println("Booking modification Done!");
                                ticketModify.printBooking();
                            }
                        }
                        break;
                    default:
                        System.out.println("Invalid Option Entered, please check menu and enter again!");
                        break;
                }
            }else{
                System.out.println("Invalid Data. Exiting now");
                break;
            }
        } while (ch != 0);
    }

    public static String [] findNextEmptySeat(Ticket []s1,Ticket []s2) {
        for(int i = 0; i<s1.length; i++){
            if(s1[i]==null){
                return new String [] {Integer.toString(i+1),"A"};
            }
        }
        for(int i = 0; i<s2.length; i++){
            if(s2[i]==null){
                return new String [] {Integer.toString(i+1),"B"};
            }
        }
        return null;
    }
}