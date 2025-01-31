package com.rben23.pokeCards.controllers;

import com.rben23.pokeCards.dtos.CardDTO;
import com.rben23.pokeCards.models.Card;
import com.rben23.pokeCards.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pokeCards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/getCardByName{name}")
    public ResponseEntity<CardDTO> getCardByName(String name) {
        if (name != null && !name.isEmpty()) {
            return ResponseEntity.ok(cardService.getCardByName(name));
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllCards")
    public ResponseEntity<List<CardDTO>> getAllCards() {
        List<CardDTO> cards = cardService.getAllCards();

        if (cards.isEmpty()) {
            return ResponseEntity.noContent().build(); // Codigo No cartas (204)
        }
        return ResponseEntity.ok(cards); // Codigo OK, hay cartas (200)
    }

    @PostMapping("/addCard")
    public Card addCard(@RequestBody Card card) {
        return cardService.addCard(card);
    }

    @PostMapping("/addCards")
    public Card addCards(@RequestBody List<Card> cards) {
        return cardService.addCards(cards);
    }

    @DeleteMapping("/deleteCard")
    public void deleteCard(@RequestBody Card card) {
        cardService.deleteCard(card);
    }

    @DeleteMapping("/deleteCards")
    public void deleteCards(@RequestBody List<Card> cards) {
        cardService.deleteCards(cards);
    }

}