package model.TicketPriceDecorator;

public class StudentDiscount extends TicketPriceDiscountDecorator {

    public StudentDiscount(TicketPrice ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    @Override
    public double getPrice() {
        return this.ticketPrice.getPrice() - 0.25;
    }
}
