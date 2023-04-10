package DAO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(of = {"city_Id"})
@Getter
@Setter

@Entity

public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int city_Id;
    private String city_name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public City() {
    }

    public City(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_Id=" + city_Id +
                ", city_name=" + city_name +
                '}';
    }
}
