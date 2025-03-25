import java.util.Arrays;
import java.util.Scanner;

public class StudentMarksAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];

        // Input marks
        System.out.println("Enter marks for " + n + " students (out of 100):");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        // (a) Calculate class average
        double sum = Arrays.stream(marks).sum();
        double average = sum / n;

        // (b) Find highest and lowest marks
        int highest = Arrays.stream(marks).max().getAsInt();
        int lowest = Arrays.stream(marks).min().getAsInt();

        // (c) Count students above and below average
        long aboveAverage = Arrays.stream(marks).filter(mark -> mark > average).count();
        long belowAverage = Arrays.stream(marks).filter(mark -> mark < average).count();

        // (d) Sort marks in descending order
        Arrays.sort(marks);
        int[] descendingMarks = new int[n];
        for (int i = 0; i < n; i++) {
            descendingMarks[i] = marks[n - 1 - i]; // Reverse sorted order
        }

        // Output results
        System.out.printf("\nClass Average: %.2f\n", average);
        System.out.println("Highest Mark: " + highest);
        System.out.println("Lowest Mark: " + lowest);
        System.out.println("Students Above Average: " + aboveAverage);
        System.out.println("Students Below Average: " + belowAverage);
        System.out.println("Marks in Descending Order: " + Arrays.toString(descendingMarks));
    }
}




//output

Enter the number of students: 5
Enter marks for 5 students (out of 100):
85 76 92 60 45

Class Average: 71.60
Highest Mark: 92
Lowest Mark: 45
Students Above Average: 2
Students Below Average: 3
Marks in Descending Order: [92, 85, 76, 60, 45]
