package spring_hiberbate_cart.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String email;
 private String pwd;
 @OneToMany
 @Autowired
 private List<Item>items;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public List<Item> getItems() {
	return items;
}
public void setItems(List<Item> items) {
	this.items = items;
}
@Override
public String toString() {
	return "Cart [id=" + id + ", email=" + email + ", pwd=" + pwd + ", items=" + items + "]";
}
 
 
 
 
}
