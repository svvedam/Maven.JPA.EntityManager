package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CD {
    @Id
    @GeneratedValue
    private int cdid;

    @Column(length = 100)
    private String title;


    @Column(length = 3000)
    private String description;

    @Column(length = 4)
    private int year;


    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Artist> artists;


    @Column(length = 10, precision = 2)
    private float price;

    public CD() {
    }

    public CD(String title, String description, int year, Set<Artist> artists, float price) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.artists = artists;
        this.price = price;
    }


    public int getCdId() {
        return cdid;
    }

    public void setCdId(int id) {
        this.cdid = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CD{" +
                "cdid=" + cdid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", artists=" + artists +
                ", price=" + price +
                '}';
    }
}
