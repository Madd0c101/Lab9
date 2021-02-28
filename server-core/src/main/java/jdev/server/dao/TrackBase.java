package jdev.server.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by jdev on 28.05.2017.
 */
@Entity
@Table(name="tracks")
public class TrackBase {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "LATTITUDE")
   Float Lattitude;

    @Column(name = "LONGTITUDE")
   Float Longtitude;

    @Column(name = "COUNTRY")
    String Country;

    @Column(name = "CITY")
    String City;


    public String toString() {
        return "Base{ id=" + id + ", Lattitude=" + Lattitude.toString()+ ", Longtitude=" +  Longtitude.toString()+ ", Country="+ Country +", City="+City+" }";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLattitude(Float lat) {
        this.Lattitude = lat;
    }

    public Float getLattitude() {
        return Lattitude;
    }

    public void setLongtitude(Float lon) {
        this.Longtitude = lon;
    }

    public Float getLongtitude() {
        return Longtitude;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getCountry() {
        return Country;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getCity() {
        return City;
    }
}
