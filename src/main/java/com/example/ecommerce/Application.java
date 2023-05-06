package com.example.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//    @Bean
//    CommandLineRunner commandLineRunner(
//            StudentRepository studentRepository,
//            StudentIdCardRepository studentIdCardRepository) {
//        return args -> {
//            Faker faker = new Faker();
//
//            String firstName = faker.name().firstName();
//            String lastName = faker.name().lastName();
//            String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
//            Student student = new Student(
//                    firstName,
//                    lastName,
//                    email,
//                    faker.number().numberBetween(17, 55));
//
//            student.addBook(
//                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));
//
//            student.addBook(
//                    new Book("Think and Grow Rich", LocalDateTime.now()));
//
//            student.addBook(
//                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));
//
//            StudentIdCard studentIdCard = new StudentIdCard(
//                    "123456789",
//                    student);
//
//            student.setStudentIdCard(studentIdCard);
//
//            student.addEnrolment(new Enrolment(
//                    new EnrolmentId(1L, 1L),
//                    student,
//                    new Course("Computer Science", "IT"),
//                    LocalDateTime.now()
//            ));
//
//            student.addEnrolment(new Enrolment(
//                    new EnrolmentId(1L, 2L),
//                    student,
//                    new Course("Amigoscode Spring Data JPA", "IT"),
//                    LocalDateTime.now().minusDays(18)
//            ));
//
//            student.addEnrolment(new Enrolment(
//                    new EnrolmentId(1L, 2L),
//                    student,
//                    new Course("Amigoscode Spring Data JPA", "IT"),
//                    LocalDateTime.now().minusDays(18)
//            ));
//
//
//
//            studentRepository.save(student);
//
//            studentRepository.findById(1L)
//                    .ifPresent(s -> {
//                        System.out.println("fetch book lazy...");
//                        List<Book> books = student.getBooks();
//                        books.forEach(book -> {
//                            System.out.println(
//                                    s.getFirstName() + " borrowed " + book.getBookName());
//                        });
//                    });
//
//        };

//    }

//	@Bean
//	CommandLineRunner clr(ProductRepository productRepository) {
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				Product milk = new Product("milk", 19.99);
//				Product product2 = productRepository.save(milk);
//				System.out.println("After save: " + product2);
//			}
//		};
//	}
	
	@Bean
	CommandLineRunner clrShoppingCart(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Product milk = new Product("milk", 19.99);
				Product product2 = productRepository.save(milk);
				System.out.println("After save: " + product2);
				
				Item item1 = new Item(product2, 4);
				
				ShoppingCart cartOfJohn = new ShoppingCart("John Trump", 10.00);
				cartOfJohn.getItems().add(item1);
				ShoppingCart savedCart = shoppingCartRepository.save(cartOfJohn);
				System.out.println("After save: " + savedCart);
				savedCart.getItems().get(0).setQuantity(128);
				shoppingCartRepository.save(savedCart);
			}
		};
	}
}
