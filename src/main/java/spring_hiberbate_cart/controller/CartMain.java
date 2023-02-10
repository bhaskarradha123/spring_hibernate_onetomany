package spring_hiberbate_cart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_hiberbate_cart.dao.CartDao;
import spring_hiberbate_cart.dao.ItemDao;
import spring_hiberbate_cart.dto.Cart;
import spring_hiberbate_cart.dto.CartConfig;
import spring_hiberbate_cart.dto.Item;

public class CartMain {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 
		ApplicationContext context=new AnnotationConfigApplicationContext(CartConfig.class);
		Cart cart=context.getBean("cart",Cart.class);
		
		CartDao dao=context.getBean("cartDao",CartDao.class);
		ItemDao dao2=context.getBean("itemDao",ItemDao.class);
		
		
		
		

		
		boolean check=true;
		do {
			
			System.out.println("choose your options \n 1.Save Cart \n 2.SaveItems"
					+ "\n 3.Update Cart \n 4.Update Item  \n 5.Delete Cart"
					+ "\n 6.Delete Item \n 7.Cart List \n 8.ItemsList   \n 9.Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
			{   System.out.println("Enter your email");
				String email=sc.next();
				System.out.println("enter your password");
				String pwd=sc.next();
				cart.setEmail(email);
			
				cart.setPwd(pwd);
				
				dao.saveCart(cart);
			}
				break;
			case 2:{
				
				List<Item>list=new ArrayList<Item>();
				System.out.println("Enter your id to add items");
				int id=sc.nextInt();
				boolean check2=true;
				do {
					System.out.println("choose \n 1.Additem \n 2.Exit");
				
					int choose=sc.nextInt();
					switch (choose) {
					case 1:{
						Item item=context.getBean("item",Item.class);
						System.out.println("Enter id");
						int itemid=sc.nextInt();
						System.out.println("Enter item name");
						String name=sc.next();
						System.out.println("Enter item cost");
						double cost=sc.nextDouble();
						System.out.println("Enter item manufature");
						String manufature=sc.next();
						System.out.println("Enter item review");
						String review=sc.next();
						
						item.setId(itemid);
						item.setCost(cost);
						item.setManufature(manufature);
						item.setName(name);
						item.setReview(review);
						list.add(item);
					
						
					}
						
						break;

					case 2:
						check2=false;
					}

					
				} while (check2);
				
				cart.setItems(list);
				dao2.saveItems(cart, id);
				
			}break;
			case 3:
			{
				System.out.println("Enter id to update");
				int id=sc.nextInt();
				Cart cart2=dao.cartDetails(id);
				System.out.println(cart2);
				System.out.println("these are your details press Y to change press N for exit");
				char ch=sc.next().charAt(0);
				if(ch=='Y'||ch=='y') {
				System.out.println("Enter your email");
				String email=sc.next();
				System.out.println("enter your password");
				String pwd=sc.next();
				cart.setEmail(email);
			
				cart.setPwd(pwd);
				dao.updateeCart(cart, id);
				}
			
				
			}break;
			case 4:{
				Item item=context.getBean("item",Item.class);
				System.out.println("Enter id to update the item");
				int id=sc.nextInt();
				Item item2=dao2.cartDetails(id);
				System.out.println(item2);
				System.out.println("these are your details press Y to change press N for exit");
				char ch=sc.next().charAt(0);
				if(ch=='Y'||ch=='y') {

					System.out.println("Enter item name");
					String name=sc.next();
					System.out.println("Enter item cost");
					double cost=sc.nextDouble();
					System.out.println("Enter item manufature");
					String manufature=sc.next();
					System.out.println("Enter item review");
					String review=sc.next();
					
					
					item.setCost(cost);
					item.setManufature(manufature);
					item.setName(name);
					item.setReview(review);
					dao2.updateeItem(item, id);
					
				}
				
			}break;
			case 5:{
				System.out.println("Enter id to delete the cart");
				int id=sc.nextInt();
				dao.deleteCart(id);
			}break;
			case 6:{
              try {
            		System.out.println("Enter id to delete the item");
    				int id=sc.nextInt();
    				dao2.deleteItem(id);
			} catch (Exception e) {
				System.out.println("you cant delete the item");
			}
			}break;
			case 7:
			{
				System.out.println(dao.getAllCart());
				
			}break;
			case 8:{
				 System.out.println( dao2.getAllItems());
			}break;
			case 9:check=false;

			
			}
		} while (check);
		
		
	
		

	}

}
