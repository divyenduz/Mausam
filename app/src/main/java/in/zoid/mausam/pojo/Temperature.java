package in.zoid.mausam.pojo;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by divyendusingh on 8/26/15.
 */
@Parcel
public class Temperature implements Serializable{
    Float min;
    Float max;

    public Temperature() {
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }
}