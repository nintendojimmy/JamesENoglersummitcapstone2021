import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Main {

    public static void main(String args[]){
        String dataSig = "EmployeeId,firstName,lastName,numOfHoursWorked,hourlyRate,baseSalary,totalSalesAmount";
        String sourcePathName = "src/EmployeeData";
        String destinationPathName = "src/EmployeeReport";

        Scanner scanner = new Scanner(System.in);

        clearScreen();

        if(args.length == 1){createTestFile(args[0],dataSig);};

        createReport(sourcePathName, destinationPathName, dataSig);

    }

    static void createTestFile(String pathname, String dataSig){
        EmployeeFactory employeeFactory = new EmployeeFactory(100,pathname,dataSig);

        try {
            employeeFactory.writeTestData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getPathName(){
        return "null";
    }

    static void createReport( String sourcePathName,String destinationPathName , String dataSig){

        try {

            File myObj = new File(sourcePathName);
            Scanner myReader = new Scanner(myObj);

            //used to increment scanner past header line and test equivalence of dataSig
            if (!dataSig.equals(myReader.nextLine()))  System.exit(9);

            PrintWriter pw = new PrintWriter(new FileWriter(destinationPathName));

            //Read each line of the file
            while (myReader.hasNextLine()) {
                String nextLine = myReader.nextLine();//Reads next line from file
                String[] data = nextLine.split(",");//Parse line and stores to data array

                //test to see if the employee is an hourly employee
                if (data[0].substring(0,1).equals("1")){ //addHourlyEmployee(nextLine)
                    HourlyEmployee hourlyEmployee = new HourlyEmployee(
                            Integer.valueOf(data[0]),
                            data[1], //firstNames
                            data[2], //lastName
                            Double.parseDouble(data[3]), //
                            Double.parseDouble(data[4]));//

                    pw.write(hourlyEmployee + "\n" + "\n");


                }

                //test to see if the employee is a commission employee
                if (data[0].substring(0,1).equals("2")){ //addCommissionEmployee(nextLine)
                    CommissionEmployee commissionEmployee = new CommissionEmployee(
                            Integer.valueOf(data[0]),
                            data[1],
                            data[2],
                            Double.parseDouble(data[6]));

                    pw.write(commissionEmployee + "\n" + "\n");


                }

                //test to see if the employee is a base plus commission employee
                if (data[0].substring(0,1).equals("3")){ //addBasePlusCommissionEmployee(nextLine)
                    BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(
                            Integer.valueOf(data[0]),
                            data[1],
                            data[2],
                            Double.parseDouble(data[5]),
                            Double.parseDouble(data[6]));

                    pw.write(basePlusCommissionEmployee + "\n" + "\n");
                }

            }

            myReader.close();
            pw.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    static void clearScreen(){
        System. out. print("\033[H\033[2J");
        System. out. flush();
    }

}