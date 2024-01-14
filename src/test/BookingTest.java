package test;

import main.Booking;
import main.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking m = new Booking();
    //@Test
    //void main() {
    //}

    @Test
    void findNextEmptySeat() {
        Ticket[] s1=new Ticket[1];
        s1[0]= new Ticket();
        s1[0].setSeat("1","A");
        Ticket[] s2=new Ticket[1];
        assertArrayEquals(new String[]{"1","B"},m.findNextEmptySeat(s1,s2));

        s2[0] = new Ticket();
        s2[0].setSeat("1","B");
        assertNull(m.findNextEmptySeat(s1,s2));

    }
}