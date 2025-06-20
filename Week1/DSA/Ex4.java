class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return "[ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary + "]";
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(201, "Alice", "Manager", 60000));
        manager.addEmployee(new Employee(202, "Bob", "Developer", 50000));
        manager.addEmployee(new Employee(203, "Charlie", "Tester", 40000));

        System.out.println("All Employees:");
        manager.traverseEmployees();

        System.out.println("Search for ID 202:");
        Employee emp = manager.searchEmployee(202);
        System.out.println(emp != null ? emp : "Employee not found");

        System.out.println("Deleting ID 202...");
        manager.deleteEmployee(202);

        System.out.println("All Employees After Deletion:");
        manager.traverseEmployees();
    }
}

class EmployeeManager {
    private Employee[] employees;
    private int size = 0;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            System.out.println("Added: " + emp.name);
        } else {
            System.out.println("Employee list is full.");
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                System.out.println("Deleted employee ID: " + id);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
