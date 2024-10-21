package org.yhiagovb62.desafiouber.Service;

import org.springframework.stereotype.Service;
import org.yhiagovb62.desafiouber.Model.Category;
import org.yhiagovb62.desafiouber.Model.CategoryDto;
import org.yhiagovb62.desafiouber.Repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }
    public Category getById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category update(String id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setTitle(categoryDto.tittle());
            category.setDescription(categoryDto.description());
            category.setOwnerId(categoryDto.ownerId());
            categoryRepository.save(category);
        }
        return category;
    }
    public void create(CategoryDto categoryDto) {
        Category category = new Category( categoryDto);
        categoryRepository.save(category);
    }

    public void deleteById(String id) {
    categoryRepository.deleteById(id);
}
}
