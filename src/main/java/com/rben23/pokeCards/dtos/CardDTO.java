package com.rben23.pokeCards.dtos;

import com.rben23.pokeCards.models.Rarity;
import lombok.Data;

@Data
public class CardDTO {

    private String name;
    private String type;
    private Rarity rarity;
    private String imageUrl;
}
