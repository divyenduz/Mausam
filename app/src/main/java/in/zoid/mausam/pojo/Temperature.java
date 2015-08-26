package in.zoid.mausam.pojo;

import org.parceler.Parcel;

/**
 * Created by divyendusingh on 8/26/15.
 */
@Parcel
public class Temperature {
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