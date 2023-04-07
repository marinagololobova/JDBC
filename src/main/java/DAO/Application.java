package DAO;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        employeeDAO.addEmployee(new Employee("Romanov", "Kirill", "man", 50, 2));

        employeeDAO.findById(4);

        employeeDAO.updateEmployee(6, new Employee("Ivanov", "Daniil", "man", 27, 4));

        employeeDAO.deleteEmployee(employeeDAO.findById(2));

        System.out.println(employeeDAO.getAllEmployees());
    }
}
