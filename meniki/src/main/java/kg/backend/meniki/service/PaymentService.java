package kg.backend.meniki.service;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import kg.backend.meniki.model.Card;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PaymentService {
    List<Card> getAllCards();

    Optional<Card> getCardById(Long id);

    Card createCard(Card card);

    Card updateCard(Long id, Card cardDetails);

    void deleteCard(Long id);
}
