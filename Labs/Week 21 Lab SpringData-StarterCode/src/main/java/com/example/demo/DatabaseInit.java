package com.example.demo;

import com.example.demo.Models.*;
import com.example.demo.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInit implements CommandLineRunner{
	@Autowired 
	private UserRepository userRepository;

	@Autowired
private ProduceRepository produceRepository;

@Autowired
private SellerProduceRepository sellerProduceRepository;

@Autowired
private OrderRepository orderRepository;

@Autowired
private OrderItemRepository orderItemRepository;
	
	@Override
	 public void run(String... args) throws Exception {
		orderItemRepository.deleteAll();
        orderRepository.deleteAll();
        sellerProduceRepository.deleteAll();
        produceRepository.deleteAll();
        userRepository.deleteAll();
	//User
		User user1 = new User("Bob","bob@sample.com", "bob_pass", UserType.BUYER);
		User user2 = new User("Prapanch", "prapanch@sample.com", "pass", UserType.SELLER);
		User user3 = new User("Ademola", "ademola@sample.com", "pass", UserType.BOTH);
		User user4 = new User("Zhixian", "zhixian@sample.com", "pass", UserType.BOTH);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);

		//Produce

		Produce produce1 = new Produce("Apple");
		Produce produce2 = new Produce("Lettuce");
		Produce produce3 = new Produce("Potatoes");
			
		produceRepository.save(produce1);
		produceRepository.save(produce2);
		produceRepository.save(produce3);

		// SellerProduce

		SellerProduce sp1 = new SellerProduce(user2, produce1, 0.15, 100); 
		SellerProduce sp2 = new SellerProduce(user2, produce2, 0.25, 20);
		SellerProduce sp3 = new SellerProduce(user3, produce2, 0.30, 50);
		SellerProduce sp4 = new SellerProduce(user3, produce3, 0.05, 30);
		
		sellerProduceRepository.save(sp1);
		sellerProduceRepository.save(sp2);
		sellerProduceRepository.save(sp3);
		sellerProduceRepository.save(sp4);

		//ORDER
		Order order1 = new Order(user1);
		Order order2 = new Order(user4);

		orderRepository.save(order1);
		orderRepository.save(order2);

		//ORDER ITEMS
		OrderItem oi1 = new OrderItem(order1, sp3, 2, 0.30);
        OrderItem oi2 = new OrderItem(order1, sp2, 1, 0.25);
        OrderItem oi3 = new OrderItem(order2, sp1, 10, 0.15);
        OrderItem oi4 = new OrderItem(order2, sp4, 15, 0.05);

        orderItemRepository.save(oi1);
        orderItemRepository.save(oi2);
        orderItemRepository.save(oi3);
        orderItemRepository.save(oi4);

		System.out.println("Database initialised successfully!");
	}
}
