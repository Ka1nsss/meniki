package kg.backend.meniki.controller;

import kg.backend.meniki.model.Card;
import kg.backend.meniki.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final PaymentService cardService;

    public CardController(PaymentService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/get-all-cards")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return cardService.getCardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Card createCard(@RequestBody Card card) {
        return cardService.createCard(card);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardDetails) {
        return ResponseEntity.ok(cardService.updateCard(id, cardDetails));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}



