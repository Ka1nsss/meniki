package kg.backend.meniki.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false, name = "cardnum")
    @Size(min = 10, max = 10, message = "размер должен находиться в диапазоне от 10 до 10")
    private String cardNum;

    @Column(nullable = false)
    private String cardType;

    @Column(nullable = false)
    private String expiryDate;

}
