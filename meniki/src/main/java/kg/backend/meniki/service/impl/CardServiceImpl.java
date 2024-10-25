package kg.backend.meniki.service.impl;


import kg.backend.meniki.model.Card;
import kg.backend.meniki.repo.CardRepository;
import kg.backend.meniki.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardServiceImpl implements PaymentService {


     private final CardRepository cardRepository;


     public List<Card> getAllCards() {
          return cardRepository.findAll();
     }

     public Optional<Card> getCardById(Long id) {
          return cardRepository.findById(id);
     }

     public Card createCard(Card card) {
          return cardRepository.save(card);
     }

     public Card updateCard(Long id, Card cardDetails) {
          Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
          card.setCardNum(cardDetails.getCardNum());
          card.setCardType(cardDetails.getCardType());
          card.setExpiryDate(cardDetails.getExpiryDate());
          card.setName(cardDetails.getName());
          return cardRepository.save(card);
     }

     public void deleteCard(Long id) {
          Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
          cardRepository.delete(card);
     }
}




//        @Value("${stripe.api.key}")
//        private String stripeApiKey;
//
//        public void PaymentService() {
//            // Инициализация Stripe с API ключом
//             Stripe.apiKey = stripeApiKey;
//        }
//
//        public PaymentIntent createPaymentIntent(long amount, String currency) throws StripeException {
//            // Параметры создания платежа
//            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
//                    .setAmount(amount)
//                    .setCurrency(currency)
//                    .addPaymentMethodType(String.valueOf(List.of("card"))) // Оплата картой
//                    .build();
//
//            return PaymentIntent.create(params);
//        }
//
//
//        public Map<String, Object> createPayment(long amount) throws StripeException {
//            Map<String, Object> response = new HashMap<>();
//            PaymentIntent paymentIntent = createPaymentIntent(amount, "usd");
//
//            response.put("clientSecret", paymentIntent.getClientSecret());
//            return response;
//
//    }




