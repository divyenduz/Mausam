package in.zoid.mausam.pojo;

import org.parceler.Parcel;

/**
 * Created by divyendusingh on 8/26/15.
 */
@Parcel
public class City {
    Long id;
    String name;
    Coordinate coord;
    String country;

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}