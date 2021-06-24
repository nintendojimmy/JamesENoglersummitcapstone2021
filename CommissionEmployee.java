public class CommissionEmployee extends Employee{
    final double commission = 20.0;
    private final double totalSalesAmount;

    public CommissionEmployee ( int employeeId, String firstName, String lastName , double totalSalesAmount){
        super(employeeId, firstName, lastName);
        this.totalSalesAmount = totalSalesAmount;
    }

    public double calculateEarnings(){
        return commission * totalSalesAmount;
    }

    public String toString(){
        return "commission employee: " + getFirstName() + " " + getLastName() + "\n" + "Employee ID: " + getEmployeeId() + "\n" +
                    "earned: " + calculateEarnings();
    }
}