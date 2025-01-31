package com.rben23.pokeCards.repositories;

import com.rben23.pokeCards.dtos.CardDTO;
import com.rben23.pokeCards.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByName(String name);
}
