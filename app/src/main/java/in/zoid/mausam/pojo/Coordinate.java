package in.zoid.mausam.pojo;

import org.parceler.Parcel;

/**
 * Created by divyendusingh on 8/26/15.
 */
@Parcel
public class Coordinate {
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