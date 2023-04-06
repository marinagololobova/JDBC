package DAO;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee findById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(int id, Employee employee);
    void deleteEmployeeById(int id);
    City findCityById(int id);

}
