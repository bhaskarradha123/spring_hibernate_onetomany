package spring_hiberbate_cart.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring_hiberbate_cart.dto.Cart;
import spring_hiberbate_cart.dto.Item;



@Component
public class CartDao {
 
	 @Autowired
	 private EntityManager entityManager;
    
  
    
    
	public Cart saveCart(Cart cart)
	{
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		
		 entityTransaction.begin();
		 entityManager.persist(cart);
		
	 
		 entityTransaction.commit();
		 System.out.println("successfully added");
		 return cart;
	}
	
	public Cart cartDetails(int id) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 return entityManager.find(Cart.class, id);
	}
	
	  
		public void updateeCart(Cart cart,int id)
		{
			 EntityTransaction entityTransaction=entityManager.getTransaction();
			 Cart cart2= entityManager.find(Cart.class, id);
			 if(cart2!=null) {
			 cart.setId(id);
			 cart.setItems(cart2.getItems());
			 entityTransaction.begin();
			 entityManager.merge(cart);
			
		
			 entityTransaction.commit();
			 System.out.println("successfully updated");
			 
			 }
		}
		
		  
		public void deleteCart(int id)
		{
			 EntityTransaction entityTransaction=entityManager.getTransaction();
			 Cart cart2= entityManager.find(Cart.class, id);
			 if(cart2!=null) {
			 entityTransaction.begin();
			 entityManager.remove(cart2);
			
		
			 entityTransaction.commit();
			 System.out.println("successfully deleted");
			 }
			 
			
		}
		
		public List<Cart> getAllCart() {
			
			Query query = entityManager.createQuery("SELECT i FROM Cart i");
			List<Cart> items = query.getResultList();
			return items;
		}
		
	
}
