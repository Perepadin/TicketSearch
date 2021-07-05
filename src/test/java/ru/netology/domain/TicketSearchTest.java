package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TicketSearchTest {

    @Test
    public void shouldUseEquals() {
        TicketSearch first = new TicketSearch(1, 200, "AAA", "AAB", 200);
        TicketSearch second = new TicketSearch(1, 200, "AAA", "AAB", 200);
        assertEquals(first, second);
    }
}