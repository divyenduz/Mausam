package in.zoid.mausam.pojo;

import org.parceler.Parcel;

/**
 * Created by divyendusingh on 8/26/15.
 */
@Parcel
public class WeatherReport {
    Long dt;
    Temperature temp;
    Float pressure;
    Float humidity;
    Float clouds;

    public WeatherReport() {
    }

    @Override
    public String toString() {
        return "WeatherReport{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", clouds=" + clouds +
                '}';
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getClouds() {
        return clouds;
    }

    public void setClouds(Float clouds) {
        this.clouds = clouds;
    }
}