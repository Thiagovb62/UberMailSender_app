package org.yhiagovb62.desafiouber.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "categories")
@NoArgsConstructor

public class Category {

    @Id
    private String id;

    private String title;
    private String description;
    private String ownerId;


    public Category(CategoryDto categoryDto) {
        this.title = categoryDto.tittle();
        this.description = categoryDto.description();
        this.ownerId = categoryDto.ownerId();
    }
}
