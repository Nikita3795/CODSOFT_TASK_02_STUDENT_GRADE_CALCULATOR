 package com.nikita.gradecalculator;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of subjects
        System.out.print("📚 Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("✏️ Enter marks obtained in Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validate input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("⚠️ Invalid input! Marks should be between 0 and 100.");
                System.out.print("Re-enter marks for Subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }

            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Determine Grade
        String grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\n📊 Student Report:");
        System.out.println("🔹 Total Marks: " + totalMarks);
        System.out.println("🔹 Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("🔹 Grade: " + grade);

        scanner.close();
    }

    // Method to calculate grade based on percentage
    private static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+ (Excellent) 🎖️";
        } else if (percentage >= 80) {
            return "A (Very Good) 🏆";
        } else if (percentage >= 70) {
            return "B (Good) 🎯";
        } else if (percentage >= 60) {
            return "C (Average) 📘";
        } else if (percentage >= 50) {
            return "D (Pass) ✅";
        } else {
            return "F (Fail) ❌";
        }
    }
}
