package kg.backend.meniki.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
public class ProductDto {

    public ProductDto(Long id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    private Long id;


    private String name;


    private String description;


    private double price;


    private int quantity;
}
