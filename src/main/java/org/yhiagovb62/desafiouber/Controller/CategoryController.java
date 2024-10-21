package org.yhiagovb62.desafiouber.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yhiagovb62.desafiouber.Model.Category;
import org.yhiagovb62.desafiouber.Model.CategoryDto;
import org.yhiagovb62.desafiouber.Service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = categoryService.listAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable String id) {
        Category category = categoryService.getById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody CategoryDto categoryDto) {
        Category updatedCategory = categoryService.update(id, categoryDto);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody CategoryDto categoryDto) {
        categoryService.create(categoryDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable String id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
