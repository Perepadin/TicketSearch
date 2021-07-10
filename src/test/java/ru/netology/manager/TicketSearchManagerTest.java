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

    @Test
    void findAllMany() {
        //  тест на поиск по все массиву с несколькими совпадениями
        ticketSearchManager.add(ticketSearch1);
        ticketSearchManager.add(ticketSearch2);
        ticketSearchManager.add(ticketSearch3);
        ticketSearchManager.add(ticketSearch4);
        ticketSearchManager.add(ticketSearch5);

        ticketSearchManager.findAll("AAA", "AAF");

        assertArrayEquals(new TicketSearch[]{ticketSearch1, ticketSearch5}, ticketSearchManager.findAll("AAA", "AAF"));
    }

    @Test
    void findAllOne() {
        //  тест на поиск по все массиву с одним совпадением
        ticketSearchManager.add(ticketSearch1);
        ticketSearchManager.add(ticketSearch2);
        ticketSearchManager.add(ticketSearch3);
        ticketSearchManager.add(ticketSearch4);
        ticketSearchManager.add(ticketSearch5);

        ticketSearchManager.findAll("ADD", "AAB");

        assertArrayEquals(new TicketSearch[]{ticketSearch3}, ticketSearchManager.findAll("ADD", "AAB"));
    }

    @Test
    void findAllNothing() {
        //  тест на поиск по все массиву с отсутствием совпадений
        ticketSearchManager.add(ticketSearch1);
        ticketSearchManager.add(ticketSearch2);
        ticketSearchManager.add(ticketSearch3);
        ticketSearchManager.add(ticketSearch4);
        ticketSearchManager.add(ticketSearch5);

        ticketSearchManager.findAll("GGG", "RFT");

        assertArrayEquals(new TicketSearch[]{}, ticketSearchManager.findAll("GGG", "RFT"));
    }
}
