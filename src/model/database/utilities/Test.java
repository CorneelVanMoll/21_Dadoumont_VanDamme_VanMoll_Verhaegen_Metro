package model.database.utilities;

import model.MetroFacade;
import model.Metrocard;
import model.TicketPriceDecorator.TicketPrice;
import model.TicketPriceDecorator.TicketPriceFactory;
import model.database.MetrocardDatabase;

import java.time.Month;
import java.time.Year;

public class Test {
    public static void main(String[] args) {

        Metrocard metrocard = new Metrocard(1, Month.APRIL, Year.now(), 5,5);
        TicketPrice ticketPrice = TicketPriceFactory.createTicketPrice(true, true, true, metrocard);
        System.out.println("Modified price: " + ticketPrice.getPriceText());
    }


}
