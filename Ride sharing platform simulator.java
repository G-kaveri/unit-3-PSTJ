import java.util.Scanner;

class Vehicle {
    double calculateFare(double distance) {
        return 0;
    }
}

class Bike extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 5;
    }
}

class Auto extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Cab extends Vehicle {
    @Override
    double calculateFare(double distance) {
        return distance * 12;
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Trip {
    private final Vehicle vehicle;
    private final double distance;

    Trip(Vehicle vehicle, double distance) throws Exception {
        if (vehicle == null || distance <= 0) {
            throw new Exception("Invalid booking");
        }
        this.vehicle = vehicle;
        this.distance = distance;
    }

    double getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Vehicle vehicle;

                switch (type.toLowerCase()) {
                    case "bike":
                        vehicle = new Bike();
                        break;
                    case "auto":
                        vehicle = new Auto();
                        break;
                    case "cab":
                        vehicle = new Cab();
                        break;
                    default:
                        throw new Exception("Invalid ride type");
                }

                Trip trip = new Trip(vehicle, distance);
                System.out.println((int) trip.getFare());

            } catch (Exception e) {
                System