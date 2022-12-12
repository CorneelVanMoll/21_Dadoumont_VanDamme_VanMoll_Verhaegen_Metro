package model.database.utilities;

import model.MetroFacade;
import model.database.MetrocardDatabase;

public class Test {
    public static void main(String[] args) {
        MetroFacade facade = new MetroFacade();
        System.out.println(facade.getMetroCardList());
    }
}
