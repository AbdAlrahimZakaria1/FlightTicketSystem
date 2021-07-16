package AirPlaneTicketSystem.Concrete_Classes;

import AirPlaneTicketSystem.Abstract_Classes.FlightTicketSystem;

public class PegasusAirLines extends FlightTicketSystem {

    public static void main(String[] args) {
        FlightTicketSystem pegasus = new PegasusAirLines();
        pegasus.setSeatsNumber();
        System.out.println("Welcome to Pegasus Airlines system!");
        pegasus.createTicket();
    }
}


