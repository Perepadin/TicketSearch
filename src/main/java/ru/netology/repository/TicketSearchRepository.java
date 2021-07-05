package ru.netology.repository;

import ru.netology.domain.TicketSearch;

public class TicketSearchRepository {
    private TicketSearch[] items = new TicketSearch[0];

    public void save(TicketSearch item) {
        int length = items.length + 1;
        TicketSearch[] tmp = new TicketSearch[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketSearch[] findAll() {
        return items;
    }

    public TicketSearch findById(int idToFind) {
        for (TicketSearch item : items) {
            if (item.getId() == idToFind) {
                return item;
            }
        }
        return null;
    }

    public TicketSearch removeById(int idToRemove) {
        if (idToRemove > items.length) {
            System.out.println("Не существует объекта с таким ID");

            return null;
        }
        int length = items.length - 1;
        TicketSearch[] tmp = new TicketSearch[length];
        int index = 0;
        for (TicketSearch item : items) {
            if (item.getId() != idToRemove) {
                tmp[index] = item;
                index++;
            }
        }
        return null;
    }
}
