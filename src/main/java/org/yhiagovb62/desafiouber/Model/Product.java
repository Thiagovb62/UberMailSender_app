package org.yhiagovb62.desafiouber.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String title;
    private Integer price;
    private String description;
    private Category category;
    private String ownerId;


    public Product(ProductDto productDto) {
        this.title = productDto.tittle();
        this.price = productDto.price();
        this.description = productDto.description();
        this.category = new Category(); // Assuming you will set the category later
        this.ownerId = productDto.ownerId();
    }
}
