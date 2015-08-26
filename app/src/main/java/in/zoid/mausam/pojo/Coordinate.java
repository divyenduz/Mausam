package in.zoid.mausam.pojo;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by divyendusingh on 8/26/15.
 */
@Parcel
public class Coordinate implements Serializable{
    Float lat;
    Float lon;

    public Coordinate() {
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}