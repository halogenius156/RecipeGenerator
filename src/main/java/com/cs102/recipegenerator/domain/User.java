package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @OneToMany
    private List<Recipe> LastRecipes = new ArrayList<Recipe>();
    @OneToMany
    private List<Recipe> MyFavourites = new ArrayList<Recipe>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Fridge fridge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public List<Recipe> getLastRecipes() {
        return LastRecipes;
    }

    public void setLastRecipes(List<Recipe> LastRecipes) {
        this.LastRecipes = LastRecipes;
    }

    public void addLastRecipe(Recipe LastRecipe) {
        LastRecipes.add(LastRecipe);
    }
    public void setMyFavourites(List<Recipe> MyFavourites) {
        this.MyFavourites = MyFavourites;
    }
    public void addFavouriteRecipe(Recipe FavRecipe){
        MyFavourites.add(FavRecipe);
    }
}
