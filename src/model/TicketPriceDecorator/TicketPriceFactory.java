package model.TicketPriceDecorator;

import model.Metrocard;

public class TicketPriceFactory {

    public static TicketPrice createTicketPrice(boolean is24Min, boolean is64Plus, boolean isStudent, Metrocard metrocard) {
        TicketPrice ticketPrice = new BasicTicketPrice();



        return ticketPrice;
    }
}
