package src.fawry.challenge;

import java.util.List;

public class ShippingService {
    private static final double SHIP_RATE_PER_KG = 15.0; // EGP per kg

    public static double ship(List<Shippable> shippables) {
        double totalWeight = shippables.stream()
                .mapToDouble(Shippable::getWeight)
                .sum();
        double fees = totalWeight * SHIP_RATE_PER_KG;
        System.out.printf("ShippingService: total weight = %.2f kg, fees = %.2f%n",
                totalWeight, fees);
        return fees;
    }
}
