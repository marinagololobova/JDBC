package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    private final String user = "postgres";
    private final String password = "1234";
    private final String url = "jdbc:postgresql://localhost:5432/skypro";


    @Override
    public void addEmployee(Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             final PreparedStatement statement = connection.prepareStatement("INSERT INTO employee " +
                     "(id, first_name, last_name, gender, age, city_id) " +
                     "VALUES ((?), (?), (?), (?), (?), (?))");) {
            statement.setInt (1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getGender());
            statement.setInt (5, employee.getAge());
            statement.setInt (6, employee.getCity().getCity_Id());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = new Employee();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM employee " +
                     "INNER JOIN city ON employee.city_id = city.city_id WHERE id = (?) ")) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idOfEmployee = resultSet.getInt("id");
                System.out.println("ID сотрудника: " + idOfEmployee);

                String firstNameOfEmployee = resultSet.getString("first_name");
                String lastNameOfEmployee = resultSet.getString("last_name");
                String genderOfEmployee = resultSet.getString("gender");
                int ageOfEmployee = resultSet.getInt("age");
                String cityOfEmployee = resultSet.getString("city_name");

                System.out.println("Фамилия: " + firstNameOfEmployee + ", имя: " + lastNameOfEmployee +
                        ", пол: " + genderOfEmployee + ", возраст: " + ageOfEmployee + ", город: " + cityOfEmployee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee " +
                     "INNER JOIN city ON employee.city_id = city.city_id")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString( "last_name");
                String gender = resultSet. getString( "gender");
                int age = Integer.parseInt (resultSet.getString ("age"));
                City city = new City (resultSet.getInt( "city_id"),
                    resultSet.getString("city_name"));
                employees.add (new Employee(id, firstName, lastName, gender, age, city));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE employee " +
                     "SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?)")) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getCity_Id());
            statement.setInt(6, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public City findCityById(int id) {
        City city = new City();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM city " +
                     " WHERE city_id = (?)")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cityOfEmployee = resultSet.getString("city_name");
            }

        } catch (SQLException e) {
        e.printStackTrace();
    }
        return city;
    }
}
