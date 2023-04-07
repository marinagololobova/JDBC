package DAO;

public class City {
    private int city_Id;
    private String city_name;

    public City() {
    }

    public City(int city_Id, String city_name) {
        this.city_Id = city_Id;
        this.city_name = city_name;
    }

    public int getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(int city_Id) {
        this.city_Id = city_Id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + city_Id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
