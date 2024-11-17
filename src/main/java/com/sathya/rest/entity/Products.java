package com.sathya.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products {
	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO) // Use the appropriate strategy

 
	    private Long id;
	    private String name;
	    private int quantity;
	    private double price;
	    private String category;
	    private String image;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Products(Long id, String name, int quantity, double price, String category, String image) {
			super();
			this.id = id;
			this.name = name;
			this.quantity = quantity;
			this.price = price;
			this.category = category;
			this.image = image;
		}
		
		 public Products() {
		        // Hibernate requires a no-args constructor
		    }
		@Override
		public String toString() {
			return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price
					+ ", category=" + category + ", image=" + image + "]";
		}
	    
	    
}
