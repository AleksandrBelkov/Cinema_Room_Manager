package cinema;
import java.util.Scanner;
import java.lang.Math;

public class Cinema {

    public static void main(String[] args) {

        int seatNumber, rowNumber;
        int selectedRowNumber = 0, selectedSeatNumber = 0;
        int counter = 0;
        int seatsCount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rowNumber = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatNumber = scanner.nextInt();

        int action = 100;
        int seatsAmount = rowNumber * seatNumber;
        int income = 0;
        int totalIncome = 0;
        int firstHalf = rowNumber / 2;
        System.out.println (firstHalf);
        totalIncome = 10 * seatNumber * firstHalf + 8 * seatNumber * (rowNumber - firstHalf);
        char[][] bookedSeats = new char[rowNumber][seatNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < seatNumber; j++) {
                bookedSeats[i][j] = 'S';
            }
        }
        while (action != 0) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            action = scanner.nextInt();

            if (action == 1) {
                System.out.println();
                System.out.println("Cinema:");
                System.out.print(" ");
                for (int i = 1; i <= seatNumber; i++) {
                    System.out.print(" " + i);
                }
                System.out.println();
                for (int i = 1; i <= rowNumber; i++) {
                    System.out.print(i);
                    for (int j = 1; j <= seatNumber; j++) {
                        /*if (i == selectedRowNumber && j == selectedSeatNumber) {
                            System.out.print(" " + "B");
                        } else {
                            System.out.print(" " + "S");
                        }*/
                        System.out.print(" " + bookedSeats[i - 1][j - 1]);
                    }
                    System.out.println();
                }
            } else if (action == 2) {
                int action2 = 100;
                while (action2 == 100) {
                    System.out.println("Enter a row number:");
                    selectedRowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    selectedSeatNumber = scanner.nextInt();
                
                    if (selectedRowNumber < 0 || selectedRowNumber > rowNumber || selectedSeatNumber < 0 || selectedSeatNumber > seatNumber) {
                        System.out.println("Wrong input!");    
                    } else {
                        if ('B'==bookedSeats[selectedRowNumber - 1][selectedSeatNumber - 1]) {
                            System.out.println("That ticket has already been purchased");
                        } else {
                            bookedSeats[selectedRowNumber - 1][selectedSeatNumber - 1] = 'B';
                            seatsCount++;
                            System.out.print("Ticket price: $");

                            if (selectedRowNumber <= rowNumber /2) {
                                System.out.println(10);
                                income += 10;
                            } else {
                                System.out.println(8);
                                income += 8;
                            }
                            action2 = 90;
                        }    
                    }
                }
                //System.out.print(selectedRowNumber + " " + selectedSeatNumber);
                
            } else if (action == 3) {
                System.out.println("Number of purchased tickets: " + seatsCount);
                float percentage = 100 * (float) seatsCount / (seatNumber * rowNumber);
                System.out.format("Percentage: %.2f", percentage);
                System.out.println("%");
                System.out.println("Current income: $" + income);
                System.out.println("Total income: $" + totalIncome);
            } else {
                action = 0;
            }

        }

        scanner.close();
        // Write your code here
    }
}
