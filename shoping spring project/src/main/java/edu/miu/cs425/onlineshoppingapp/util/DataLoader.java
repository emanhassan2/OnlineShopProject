package edu.miu.cs425.onlineshoppingapp.util;

import com.github.javafaker.Faker;
import edu.miu.cs425.onlineshoppingapp.model.*;
import edu.miu.cs425.onlineshoppingapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Year;
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
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private PasswordEncoder encoder;

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
            user.setUsername(faker.name().username());
            String pass = faker.internet().password();
            user.setPassword(encoder.encode(pass));
            user.setRawPassword(pass);
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
    private void creatNewProduct () {
        Review r1 = Review.builder().build();
        List<Review> reviews = new ArrayList<>();
        Image i1 = Image.builder().build();
        List<Image> images = new ArrayList<>();
        images.add(i1);

        //creat user
        User u1 = User.builder().build();

        Product p1 = Product.builder()
                .name("Bow Embellished Open Back Sweater")
                .category("Sweater")
                .price(56.00)
                .description("A cozy open back sweater with a touch of bling. This top is pairs perfectly with faux leather pants and booties for your next night out.")
                .images(images)
                .reviews(reviews)
                .build();
        CartItem c1 = CartItem.builder()
                .quantity(2)
                .product(p1)
                .build();
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(c1);
        // creat shopping cart
        ShoppingCart s1 = ShoppingCart.builder()
                .createdDate(faker.date().past(300, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .user(u1)
                .cartItem(cartItems)
                .build();
    }




}
