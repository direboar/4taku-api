package yontaku.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MinionType {

    @Id
    private int id;
    private String name;
    private String imageURL;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
