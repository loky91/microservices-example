package io.javabrains.moviecatalogservice.resource.models;

import java.util.List;

public class UsersRating {
private List<Ratings> userRating;
public UsersRating(){

}
    public List<Ratings> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Ratings> userRating) {
        this.userRating = userRating;
    }
}
