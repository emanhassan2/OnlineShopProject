package edu.miu.cs425.onlineshoppingapp.util;

import com.github.javafaker.Faker;
import edu.miu.cs425.onlineshoppingapp.model.Image;
import edu.miu.cs425.onlineshoppingapp.model.Product;
import edu.miu.cs425.onlineshoppingapp.model.Review;
import edu.miu.cs425.onlineshoppingapp.model.User;
import edu.miu.cs425.onlineshoppingapp.repository.ImageRepository;
import edu.miu.cs425.onlineshoppingapp.repository.ProductRepository;
import edu.miu.cs425.onlineshoppingapp.repository.ReviewRepository;
import edu.miu.cs425.onlineshoppingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ImageRepository imageRepository;

    private Faker faker = new Faker();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (productRepository.count() == 0){
            List<Product> products = createProducts();
            List<User> users = createUsers();
            createReviews(users, products);

        }

    }



    private void createReviews(List<User> users, List<Product> products) {
        for(int i = 0; i < 5; i++) {
            Review review = new Review();
            int randUser = (int) (Math.random() * ((users.size() - 1) + 1));
            review.setUser(users.get(randUser));
            int randPrd = (int) (Math.random() * ((products.size() - 1) + 1));
            review.setProduct(products.get(randPrd));
            review.setReviewDate(faker.date().past(300, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            review.setComment(faker.lorem().paragraph());
            review.setRating(faker.number().randomDouble(2, 0, 5));

            reviewRepository.save(review);
        }
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            User user = new User();
            user.setFirstName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setMiddleName(faker.name().nameWithMiddle());

            userRepository.save(user);
            users.add(user);
        }
        return users;
    }

    private List<Product> createProducts(){
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            String name = faker.commerce().productName();
            Product product = Product.builder()
                    .name(name)
                    .category(faker.commerce().department())
                    .price(faker.number().randomDouble(2, 100, 1000))
                    .description(faker.food().ingredient())
                    .build();
            productRepository.save(product);
            products.add(product);

            Image image = Image.builder()
                    .name(name)
                    .url("https://picsum.photos/" + faker.random().nextInt(450, 550) + "/" + faker.random().nextInt(250, 350))
                    .product(product)
                    .build();
            imageRepository.save(image);
        }
        return products;
    }


}
