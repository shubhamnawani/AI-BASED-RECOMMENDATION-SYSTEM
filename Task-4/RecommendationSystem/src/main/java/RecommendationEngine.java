import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;

import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendationEngine {

    public static void main(String[] args) {
        try {
            // Step 1: Load dataset
            File dataFile = new File("data/dataset.csv");
            DataModel model = new FileDataModel(dataFile);
            System.out.println("Loaded " + model.getNumUsers() + " users and " + model.getNumItems() + " products.");

            // Step 2: Define similarity & neighborhood
            UserSimilarity similarity = new TanimotoCoefficientSimilarity(model);


            UserNeighborhood neighborhood = new NearestNUserNeighborhood(5, similarity, model);


            // Step 3: Create recommender
            GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Step 4: Product ID to Product Name map
            Map<Long, String> productMap = new HashMap<>();
            productMap.put(101L, "Bluetooth Speaker");
            productMap.put(102L, "Phone Charger");
            productMap.put(103L, "Laptop Bag");
            productMap.put(104L, "Power Bank");

            // Step 5: Recommend for a specific user
            int userId = 1;  // you can change this to test other users
            List<RecommendedItem> recommendations = recommender.recommend(userId, 3);

            System.out.println("\n📦 Product Recommendations for User " + userId + ":");
            if (recommendations.isEmpty()) {
                System.out.println("No recommendations found.");
            } else {
                for (RecommendedItem item : recommendations) {
                    String productName = productMap.getOrDefault(item.getItemID(), "Unknown Product");
                    System.out.println("👉 " + productName + " (Score: " + item.getValue() + ")");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
