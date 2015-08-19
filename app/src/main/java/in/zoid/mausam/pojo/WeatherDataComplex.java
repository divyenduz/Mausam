package in.zoid.mausam.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divyendusingh on 8/16/15.
 */
public class WeatherDataComplex {
    public static class Coordinate implements Parcelable {
        Float lat;
        Float lon;

        @Override
        public String toString() {
            return "Coordinate{" +
                    "lat=" + lat +
                    ", lon=" + lon +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(this.lat);
            dest.writeValue(this.lon);
        }

        public Coordinate() {
        }

        protected Coordinate(Parcel in) {
            this.lat = (Float) in.readValue(Float.class.getClassLoader());
            this.lon = (Float) in.readValue(Float.class.getClassLoader());
        }

        public static final Parcelable.Creator<Coordinate> CREATOR = new Parcelable.Creator<Coordinate>() {
            public Coordinate createFromParcel(Parcel source) {
                return new Coordinate(source);
            }

            public Coordinate[] newArray(int size) {
                return new Coordinate[size];
            }
        };
    }

    public static class City implements Parcelable {
        Long id;
        String name;
        Coordinate coord;
        String country;

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(this.id);
            dest.writeString(this.name);
            dest.writeParcelable(this.coord, flags);
            dest.writeString(this.country);
        }

        public City() {
        }

        protected City(Parcel in) {
            this.id = (Long) in.readValue(Long.class.getClassLoader());
            this.name = in.readString();
            this.coord = in.readParcelable(Coordinate.class.getClassLoader());
            this.country = in.readString();
        }

        public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
            public City createFromParcel(Parcel source) {
                return new City(source);
            }

            public City[] newArray(int size) {
                return new City[size];
            }
        };
    }

    public static class Temperature implements Parcelable {
        Float min;
        Float max;

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(this.min);
            dest.writeValue(this.max);
        }

        public Temperature() {
        }

        protected Temperature(Parcel in) {
            this.min = (Float) in.readValue(Float.class.getClassLoader());
            this.max = (Float) in.readValue(Float.class.getClassLoader());
        }

        public static final Parcelable.Creator<Temperature> CREATOR = new Parcelable.Creator<Temperature>() {
            public Temperature createFromParcel(Parcel source) {
                return new Temperature(source);
            }

            public Temperature[] newArray(int size) {
                return new Temperature[size];
            }
        };
    }

    public static class WeatherReport implements Parcelable {
        Long dt;
        Temperature temp;
        Float pressure;
        Float humidity;
        Float clouds;

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(this.dt);
            dest.writeParcelable(this.temp, 0);
            dest.writeValue(this.pressure);
            dest.writeValue(this.humidity);
            dest.writeValue(this.clouds);
        }

        public WeatherReport() {
        }

        protected WeatherReport(Parcel in) {
            this.dt = (Long) in.readValue(Long.class.getClassLoader());
            this.temp = in.readParcelable(Temperature.class.getClassLoader());
            this.pressure = (Float) in.readValue(Float.class.getClassLoader());
            this.humidity = (Float) in.readValue(Float.class.getClassLoader());
            this.clouds = (Float) in.readValue(Float.class.getClassLoader());
        }

        public static final Parcelable.Creator<WeatherReport> CREATOR = new Parcelable.Creator<WeatherReport>() {
            public WeatherReport createFromParcel(Parcel source) {
                return new WeatherReport(source);
            }

            public WeatherReport[] newArray(int size) {
                return new WeatherReport[size];
            }
        };
    }

    public static class WeatherData implements Parcelable {
        City city;
        ArrayList<WeatherReport> list;

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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.city, flags);
            dest.writeList(this.list);
        }

        public WeatherData() {
        }

        protected WeatherData(Parcel in) {
            this.city = in.readParcelable(City.class.getClassLoader());
            this.list = new ArrayList<>();
            in.readList(this.list, List.class.getClassLoader());
        }

        public static final Parcelable.Creator<WeatherData> CREATOR = new Parcelable.Creator<WeatherData>() {
            public WeatherData createFromParcel(Parcel source) {
                return new WeatherData(source);
            }

            public WeatherData[] newArray(int size) {
                return new WeatherData[size];
            }
        };
    }
}
