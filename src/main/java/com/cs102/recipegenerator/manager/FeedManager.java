package com.cs102.recipegenerator.manager;
import com.cs102.recipegenerator.domain.RecipeFeed;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class FeedManager {

    public static void saveFeed(RecipeFeed feed) {
        Session ss = SessionManager.getSession();
        ss.save(feed);
        ss.getTransaction().commit();
        ss.close();
    }

    public static List<RecipeFeed> getLastRecipes() {
        Session ss = SessionManager.getSession();
        List<RecipeFeed> orderedFeed = ss.createCriteria(RecipeFeed.class).addOrder(Order.asc("cookDate")).setFetchSize(10).list();
        ss.close();
        return orderedFeed;
    }
}
