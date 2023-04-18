package DAO;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        City city = new City("Novosibirsk");
        CityDAO cityDAO = new CityDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee("Andreev", "Andrey", "man", 32, city);
        Employee employee2 = new Employee("Andreeva", "Anna", "woman", 31, city);
        Employee employee3 = new Employee("Sidorov", "Egor", "man", 25, city);
        city.setEmployeeList(List.of(employee1, employee2, employee3));
        cityDAO.addCity(city);
        System.out.println(cityDAO.getAllCity());
        System.out.println(employeeDAO.getAllEmployees());

        Employee employee4 = new Employee("Arbuzov", "Anton", "man", 25, cityDAO.findById(6));
        employeeDAO.updateEmployee(8, employee4);
        cityDAO.updateCity(6, city);
        System.out.println(cityDAO.getAllCity());
        System.out.println(employeeDAO.getAllEmployees());

        cityDAO.deleteCity(cityDAO.findById(4));
        System.out.println(cityDAO.getAllCity());
        System.out.println(employeeDAO.getAllEmployees());

    }
}
