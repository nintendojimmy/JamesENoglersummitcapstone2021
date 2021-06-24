public class HourlyEmployee extends Employee{
    private final double numOfHoursWorked;
    private final double hourlyRate;

    public HourlyEmployee(int employeeId, String firstName, String lastName, double HourlyRate, double numOfHoursWorked){
        super(employeeId, firstName, lastName);
        this.hourlyRate = HourlyRate;
        this.numOfHoursWorked = numOfHoursWorked;
    }

    public double calculateEarnings() {
        return calculateEarnings(numOfHoursWorked);
    }

    public double calculateEarnings(double numOfHoursWorked){
        double earnings;

        if ( numOfHoursWorked < 40 ) {
            earnings = numOfHoursWorked * hourlyRate;
        }
        else {
            earnings = 40 * hourlyRate + (( numOfHoursWorked - 40 ) * hourlyRate * 1.5);
        }

        return earnings;
    }

    public String toString(){
        return "hourly employee: " + getFirstName() + " " + getLastName() + "\n" + "Employee ID: " + getEmployeeId()
                + "\n" + "earned: " + calculateEarnings();
    }

    public double getNumOfHoursWorked() {
        return numOfHoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

}
