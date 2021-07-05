package ru.netology.repository;

import org.junit.jupiter.api.Test;

import ru.netology.domain.TicketSearch;

import static org.junit.jupiter.api.Assertions.*;

class TicketSearchRepositoryTest {

    private TicketSearchRepository ticketSearchRepository = new TicketSearchRepository();
    TicketSearch ticketSearch1 = new TicketSearch(0, 2000, "AAA", "AAF",269);
    TicketSearch ticketSearch2 = new TicketSearch(1, 4000, "ZAZ", "AAB",269);

    @Test
    void  shouldSaveItem() {
        ticketSearchRepository.save(ticketSearch1);
        ticketSearchRepository.save(ticketSearch2);

        TicketSearch[] expected = new TicketSearch[]{ticketSearch1, ticketSearch2};
        TicketSearch[] actual = ticketSearchRepository.findAll();

        assertArrayEquals(expected, actual);
    }

}