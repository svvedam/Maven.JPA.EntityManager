package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {

    @Id
    @GeneratedValue
    private int artistid;

    @Column(length=100)
    private String first_name;

    @Column(length=100)
    private String last_name;

    @Column(length=100)
    private String instrument;

    public Artist(){}

    public Artist(String first_name, String last_name, String instrument) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.instrument = instrument;
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistid=" + artistid +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", instrument='" + instrument + '\'' +
                '}';
    }
}
