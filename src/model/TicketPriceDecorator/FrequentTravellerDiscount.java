package model.TicketPriceDecorator;

public class FrequentTravellerDiscount extends TicketPriceDiscountDecorator {

    public FrequentTravellerDiscount(TicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Override
    public double getPrice() {
        return this.ticketPrice.getPrice() - 0.20;
    }
}
