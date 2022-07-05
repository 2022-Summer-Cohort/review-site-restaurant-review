package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Cuisine;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Restaurant;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repos.CuisineRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.RestaurantRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class Populator implements CommandLineRunner {

    private ReviewRepository reviewRepo;
    private RestaurantRepository restaurantRepo;
    private CuisineRepository cuisineRepo;
    private HashtagRepository hashtagRepo;

    public Populator(ReviewRepository reviewRepo, RestaurantRepository restaurantRepo, CuisineRepository cuisineRepo, HashtagRepository hashtagRepo) {
        this.reviewRepo = reviewRepo;
        this.restaurantRepo = restaurantRepo;
        this.cuisineRepo = cuisineRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // All the cuisines
        Cuisine american = new Cuisine("American", "/images/american-food.jpg");
        cuisineRepo.save(american);
        Cuisine chinese = new Cuisine("Chinese", "/images/chinese-food.jpg");
        cuisineRepo.save(chinese);
        Cuisine italian = new Cuisine("Italian", "/images/italian-food.jpg");
        cuisineRepo.save(italian);
        Cuisine mexican = new Cuisine("Mexican", "/images/mexican-food.jpg");
        cuisineRepo.save(mexican);
        Cuisine seafood = new Cuisine("Seafood", "/images/seafood.jpg");
        cuisineRepo.save(seafood);
        Cuisine pizza = new Cuisine("Pizza", "/images/pizza.jpg");
        cuisineRepo.save(pizza);

        // All the reviews
        Review best = new Review("Best", 5, "Best place to eat");
        reviewRepo.save(best);
        Review good = new Review("Good", 4, "Solid place to eat");
        reviewRepo.save(good);
        Review fair = new Review("Fair", 2, "Wont be coming often");
        reviewRepo.save(fair);
        Review poor = new Review("Poor", 1, "Do not eat here");
        reviewRepo.save(poor);

        // All the hashtags
        Hashtag delivers = new Hashtag("#Delivers");
        hashtagRepo.save(delivers);
        Hashtag dineIn = new Hashtag("#DineIn");
        hashtagRepo.save(dineIn);
        Hashtag takeout = new Hashtag("#Takeout");
        hashtagRepo.save(takeout);
        Hashtag greatService = new Hashtag("#GreatService");
        hashtagRepo.save(greatService);
        Hashtag badService = new Hashtag("#BadService");
        hashtagRepo.save(badService);
        Hashtag curbsidePickup = new Hashtag("#CurbsidePickup");
        hashtagRepo.save(curbsidePickup);
        Hashtag liveBand = new Hashtag("#LiveBand");
        hashtagRepo.save(liveBand);
        Hashtag noContactDelivery = new Hashtag("#NoContactDelivery");
        hashtagRepo.save(noContactDelivery);

        // Hashtags for each restaurant
            // Mexican Restaurants
        List<Hashtag> elVaqueroHashtags = new ArrayList<>();
        elVaqueroHashtags.add(dineIn);
        elVaqueroHashtags.add(curbsidePickup);
        elVaqueroHashtags.add(noContactDelivery);
        List<Hashtag> nadaHashtags = new ArrayList<>();
        nadaHashtags.add(dineIn);
        nadaHashtags.add(curbsidePickup);
        nadaHashtags.add(noContactDelivery);
        List<Hashtag> miMexicoHashtags = new ArrayList<>();
        miMexicoHashtags.add(dineIn);
        miMexicoHashtags.add(takeout);
        List<Hashtag> losAgavezHashtags = new ArrayList<>();
        losAgavezHashtags.add(dineIn);
        losAgavezHashtags.add(greatService);
        List<Hashtag> localCantinaHashtags = new ArrayList<>();
        localCantinaHashtags.add(dineIn);
        localCantinaHashtags.add(curbsidePickup);
        localCantinaHashtags.add(greatService);
        localCantinaHashtags.add(noContactDelivery);
            // Italian Restaurants
        List<Hashtag> bucaHashtags = new ArrayList<>();
        bucaHashtags.add(dineIn);
        bucaHashtags.add(curbsidePickup);
        bucaHashtags.add(noContactDelivery);
        List<Hashtag> dueAmiciHashtags = new ArrayList<>();
        dueAmiciHashtags.add(dineIn);
        dueAmiciHashtags.add(curbsidePickup);
        dueAmiciHashtags.add(noContactDelivery);
        List<Hashtag> basiItaliaHashtags = new ArrayList<>();
        basiItaliaHashtags.add(dineIn);
        basiItaliaHashtags.add(takeout);
        List<Hashtag> pasqualoneHashtags = new ArrayList<>();
        pasqualoneHashtags.add(dineIn);
        pasqualoneHashtags.add(greatService);
        List<Hashtag> marcellaHashtags = new ArrayList<>();
        marcellaHashtags.add(dineIn);
        marcellaHashtags.add(curbsidePickup);
        marcellaHashtags.add(greatService);
        marcellaHashtags.add(noContactDelivery);

        // Mexican Restaurants
        Restaurant elVaquero = new Restaurant("El Vaquero Mexican Restaurant", "2195 Riverside Dr, Columbus, OH 43221", "/images/el-vaquero.jpg", mexican, elVaqueroHashtags, best);
        restaurantRepo.save(elVaquero);
        Restaurant nada = new Restaurant("Nada", "220 W Nationwide Blvd, Columbus, OH 43215", "/images/nada.jpg", mexican, nadaHashtags, best);
        restaurantRepo.save(nada);
        Restaurant miMexico = new Restaurant("Mi Mexico Restaurant", "4775 E Main St, Columbus, OH 43213", "/images/mi-mexico.jpg", mexican, miMexicoHashtags, best);
        restaurantRepo.save(miMexico);
        Restaurant losAgavez = new Restaurant("Los Agavez Taqueria", "3166 N High St, Columbus, OH 43202", "/images/los-agavez-taqueria.webp", mexican, losAgavezHashtags, best);
        restaurantRepo.save(losAgavez);
        Restaurant localCantina = new Restaurant("Local Cantina Brewery District", "743 S High St, Columbus, OH 43206", "/images/local-cantina.jpg", mexican, localCantinaHashtags, best);
        restaurantRepo.save(localCantina);

        // Italian Restaurants
        Restaurant buca = new Restaurant("Buca di Beppo Italian Restaurant", "343 N Front St, Columbus, OH 43215", "/images/buca.jpg", italian, bucaHashtags, best);
        restaurantRepo.save(buca);
        Restaurant dueAmici = new Restaurant("Due Amici", "67 E Gay St, Columbus, OH 43215", "/images/due-amici.jpeg", italian, dueAmiciHashtags, best);
        restaurantRepo.save(dueAmici);
        Restaurant basiItalia = new Restaurant("Basi Italia", "811 Highland St, Columbus, OH 43215", "/images/basi-italia.jpg", italian, basiItaliaHashtags, best);
        restaurantRepo.save(basiItalia);
        Restaurant pasqualone = new Restaurant("Pasqualone's", "5766 Emporium Square, Columbus, OH 43231", "/images/pasqualones.jpg", italian, pasqualoneHashtags, best);
        restaurantRepo.save(pasqualone);
        Restaurant marcella = new Restaurant("Marcella's", "615 N High St, Columbus, OH 43215", "/images/marcellas.jpg", italian, marcellaHashtags, best);
        restaurantRepo.save(marcella);

        // American Restaurants
        Restaurant capCity = new Restaurant("Cap City Fine Diner and Bar", "1299 Olentangy River Rd, Columbus, OH 43212", "/images/cap-city.jpg", american, bucaHashtags, best);
        restaurantRepo.save(capCity);
        Restaurant teds = new Restaurant("Ted's Montana Grill", "191 W Nationwide Blvd, Columbus, OH 43215", "/images/teds-montana.jpg", american, dueAmiciHashtags, best);
        restaurantRepo.save(teds);
        Restaurant hubbardGrille = new Restaurant("Hubbard Grille", "793 N High St, Columbus, OH 43215", "/images/hubbard.jpg", american, basiItaliaHashtags, best);
        restaurantRepo.save(hubbardGrille);
        Restaurant skillet = new Restaurant("Skillet", "410 E Whittier St, Columbus, OH 43206", "/images/skillet.jpg", american, pasqualoneHashtags, best);
        restaurantRepo.save(skillet);
        Restaurant milestone = new Restaurant("Milestone 229", "229 S Civic Center Dr, Columbus, OH 43215", "/images/milestone.jpg", american, marcellaHashtags, best);
        restaurantRepo.save(milestone);

        // Chinese
        Restaurant sunflower = new Restaurant("Sunflower Chinese Restaurant", "7370 Sawmill Rd, Columbus, OH 43235", "/images/sunflower.jpg", chinese, bucaHashtags, best);
        restaurantRepo.save(sunflower);
        Restaurant neChinese = new Restaurant("NE Chinese Restaurant", "2620 N High St, Columbus, OH 43202", "/images/ne-chinese.jpg", chinese, dueAmiciHashtags, best);
        restaurantRepo.save(neChinese);
        Restaurant moy = new Restaurant("Moy's Chinese Restaurant", "1994 N High St, Columbus, OH 43201", "/images/moys.jpg", chinese, basiItaliaHashtags, best);
        restaurantRepo.save(moy);
        Restaurant luckyDragon = new Restaurant("Lucky Dragon", "2800 N High St, Columbus, OH 43202", "/images/lucky-dragon.jpg", chinese, pasqualoneHashtags, best);
        restaurantRepo.save(luckyDragon);
        Restaurant helen = new Restaurant("Helen's Asian Kitchen", "1070 E Dublin Granville Rd, Columbus, OH 43229", "/images/helens.jpg", chinese, marcellaHashtags, best);
        restaurantRepo.save(helen);

        // Seafood
        Restaurant kai = new Restaurant("Kai's Crab Boil", "839 Bethel Rd, Columbus, OH 43214", "/images/kais-crab.webp", seafood, bucaHashtags, best);
        restaurantRepo.save(kai);
        Restaurant fishMarket = new Restaurant("Columbus Fish Market", "1245 Olentangy River Rd, Columbus, OH 43212", "/images/columbus-fish.jpg", seafood, dueAmiciHashtags, best);
        restaurantRepo.save(fishMarket);
        Restaurant franks = new Restaurant("Frank's Fish And Seafood Carryout", "5249 Trabue Rd, Columbus, OH 43228", "/images/franks.jpg", seafood, basiItaliaHashtags, best);
        restaurantRepo.save(franks);
        Restaurant shrimp = new Restaurant("Shrimp Lips", "1624 Parsons Ave, Columbus, OH 43207", "/images/shrimp-lips.webp", seafood, pasqualoneHashtags, best);
        restaurantRepo.save(shrimp);
        Restaurant mitchell = new Restaurant("Mitchell's Ocean Club", "4002 Easton Station, Columbus, OH 43219", "/images/mitchell-oc.jpg", seafood, marcellaHashtags, best);
        restaurantRepo.save(mitchell);

        // Pizza
        Restaurant borgata = new Restaurant("Borgata Pizza Cafe", "5701 Parkville St, Columbus, OH 43229", "/images/borgata-pizza-cafe.jpg", pizza, bucaHashtags, best);
        restaurantRepo.save(borgata);
        Restaurant pizzaRustica = new Restaurant("Pizza Rustica", "17 S High St, Columbus, OH 43215", "/images/pizza-rustica.jpg", pizza, dueAmiciHashtags, best);
        restaurantRepo.save(pizzaRustica);
        Restaurant hounddog = new Restaurant("Hounddog's Pizza", "2657 N High St, Columbus, OH 43202", "/images/hounddogs.jpg", pizza, basiItaliaHashtags, best);
        restaurantRepo.save(hounddog);
        Restaurant adriatico = new Restaurant("Adriatico's New York Style Pizza", "1618 Neil Ave, Columbus, OH 43201", "/images/adriaticos.jpg", pizza, pasqualoneHashtags, best);
        restaurantRepo.save(adriatico);
        Restaurant goremade = new Restaurant("GoreMade Pizza", "936 N 4th St, Columbus, OH 43201", "/images/gormade.webp", pizza, marcellaHashtags, best);
        restaurantRepo.save(goremade);
    }
}
