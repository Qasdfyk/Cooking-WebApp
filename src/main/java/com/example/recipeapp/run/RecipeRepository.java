package com.example.recipeapp.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepository {

    private List<Recipe> recipes = new ArrayList<>();

    List<Recipe> findAll() {
        return recipes;
    }
    Optional<Recipe> findById(Integer id) {
        return recipes.stream()
                .filter(recipe -> recipe.id() == id)
                        .findFirst();
    }

    void create(Recipe recipe) {
        recipes.add(recipe);
    }

    void update(Recipe recipe, Integer id) {
        Optional<Recipe> existingRecipe = findById(id);
        if(existingRecipe.isPresent())
        {
            recipes.set(recipes.indexOf(existingRecipe.get()), recipe);
        }
    }

    void delete(Integer id) {
        recipes.removeIf(recipe -> recipe.id().equals(id));
    }
    @PostConstruct
    private void init(){
        recipes.add(new Recipe(1, "Pasta", "Pasta with tomato sauce", 500));
        recipes.add(new Recipe(2, "Pizza", "Pizza with cheese",800));
    }
}