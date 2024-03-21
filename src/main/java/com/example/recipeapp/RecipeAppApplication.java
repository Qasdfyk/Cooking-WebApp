package com.example.recipeapp;

import com.example.recipeapp.recipe.Ingredient;
import com.example.recipeapp.recipe.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class RecipeAppApplication {

    private static final Logger log = LoggerFactory.getLogger(RecipeAppApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(RecipeAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Recipe recipe = new Recipe("Spaghetti", "A simple pasta recipe", List.of("Italian", "Pasta"), "Cook the pasta", List.of(new Ingredient("Pasta", "200g"), new Ingredient("Tomato Sauce", "500g")));
            log.info(recipe.toString());
        };
    }
}