import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfferManager {
    private static List<Offer> offers = new ArrayList<>();

    public static void addOffer(Offer offer) {
        offers.add(offer);
    }

    public static List<Offer> getOffersByLocation(String location) {
        return offers.stream()
                     .filter(offer -> offer.getLocation().equalsIgnoreCase(location))
                     .collect(Collectors.toList());
    }
}

