package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.Recipe;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RecipeManager {

    public static Recipe getRecipeByName(String recipeName) {
        Session ss = SessionManager.getSession();
        Recipe recipe = (Recipe) ss.createCriteria(Recipe.class).add(Restrictions.eq("name", recipeName)).uniqueResult();
        ss.close();
        return recipe;
    }

    public static void saveRecipe(Recipe recipe) {
        Session ss = SessionManager.getSession();
        ss.save(recipe);
        ss.getTransaction().commit();
        ss.close();
    }
}
