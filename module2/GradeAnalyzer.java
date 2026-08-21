package module2;
import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
 
    static int invalidLinesCount = 0;
    static int countA = 0;
    static int countB = 0;
    static int countC = 0;
    static int countD = 0;
    static int countF = 0;
    public static void main(String[] args) {
        // Step 1: read scores from file
        System.out.println("\n\nReading scores from scores.txt...");
        ArrayList<Integer> scores = readScores("scores.txt");
        System.out.println("\n\nFinished reading scores from scores.txt.");

        if (scores.isEmpty()) {
            System.out.println("No valid scores to process.");
            return;
        }
        
        // Step 2: calculate statistics
        double avg = calculateAverage(scores);
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int score : scores) {
            if(score < low){
                low = score;
            }
            if(score > high){
                high = score;
            }
            if(score >= 90){
                countA++;
            } else if(score >= 80){
                countB++;
            } else if(score >= 70){
                countC++;
            } else if(score >= 60){
                countD++;
            } else {
                countF++;
            }
        }
        // Step 3: write and print report
        writeReport(scores, avg, high, low, "report.txt");
        System.out.println("Report written to report.txt");

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            ArrayList<Integer> scores = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line.trim());
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    } else {
                        System.err.println("**Invalid score entry (out of range): " + score);
                        invalidLinesCount++;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("** Invalid score entry (not a number): " + line);
                    invalidLinesCount++;
                }
            }
            return scores;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.isEmpty()) {
            return 0.0;
        }
        int size = scores.size();
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double average = (double) sum / size;
        System.out.println("Average score: " + average +"\n\n");
        return average;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            writer.write("=== Grade Analysis Report === \n");
            writer.write(String.format("Total scores processed: %d ", scores.size()) + "\n");
            writer.write(String.format("Invalid lines skipped: %d", invalidLinesCount) + "\n\n");
            writer.write(String.format("Average score: %.2f ", avg) + "\n");
            writer.write(String.format("Highest score: %d", high) + "\n");
            writer.write(String.format("Lowest score: %d", low) + "\n\n");

            writer.write("=== Grade Distribution === \n");
            writer.write(String.format("A (90-100): %d", countA) + "\n");
            writer.write(String.format("B (80-89): %d", countB) + "\n");
            writer.write(String.format("C (70-79): %d", countC) + "\n");
            writer.write(String.format("D (60-69): %d", countD) + "\n");
            writer.write(String.format("F (below 60): %d", countF) + "\n");

            System.out.println("=== Grade Analysis Report === \n");
            System.out.println(String.format("Total scores processed: %d ", scores.size()));
            System.out.println(String.format("Invalid lines skipped: %d", invalidLinesCount) + "\n\n");
            System.out.println(String.format("Average score: %.2f ", avg));
            System.out.println(String.format("Highest score: %d", high) );
            System.out.println(String.format("Lowest score: %d", low) + "\n\n");
            
            System.out.println("=== Grade Distribution === ");
            System.out.println(String.format("A (90-100): %d", countA));
            System.out.println(String.format("B (80-89): %d", countB) );
            System.out.println(String.format("C (70-79): %d", countC) );
            System.out.println(String.format("D (60-69): %d", countD) );
            System.out.println(String.format("F (below 60): %d", countF) );
            System.out.println("\n");


        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }

    }
} 