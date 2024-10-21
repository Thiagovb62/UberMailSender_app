package org.yhiagovb62.desafiouber.Model;

public record ProductDto(

        String tittle,
        String description,
        String ownerId,
        Integer price,
        String categoryId

) {
}
