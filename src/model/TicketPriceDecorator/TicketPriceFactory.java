package model.TicketPriceDecorator;

import model.Metrocard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class TicketPriceFactory {

    private static List<String> discounts;

    public static TicketPrice createTicketPrice(boolean is24Min, boolean is64Plus, boolean isStudent, Metrocard metrocard) {
        TicketPrice ticketPrice = new BasicTicketPrice(metrocard.getUsedTrips());
        ticketPrice.setIs24Min(is24Min);
        ticketPrice.setIs64Plus(is64Plus);
        ticketPrice.setStudent(isStudent);
        System.out.println("Original price: " + ticketPrice.getPriceText());

        try {
            for (String discount : discounts) {
                Class<?> clazz = Class.forName(TicketPriceDiscountEnum.valueOf(discount).getClassName());
                Constructor<?> constructor = clazz.getConstructor(TicketPrice.class);
                ticketPrice = (TicketPrice) constructor.newInstance(ticketPrice);
                System.out.println(TicketPriceDiscountEnum.valueOf(discount).getName());
                System.out.println(ticketPrice.getPriceText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ticketPrice;
    }

    public static List<String> loadDiscounts() {
        BufferedReader reader;
        String discountString;
        try {
            reader = new BufferedReader(new FileReader("settings.txt"));
            reader.readLine();
            discountString = reader.readLine();
            discounts = Arrays.asList(discountString.split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return discounts;
    }
}
