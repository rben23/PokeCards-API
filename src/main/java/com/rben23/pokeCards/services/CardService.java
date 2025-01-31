package com.rben23.pokeCards.services;

import com.rben23.pokeCards.dtos.CardDTO;
import com.rben23.pokeCards.models.Card;
import com.rben23.pokeCards.repositories.CardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CardDTO getCardByName(String name){
        Card card = cardRepository.findByName(name);
        CardDTO cardDTO = new CardDTO();

        cardDTO.setName(card.getName());
        cardDTO.setType(card.getType());
        cardDTO.setRarity(card.getRarity());
        cardDTO.setImageUrl(card.getImageUrl());

        return cardDTO;
    }

    public List<CardDTO> getAllCards() {
        List<Card> allCards = cardRepository.findAll();
        ArrayList<CardDTO> cardDTOs = new ArrayList<>();

        for (Card card : allCards) {
            CardDTO cardDTO = new CardDTO();

            cardDTO.setName(card.getName());
            cardDTO.setType(card.getType());
            cardDTO.setRarity(card.getRarity());
            cardDTO.setImageUrl(card.getImageUrl());

            cardDTOs.add(cardDTO);
        }

        return cardDTOs;
    }

    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    public Card addCards(List<Card> cards) {
        Card cardReturn = new Card();
        for (Card card : cards) {
            cardReturn = cardRepository.save(card);
        }
        return cardReturn;
    }

    public void deleteCard(Card card) {
        cardRepository.delete(card);
    }

    public void deleteCards(List<Card> cards) {
        cardRepository.deleteAll(cards);
    }

}
