package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketSearch;
import ru.netology.repository.TicketSearchRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketSearchManagerTest {

    TicketSearchRepository ticketSearchRepository = new TicketSearchRepository();
    TicketSearchManager ticketSearchManager = new TicketSearchManager(ticketSearchRepository);

    TicketSearch ticketSearch1 = new TicketSearch(0, 2000, "AAA", "AAF", 300);
    TicketSearch ticketSearch2 = new TicketSearch(1, 4000, "ZAZ", "AAB", 350);
    TicketSearch ticketSearch3 = new TicketSearch(2, 6000, "ADD", "AAB", 150);
    TicketSearch ticketSearch4 = new TicketSearch(3, 7000, "MBA", "DAV", 200);
    TicketSearch ticketSearch5 = new TicketSearch(4, 5000, "AAA", "AAF", 220);
    TicketSearch ticketSearch6 = new TicketSearch(4, 5000, "AAA", "AAF", 180);

    @Test
    void findAllMany() {
        ticketSearchManager.add(ticketSearch1);
        ticketSearchManager.add(ticketSearch2);
        ticketSearchManager.add(ticketSearch3);
        ticketSearchManager.add(ticketSearch4);
        ticketSearchManager.add(ticketSearch5);
        ticketSearchManager.add(ticketSearch6);

        assertArrayEquals(new TicketSearch[]{ticketSearch6, ticketSearch5, ticketSearch1}, ticketSearchManager.findAll("AAA", "AAF",new TicketSearchByFlightTime()));
    }

    @Test
    void findAllOne() {
        ticketSearchManager.add(ticketSearch1);
        ticketSearchManager.add(ticketSearch2);
        ticketSearchManager.add(ticketSearch3);
        ticketSearchManager.add(ticketSearch4);
        ticketSearchManager.add(ticketSearch5);
        ticketSearchManager.add(ticketSearch6);

        assertArrayEquals(new TicketSearch[]{ticketSearch3}, ticketSearchManager.findAll("ADD", "AAB",new TicketSearchByFlightTime()));
    }

    @Test
    void findAllNothing() {
        ticketSearchManager.add(ticketSearch1);
        ticketSearchManager.add(ticketSearch2);
        ticketSearchManager.add(ticketSearch3);
        ticketSearchManager.add(ticketSearch4);
        ticketSearchManager.add(ticketSearch5);
        ticketSearchManager.add(ticketSearch6);

        assertArrayEquals(new TicketSearch[]{}, ticketSearchManager.findAll("GGG", "RFT",new TicketSearchByFlightTime()));
    }
}
