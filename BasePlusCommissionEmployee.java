public class BasePlusCommissionEmployee extends CommissionEmployee{


    final double commission = 10.0;
    double baseSalary;

    public BasePlusCommissionEmployee( int employeeId, String firstName, String lastName, double totalSalesAmount,
                                       double baseSalary){
        super(employeeId, firstName, lastName, totalSalesAmount);
        this.baseSalary = baseSalary;
    }

    public double calculateEarnings(){
        double earnings;
        earnings = super.calculateEarnings() + baseSalary;
        return earnings;
    }

    @Override
    public String toString() {
        return "base-salaried commsision employee: " + getFirstName() + " " + getLastName() + "\n"
                + "Employee ID: " + getEmployeeId() + "\n"
                + "old base salary: " + getBaseSalary() + "\n"
                + "new base salary: " + ( getBaseSalary() + (getBaseSalary() * (getCommission()/100)));
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getCommission() { return commission; }

}
