package DAO;

import java.sql.*;
public class Application {
    public static void main(String[] args) {
        // Задание 1

        final String user = "postgres";
        final String password = "1234";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement("" + "SELECT * FROM employee " +
                    "INNER JOIN city ON employee.city_id = city.city_id WHERE id = (?) ")) {

            statement.setInt(1,5);
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
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }

        // Задание 2
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        City c = employeeDAO.findCityById(1);
        employeeDAO.addEmployee(new Employee(3,"Romanov", "Kirill", "man", 50, c));
        System.out.println(employeeDAO.getAllEmployees());

        employeeDAO.findById(4);

        System.out.println(employeeDAO.getAllEmployees());

        City c1 = employeeDAO.findCityById(5);

        employeeDAO.updateEmployee(5, new Employee(5,"Ivanov", "Daniil", "man", 27, c1));
        System.out.println(employeeDAO.getAllEmployees());

        employeeDAO.deleteEmployeeById(1);

    }
}
