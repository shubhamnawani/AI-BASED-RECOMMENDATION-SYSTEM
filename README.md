# AI-BASED-RECOMMENDATION-SYSTEM

"COMPANY" : CODTECH IT SOLUTIONS PVT.LTD

"NAME": SHUBHAM NAWANI

"INTERN ID": CT08DA523

"DOMAIN": JAVA PROGRAMMING

"DURATION": 8 WEEKS

"MENTOR": NEELA SANTOSH

#DESCRIPTION

AI-Based Recommendation System

Task Overview
For my internship project, I developed an AI-Based Recommendation System using Apache Mahout and Java. The system suggests products to users based on their preferences by using collaborative filtering. The recommendation engine is designed to predict items that users may like, based on their past ratings and the ratings of similar users.

The system leverages Apache Mahout, a popular machine learning library, to perform similarity computations and generate personalized recommendations. This type of recommendation system is widely used in e-commerce platforms, content services, and more, to help users discover products or content they may like.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Tools and Technologies Used
Java: The core programming language used to implement the system.

Apache Mahout: A machine learning library for scalable recommendation engines, used for calculating user similarity and generating recommendations.

Maven: A build automation tool used to manage project dependencies and the build process.

SLF4J and Logback: Used for logging and debugging purposes during development.

IDE used : IntelliJ IDEA
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Project Structure
The project follows a Maven-based structure, with the following primary components:

RecommendationEngine.java: The main Java file that implements the recommendation logic.

dataset.csv: A simple user-item-rating dataset that serves as input for the recommendation engine.

pom.xml: The Maven configuration file which defines dependencies and build configurations.

Folder Structure:

RecommendationSystem/
├── data/
│   └── dataset.csv         # User-item-rating data file
├── src/
│   └── main/
│       └── java/
│           └── RecommendationEngine.java   # Java source code for recommendation engine
├── pom.xml                 # Maven project file

How the System Works
1. Loading the Data:
The system loads a CSV file (dataset.csv) containing user-item ratings into a DataModel using Apache Mahout's FileDataModel class. The data consists of user IDs, product IDs, and ratings.

UserID, ProductID, Rating
1, 101, 4.5
1, 102, 3.5
...
2. Similarity Calculation:
We calculate user similarity using the Tanimoto Coefficient, which is a measure of similarity between two users based on their ratings of common items.

UserSimilarity similarity = new TanimotoCoefficientSimilarity(model);

3. User Neighborhood:
To find users with similar preferences, we define a user neighborhood. In this case, the system considers the 5 most similar users (nearest neighbors) using the NearestNUserNeighborhood class.

UserNeighborhood neighborhood = new NearestNUserNeighborhood(5, similarity, model);

4. Recommendation Generation:
The recommendation engine generates personalized product recommendations based on the similarity of users and their ratings. The system recommends the top n products for a given user.

GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
List<RecommendedItem> recommendations = recommender.recommend(userId, 3);

5. Product Mapping:
Each product is mapped to a readable name (e.g., "Bluetooth Speaker", "Phone Charger") for easy interpretation of the recommendations.

Map<Long, String> productMap = new HashMap<>();
productMap.put(101L, "Bluetooth Speaker");
productMap.put(102L, "Phone Charger");
...

6. Output:
For a given user, the system outputs the top n recommended products along with their scores, which reflect how much the system thinks the user will like the item.


System.out.println("📦 Product Recommendations for User " + userId + ":");
if (recommendations.isEmpty()) {
    System.out.println("No recommendations found.");
} else {
    for (RecommendedItem item : recommendations) {
        String productName = productMap.getOrDefault(item.getItemID(), "Unknown Product");
        System.out.println("👉 " + productName + " (Score: " + item.getValue() + ")");
    }
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Setting Up the Project
1. Clone or Download the Repository:
Clone or download the repository to your local machine.

2. Maven Dependencies:
Ensure you have Maven installed on your system. The necessary dependencies for Apache Mahout and other libraries are already defined in the pom.xml file.



<dependency>
  <groupId>org.apache.mahout</groupId>
  <artifactId>mahout-core</artifactId>
  <version>0.9</version>
</dependency>

3. Running the Program:
Prepare the Dataset:

Place the dataset.csv file in the data/ folder.

Build and Run:

Open your terminal and navigate to the project directory.

Use the following Maven command to build and run the project:



mvn clean compile exec:java
The program will load the dataset, calculate recommendations, and display the top recommendations for a user.


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Conclusion
This AI-Based Recommendation System leverages collaborative filtering techniques to suggest products based on user preferences. By using Apache Mahout, the system computes similarities between users and provides recommendations. This system can be extended to handle larger datasets, integrate with real-world e-commerce platforms, and offer more advanced recommendation algorithms.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#OUTPUT

![Image](https://github.com/user-attachments/assets/aed65303-f8e1-48fb-863b-80df27659855)
