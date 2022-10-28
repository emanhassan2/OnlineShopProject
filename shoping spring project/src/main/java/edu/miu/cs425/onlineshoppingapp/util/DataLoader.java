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
//            List<Product> products = createProducts();
            List<User> users = createUsers();
//            createReviews(users, products);
            creatNewProduct();

        }

    }
    private void createReviews(List<User> users, List<Product> products) {
        for(int i = 0; i < 10; i++) {
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
        for(int i = 0; i < 10; i++) {
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
        for(int i = 0; i < 10; i++) {
            String name = faker.commerce().productName();
            Product product = Product.builder()
                    .name(name)
                    .category(faker.commerce().department())
                    .price(faker.number().randomDouble(2, 100, 1000))
                    .description(faker.food().ingredient())
                    .build();
//            productRepository.save(product);
            products.add(product);

            Image image = Image.builder()
                    .name(name)
                    .url("https://picsum.photos/" + faker.random().nextInt(450, 550) + "/" + faker.random().nextInt(250, 350))
                    .product(product)
                    .build();
//            imageRepository.save(image);
        }
        return products;
    }
    private void creatNewProduct () {
        // creat review
        Review r1 = Review.builder().build();
        List<Review> reviews = new ArrayList<>();

        //creat user
        User u1 = User.builder().build();

        Product p1 = Product.builder()
                .name("Bow Embellished Open Back Sweater")
                .category("Sweater")
                .price(56.00)
                .description("A cozy open back sweater with a touch of bling. This top is pairs perfectly with faux leather pants and booties for your next night out.")
                .reviews(reviews)
                .build();
        Product p2 = Product.builder()
                .name("lulus Sweater")
                .category("Sweater")
                .price(50.00)
                .description("A cozy open back sweater with a touch of bling. This top is pairs perfectly with faux leather pants and booties for your next night out.")
                .reviews(reviews)
                .build();
        Product p3 = Product.builder()
                .name("occassion dress")
                .category("Sweater")
                .price(90.00)
                .description("Length : Above knee/Mini\n" +
                        "\n" +
                        "Sleeve Style : Sleeveless\n" +
                        "\n" +
                        "Colors : Baby Blue, Mauve, Navy\n" +
                        "\n" +
                        "Sizes : 2, 4, 6, 8")
                .reviews(reviews)
                .build();
        Product p4 = Product.builder()
                .name("lulus Sweater")
                .category("shirt")
                .price(30.00)
                .description("Fair Indigo specializes in fair trade clothing.")
                .reviews(reviews)
                .build();
        Product p5 = Product.builder()
                .name("suit")
                .category("suit")
                .price(120.00)
                .description("he Man's Store (@neimansman) on Instagram")
                .reviews(reviews)
                .build();
        Product p6= Product.builder()
                .name("Faux Fur Denim Jacket")
                .category("Jacket")
                .price(70.00)
                .description("10 Ounce Indigo Denim\n" +
                        "\n" +
                        "Slim Fit\n" +
                        "\n" +
                        "Buttoned Closure\n" +
                        "\n" +
                        "Unlined\n" +
                        "\n" +
                        "Faux Fur Trim on the Collar and Button Placket")
                .reviews(reviews)
                .build();
        Product p7 = Product.builder()
                .name("PromGirl Sheer")
                .category("Dress")
                .price(120.00)
                .description("Here's a gorgeous long glitter prom dress with the newest and best trends for prom 2022. Sold exclusively at PromGirl, this shimmering v-neck evening")
                .reviews(reviews)
                .build();

        Product p8 = Product.builder()
                .name("Long & Short Dresses for Women")
                .category("Dress")
                .price(125.00)
                .description("A stunning halter neck style for this season, designed with a ruffle front and tiered hem. Dress it up or down for any occasion.")
                .reviews(reviews)
                .build();
        Product p9 = Product.builder()
                .name("Wedding Dress")
                .category("Dress")
                .price(125.00)
                .description("A stunning halter neck style for this season, designed with a ruffle front and tiered hem. Dress it up or down for any occasion.")
                .reviews(reviews)
                .build();

        Product p10 = Product.builder()
                .name("Summer Jackets of women")
                .category("Dress")
                .price(115.00)
                .description("It's not too late to invest in a great summer jacket.")
                .reviews(reviews)
                .build();
        // creat image
        Image i1 = Image.builder()
                .name("high neck sweaters")
                .url("https://ae01.alicdn.com/kf/HTB1CMdpaJjvK1RjSspiq6AEqXXaf/Warm-Autumn-Winter-Womens-Turtle-Neck-Sweater-High-Collar-Jumper-Long-Sleeve-Pullover-Plain-Sweater-Shirt.jpg")
                .product(p1)
                .build();
        Image i2 = Image.builder()
                .name("sweaters")
                .url("https://www.lulus.com/images/product/xlarge/8163681_895442.jpg?w=195&hdpi=1")
                .product(p2)
                .build();

        Image i3 = Image.builder()
                .name("dress")
                .url("https://cdn.shopify.com/s/files/1/1109/3312/products/dylan-and-davids-short-formal-sexy-prom-dress-the-dress-outlet-1.jpg?v=1665762934")
                .product(p3)
                .build();
        Image i4 = Image.builder()
                .name("Ethica clothing for men")
                .url("https://images.squarespace-cdn.com/content/v1/57fa9cafe4fcb5e6ab28144a/1559177159651-DHWO3NTPFEKX3DGMISGF/fair+trade+clothing+for+men")
                .product(p4)
                .build();
        Image i5 = Image.builder()
                .name("Ethica clothing for men")
                .url("https://i.pinimg.com/736x/b0/b8/29/b0b82984d4611c8a42c80edb563cf911.jpg")
                .product(p5)
                .build();
        Image i6 = Image.builder()
                .name("Jacket")
                .url("https://cdn.shopify.com/s/files/1/2343/5149/products/X_394x.jpg?v=1566598904")
                .product(p6)
                .build();
        Image i7 = Image.builder()
                .name("dress")
                .url("https://img.promgirl.com/_img/PGPRODUCTS/2409999/320/black-dress-PG-22-B2284-a.jpg")
                .product(p7)
                .build();
        Image i8 = Image.builder()
                .name("dress")
                .url("https://images.express.com/is/image/expressfashion/0094_07807542_2073?cache=on&wid=361&fmt=jpeg&qlt=75,1&resmode=sharp2&op_usm=1,1,5,0&defaultImage=Photo-Coming-Soon")
                .product(p8)
                .build();
        Image i9 = Image.builder()
                .name("dress")
                .url("https://bl.ipscdn.net/images/content/248_ONE_SIZE_IMAGE_01_133418_1858809960.jpg")
                .product(p9)
                .build();
        Image i10 = Image.builder()
                .name("Jacket")
                .url("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1659543845-arket-best-summer-jacket-1659543831.png?crop=0.9112801013941698xw:1xh;center,top&resize=320%3A%2A")
                .product(p10)
                .build();



//        List<Image> images = new ArrayList<>();
//        images.add(i1);
        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);
        productRepository.save(p6);
        productRepository.save(p7);
        productRepository.save(p8);
        productRepository.save(p9);
        productRepository.save(p10);

        imageRepository.save(i1);
        imageRepository.save(i2);
        imageRepository.save(i3);
        imageRepository.save(i4);
        imageRepository.save(i5);
        imageRepository.save(i6);
        imageRepository.save(i7);
        imageRepository.save(i8);
        imageRepository.save(i9);
        imageRepository.save(i10);

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
