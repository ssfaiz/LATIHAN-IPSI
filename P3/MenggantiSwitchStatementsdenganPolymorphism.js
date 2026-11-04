// BAD CODE
class Employee {
    int payAmount() {
        switch (getType()) {
            case EmployeeType.ENGINEER:
                return _monthlySalary;

            case EmployeeType.SALESMAN:
                return _monthlySalary + _commission;

            case EmployeeType.MANAGER:
                return _monthlySalary + _bonus;

            default:
                throw new Exception("Incorrect Employee");
        }
    }
}


// GOOD CODE
abstract class EmployeeType {
    abstract int payAmount(Employee emp);
}

class Engineer extends EmployeeType {
    int payAmount(Employee emp) {
        return emp.getMonthlySalary();
    }
}

class Salesman extends EmployeeType {
    int payAmount(Employee emp) {
        return emp.getMonthlySalary() + emp.getCommission();
    }
}

class Manager extends EmployeeType {
    int payAmount(Employee emp) {
        return emp.getMonthlySalary() + emp.getBonus();
    }
}