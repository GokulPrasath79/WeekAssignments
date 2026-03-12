import java.util.*;

public class Problem8 {

    static String[] parking = new String[500];

    public static int hash(String plate) {
        return Math.abs(plate.hashCode()) % parking.length;
    }

    public static void parkVehicle(String plate) {

        int index = hash(plate);
        int probes = 0;

        while (parking[index] != null) {
            index = (index + 1) % parking.length;
            probes++;
        }

        parking[index] = plate;

        System.out.println("Assigned spot #" + index + " (" + probes + " probes)");
    }

    public static void exitVehicle(String plate) {

        for (int i = 0; i < parking.length; i++) {
            if (plate.equals(parking[i])) {
                parking[i] = null;
                System.out.println("Spot #" + i + " freed");
                return;
            }
        }

        System.out.println("Vehicle not found");
    }

    public static void main(String[] args) {

        parkVehicle("ABC1234");
        parkVehicle("ABC1235");
        parkVehicle("XYZ9999");

        exitVehicle("ABC1234");
    }
}