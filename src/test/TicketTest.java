package test;

import main.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void setSeat() {
        Ticket t=new Ticket();
        t.setSeat("10","A");
        assertArrayEquals(new String []{"10","A"},t.getSeat());
    }

    @Test
    void getSeat() {
        Ticket t=new Ticket();
        assertArrayEquals(new String []{null,null},t.getSeat());
    }
}