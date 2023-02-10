package spring_hiberbate_cart.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import spring_hiberbate_cart.dto.Cart;
import spring_hiberbate_cart.dto.Item;

@Component
public class ItemDao {
	@Autowired
	private EntityManager entityManager;

	public void saveItems(Cart cart,int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
        Cart cart2=entityManager.find(Cart.class,id);
        List<Item>item=cart.getItems();
        if(cart2!=null) {
        	//System.out.println(cart);
        	cart.setId(id);
    		cart.setPwd(cart2.getPwd());
    		cart.setEmail(cart2.getEmail());
    		List<Item>getitems=cart2.getItems();
    		item.addAll(getitems);
    		//System.out.println(cart);
    		entityTransaction.begin();
    		
    		for (Item item2 : item) {
				 entityManager.persist(item2);
			}
    		
    			entityManager.merge(cart);
    		
    		
    		entityTransaction.commit();
		System.out.println("successfully added");
        }

	}
	
	public Item cartDetails(int id) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 return entityManager.find(Item.class, id);
	}

	public void updateeItem(Item item,int id)
	{
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Item item2= entityManager.find(Item.class, id);
		 if(item2!=null) {
		 item.setId(id);	 
		 entityTransaction.begin();
		 entityManager.merge(item);
		
	
		 entityTransaction.commit();
		 System.out.println("successfully updated");
		 
		 }
	}
	
	public void deleteItem(int id) {

		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Item item2= entityManager.find(Item.class, id);
		 if(item2!=null) {
		 
				 
			 entityTransaction.begin();
			 entityManager.remove(item2);
			
		
			 entityTransaction.commit();
			 System.out.println("successfully updated");
			 
			 }
	}
	
	public List<Item> getAllItems() {
		
		Query query = entityManager.createQuery("SELECT i FROM Item i");
		List<Item> items = query.getResultList();
		return items;
	}
	
}
