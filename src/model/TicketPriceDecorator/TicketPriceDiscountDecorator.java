package model.TicketPriceDecorator;

import sun.security.krb5.internal.Ticket;

public abstract class TicketPriceDiscountDecorator extends TicketPrice {

    TicketPrice ticketPrice;

    @Override
    public String getPriceText() {
        return String.valueOf(ticketPrice.getPrice());
    }

}
