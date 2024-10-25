package kg.backend.meniki.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CartDto {
    private Long id;
    private String productName;
    private int quantity;
    private double price;
    private String description;

}
