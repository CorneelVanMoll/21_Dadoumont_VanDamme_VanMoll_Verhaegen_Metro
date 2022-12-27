package model.TicketPriceDecorator;

public class BasicTicketPrice extends TicketPrice {

    @Override
    public String getPriceText() {
        return String.valueOf(getPrice());
    }

    @Override
    public double getPrice() {
        return 2.10;
    }
}
