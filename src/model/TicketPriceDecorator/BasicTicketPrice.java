package model.TicketPriceDecorator;

public class BasicTicketPrice extends TicketPrice {

    @Override
    public String getPriceText() {
        return this.getEuros().format(this.getPrice());
    }

    @Override
    public double getPrice() {
        return 2.10;
    }
}
