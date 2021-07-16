package AirPlaneTicketSystem.Abstract_Classes;

import java.util.Scanner;

public abstract class FlightTicketSystem {
    protected static int numberOfSeats;
    protected static boolean[] seats;
    static Scanner scanner = new Scanner(System.in);

    public void setSeatsNumber() {

        System.out.println("Please enter the number of seats");
        int n = scanner.nextInt();
        while (n < 10) {
            System.out.println("Please enter a number that's bigger than 10");
            n = scanner.nextInt();
        }
        seats = new boolean[n];
        numberOfSeats = n;
        for (int i = 0; i < n; i++)
            seats[i] = false;
    }

    public int getSeatsNumber() {
        return numberOfSeats;
    }

    public boolean areEconomicSeatsFull() {
        for (int i = 5; i < numberOfSeats; i++) {
            if (!seats[i])
                return false;
        }
        return true;

    }

    public boolean areBusinessSeatsFull() {
        for (int i = 0; i < 5; i++) {
            if (!seats[i])
                return false;
        }
        return true;
    }

    public boolean areAllSeatsFull() {
        for (int i = 0; i < numberOfSeats; i++) {
            if (!seats[i])
                return false;
        }
        return true;
    }

    public void createTicket() {
        while (!areAllSeatsFull()) {
            System.out.println("To get a Business-class ticket press 0," +
                    " To get a Normal-class ticket press 1");

            int operation = scanner.nextInt();
            if (operation == 0) {
                if(areBusinessSeatsFull()){
                    System.out.println("All reservations are full, We're sorry!");
                    break;
                }
                for (int i = 0; i < 5; i++) {
                    if (!seats[i]) System.out.print(i + 1 + " ");
                }
                System.out.println("Please choose one of the following seats");
                int numberOfTheSeat = scanner.nextInt();
                while (((numberOfTheSeat > numberOfSeats) || numberOfTheSeat > 5) && seats[numberOfTheSeat]) {
                    System.out.println("Please enter a valid number!");
                    numberOfTheSeat = scanner.nextInt();
                }
                if (!seats[numberOfTheSeat - 1]) {
                    System.out.println("The reservation has been taken, Your seat number is " + numberOfTheSeat +
                            "\nHave a nice flight!");
                    seats[numberOfTheSeat - 1] = true;
                }
            } else if (operation == 1) {
                if(areEconomicSeatsFull()){
                    System.out.println("All reservations are full, We're sorry!");
                    break;
                }
                for (int i = 5; i < numberOfSeats; i++) {
                    if (!seats[i]) System.out.print(i + 1 + " ");
                }
                System.out.println("Please choose one of the following seats");

                int numberOfTheSeat = scanner.nextInt();
                while ((numberOfTheSeat > numberOfSeats) || numberOfTheSeat < 5) {
                    System.out.println("Please enter a valid number!");
                    numberOfTheSeat = scanner.nextInt();
                }
                if (!seats[numberOfTheSeat - 1]) {
                    System.out.println("The reservation has been taken, Your seat number is " + numberOfTheSeat +
                            "\nHave a nice flight!");
                    seats[numberOfTheSeat - 1] = true;
                }
            }
            System.out.println("If you want to quit press 1 or press any number to continue!");
            int quitOrNah = scanner.nextInt();
            if (quitOrNah == 1)
                break;
        }

    }
}
