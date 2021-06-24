import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Random;

public class EmployeeFactory {
    private final int numberEmployees; //number of employees to generate
    private final String pathname;
    private final String dataSig;

    public EmployeeFactory(int numberEmployees, String pathname, String dataSig){
        this.numberEmployees = numberEmployees;
        this.pathname = pathname;
        this.dataSig = dataSig;


    }

    public void writeTestData() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(pathname));

        pw.write(dataSig+ "\n");//appends comma separated values of column headers

        for(int i = 0; i < numberEmployees; i++){
            pw.write(createHourlyEmployee() + "\n");
            pw.write(createBasePlusCommissionEmployee() + "\n");
            pw.write(creatCommissionEmployee() + "\n");
        }
        pw.close();
    }

    static String createEmployeeIDAndName(){
        String EmployeeID = generateEmployeeID();
        String FirstName = generateFirstName();
        String LastName = generateLastName();
        return EmployeeID + "," + FirstName + "," + LastName;
    }

    static String createHourlyEmployee(){
        String employeeIDAndName = createEmployeeIDAndName();
        String numOfHoursWorked = generatenumOfHoursWorked();
        String HourlyRate = generateHourlyRate();
        String BaseSalary = "null";
        String TotalSalesAmount = "null";

        employeeIDAndName = "1" + employeeIDAndName;

        return employeeIDAndName + "," + numOfHoursWorked + "," + HourlyRate + ","
                + BaseSalary + "," + TotalSalesAmount;
    }

    static String createBasePlusCommissionEmployee(){
        String employeeIDAndName = createEmployeeIDAndName();
        String numOfHoursWorked = "null";
        String HourlyRate = "null";
        String BaseSalary = generateBaseSalary();
        String TotalSalesAmount = generateTotalSalesAmount();

        employeeIDAndName = "3" + employeeIDAndName;

        return employeeIDAndName + "," + numOfHoursWorked + "," + HourlyRate + ","
                + BaseSalary + "," + TotalSalesAmount;
    }

    static String creatCommissionEmployee(){
        String employeeIDAndName = createEmployeeIDAndName();
        String numOfHoursWorked = "null";
        String HourlyRate = "null";
        String BaseSalary = "null";
        String TotalSalesAmount = generateTotalSalesAmount();

        employeeIDAndName = "2" + employeeIDAndName;

        return employeeIDAndName + "," + numOfHoursWorked + "," + HourlyRate + ","
                + BaseSalary + "," + TotalSalesAmount;
    }

    static String generateEmployeeID(){
        String EmployeeID = "";
        Random rand = new Random();
        for (int i = 0; i < 7;i++){EmployeeID += String.valueOf(rand.nextInt(9));
        }
        return EmployeeID;
    }

    static String generateFirstName(){
        Random rand = new Random();
        String[] firstnameArray = {"James","Richard","Nancy","Leon","Azra","Khalid"};
        String FirstName = firstnameArray[rand.nextInt(firstnameArray.length)];
        return FirstName;
    }

    static String generateLastName(){
        Random rand = new Random();
        String[] lastnameArray = {"Nogler","Woodworth","Jennings","Johnson","Robinson"};
        String LastName = lastnameArray[rand.nextInt(lastnameArray.length)];
        return LastName;
    }

    static String generatenumOfHoursWorked(){
        Random rand = new Random();
        return String.valueOf(rand.nextInt(9)) + String.valueOf(rand.nextInt(9)) + "." +
                String.valueOf(rand.nextInt(9));
    }

    static String generateHourlyRate(){
        Random rand = new Random();
        return String.valueOf(rand.nextInt(100));
    }

    static String generateBaseSalary(){
        Random rand = new Random();
        return String.valueOf(rand.nextInt(1000));
    }

    static String generateTotalSalesAmount(){
        Random rand = new Random();
        return String.valueOf(rand.nextInt(10000));
    }
}