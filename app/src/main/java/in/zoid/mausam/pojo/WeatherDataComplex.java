package in.zoid.mausam.pojo;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by divyendusingh on 8/16/15.
 */
@Parcel
public class WeatherDataComplex {
    City city;
    ArrayList<WeatherReport> list;

    public WeatherDataComplex() {
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city=" + city +
                ", list=" + list +
                '}';
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ArrayList<WeatherReport> getList() {
        return list;
    }

    public void setList(ArrayList<WeatherReport> list) {
        this.list = list;
    }
}
