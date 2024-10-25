package kg.backend.meniki.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
 @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
 @Column(nullable = false)
  private String productName;

 @ManyToOne
 @JoinColumn(nullable = false)
  private Product product;

 @Column(nullable = false)
  private int quantity;

 @Column(nullable = false)
  private double price;

 @Column(nullable = false)
  private String description;


  @ManyToOne
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private Cart cart;


  public void add(CartItem item) {
    quantity += item.getQuantity();
    price += item.getPrice();
    description += item.getDescription();
  }


}
