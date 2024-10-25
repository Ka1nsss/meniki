package kg.backend.meniki.model;

import jakarta.persistence.*;
import kg.backend.meniki.model.security.User;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "carts")
@Data
public class Cart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
//   @JoinColumn(name = "user_id")
   private User user;

   @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
   private List<CartItem> cartItems;


   @ManyToMany
   private List<Product> product;

   public void addItem(CartItem item) {
      item.add(item);
      item.setCart(this);
   }
}

