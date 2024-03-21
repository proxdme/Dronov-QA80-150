import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AviaSouls;
import ru.netology.Ticket;
import ru.netology.TicketTimeComparator;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AviaSoulsTest {
    @Test
    public void shouldFindEqualTickets() {

        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "New York", 300, 10, 15);
        Ticket ticket2 = new Ticket("New York", "Moscow", 110, 11, 16);
        Ticket ticket3 = new Ticket("Berlin", "New York", 230, 12, 14);
        Ticket ticket4 = new Ticket("Moscow", "New York", 210, 9, 11);
        Ticket ticket5 = new Ticket("Paris", "New York", 410, 10, 17);
        Ticket ticket6 = new Ticket("Berlin", "Moscow", 210, 13, 19);
        Ticket ticket7 = new Ticket("New York", "Berlin", 270, 17, 23);
        Ticket ticket8 = new Ticket("New York", "Paris", 210, 22, 6);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = aviaSouls.search("Moscow", "New York");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnyTicket() {

        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "New York", 300, 10, 15);
        Ticket ticket2 = new Ticket("New York", "Moscow", 110, 11, 16);
        Ticket ticket3 = new Ticket("Berlin", "New York", 230, 12, 14);
        Ticket ticket4 = new Ticket("Moscow", "New York", 210, 9, 11);
        Ticket ticket5 = new Ticket("Paris", "New York", 410, 10, 17);
        Ticket ticket6 = new Ticket("Berlin", "Moscow", 210, 13, 19);
        Ticket ticket7 = new Ticket("New York", "Berlin", 270, 17, 23);
        Ticket ticket8 = new Ticket("New York", "Paris", 210, 22, 6);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Moscow", "Los Angeles");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicket() {

        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "New York", 300, 10, 15);
        Ticket ticket2 = new Ticket("New York", "Moscow", 110, 11, 16);
        Ticket ticket3 = new Ticket("Berlin", "New York", 230, 12, 14);
        Ticket ticket4 = new Ticket("Moscow", "New York", 210, 9, 11);
        Ticket ticket5 = new Ticket("Paris", "New York", 410, 10, 17);
        Ticket ticket6 = new Ticket("Berlin", "Moscow", 210, 13, 19);
        Ticket ticket7 = new Ticket("New York", "Berlin", 270, 17, 23);
        Ticket ticket8 = new Ticket("New York", "Paris", 210, 22, 6);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket8};
        Ticket[] actual = aviaSouls.search("New York", "Paris");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEqualsTicket() {
        Ticket ticket1 = new Ticket("Moscow", "New York", 200, 10, 15);
        Ticket ticket2 = new Ticket("Moscow", "New York", 200, 10, 15);

        Assertions.assertEquals(ticket1, ticket2);
    }

    @Test
    public void shouldFindChipperTicket() {

        Ticket ticket1 = new Ticket("Moscow", "New York", 200, 10, 15);
        Ticket ticket2 = new Ticket("Moscow", "New York", 210, 10, 15);

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));

    }

    @Test
    public void shouldFindExpensiveTicket() {

        Ticket ticket1 = new Ticket("Moscow", "New York", 200, 10, 15);
        Ticket ticket2 = new Ticket("Moscow", "New York", 210, 10, 15);

        Assertions.assertEquals(1, ticket2.compareTo(ticket1));

    }

    @Test
    public void shouldFindEqualTicketSearchBy() {

        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "New York", 300, 10, 15);
        Ticket ticket2 = new Ticket("New York", "Moscow", 110, 11, 16);
        Ticket ticket3 = new Ticket("Berlin", "New York", 230, 12, 14);
        Ticket ticket4 = new Ticket("Moscow", "New York", 210, 9, 11);
        Ticket ticket5 = new Ticket("Paris", "New York", 410, 10, 17);
        Ticket ticket6 = new Ticket("Berlin", "Moscow", 210, 13, 19);
        Ticket ticket7 = new Ticket("New York", "Berlin", 270, 17, 23);
        Ticket ticket8 = new Ticket("New York", "Paris", 210, 22, 6);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "New York", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAnyTicketSearchBy() {

        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "New York", 300, 10, 15);
        Ticket ticket2 = new Ticket("New York", "Moscow", 110, 11, 16);
        Ticket ticket3 = new Ticket("Berlin", "New York", 230, 12, 14);
        Ticket ticket4 = new Ticket("Moscow", "New York", 210, 9, 11);
        Ticket ticket5 = new Ticket("Paris", "New York", 410, 10, 17);
        Ticket ticket6 = new Ticket("Berlin", "Moscow", 210, 13, 19);
        Ticket ticket7 = new Ticket("New York", "Berlin", 270, 17, 23);
        Ticket ticket8 = new Ticket("New York", "Paris", 210, 22, 6);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Los Angeles", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicketSearchBy() {

        AviaSouls aviaSouls = new AviaSouls();
        Ticket ticket1 = new Ticket("Moscow", "New York", 300, 10, 15);
        Ticket ticket2 = new Ticket("New York", "Moscow", 110, 11, 16);
        Ticket ticket3 = new Ticket("Berlin", "New York", 230, 12, 14);
        Ticket ticket4 = new Ticket("Moscow", "New York", 210, 9, 11);
        Ticket ticket5 = new Ticket("Paris", "New York", 410, 10, 17);
        Ticket ticket6 = new Ticket("Berlin", "Moscow", 210, 13, 19);
        Ticket ticket7 = new Ticket("New York", "Berlin", 270, 17, 23);
        Ticket ticket8 = new Ticket("New York", "Paris", 210, 22, 6);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket8};
        Ticket[] actual = aviaSouls.searchAndSortBy("New York", "Paris", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}

