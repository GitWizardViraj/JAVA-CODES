
import java.util.Scanner;
public class QuizGame {
 private static Scanner scanner = new Scanner(System.in);
 private static int score = 0;
 private static int flag;
 private static String[] questions = {
 "Who invent Java Programming?",
 "Which component used to compile, debug and execute Java programme?",
 "Which one of the following is not Java feature?",
 "What is extension of Java code file Java?",
 "Which exception is thrown when Java is out of memeory?"
 };
 private static String[] options = {
 "A. James Gosling\nB. Dennis Ritchie\nC. Bjarne stroustrup\nD. Guido Van Rossun",
 "A. JRE\nB. JDK\nC. JIT\nD. JVM",
 "A. Object oriented\nB. Use of pointers\nC. Portable\nD. Robust and Secure",
 "A. .JAVA\nB. .JS\nC. .CLASS\nD. .TXT",
 "A. MemoryError\nB. MemoryOutOfBoundExcepetion\nC. OutOfMemeoryError\nD. 
MemoryFullException"
 };
 private static String[] answers = {"A", "B", "B", "A", "C"};
 public static void main(String[] args) {
 
 
 displayWelcomeMessage();
 
 while (true) {
 displayMenu();
 int choice = getUserChoice();
 switch (choice) {
 case 1:
 playQuiz();
 break;
 case 2:
 getHelp();
 break;
 case 3:
 displayScore();
 break;
 case 4:
 resetScore();
 break;
 case 5:
 displayExitMessage();
 return;
 default:
 System.out.println("Invalid choice! Please try again.");
 break;
 }
 }
 }
 private static void displayWelcomeMessage() {
 System.out.println("Welcome to the Quiz Game!");
 System.out.println("*********");
 }
 private static void displayMenu() {
 System.out.println("\nPlease select an option:");
 System.out.println("1. Start Game");
 System.out.println("2. Help");
 System.out.println("3. Show Score");
 System.out.println("4. Reset Score");
 System.out.println("5. Quit");
 }
 private static int getUserChoice() {
 while (true) {
 try {
 System.out.print("Enter your choice: ");
 int choice = Integer.parseInt(scanner.nextLine());
 return choice;
 } catch (NumberFormatException e) {
 System.out.println("Invalid input! Please enter a valid integer.");
 }
 }
 }
 private static void playQuiz() {
 System.out.println("\n--- Let's play the quiz! ---");
 for (int i = 0; i < questions.length; i++) 
 {
 
 System.out.println("\nQuestion " + (i + 1) + ":");
 System.out.println(questions[i]);
 System.out.println(options[i]);
 String userAnswer = "";
 while (userAnswer.isEmpty()) {
 try {
 System.out.print("Enter your answer (A/B/C/D): ");
 userAnswer = scanner.nextLine().toUpperCase();
 if (!userAnswer.matches("[A-D]")) {
 throw new IllegalArgumentException();
 }
 } catch (IllegalArgumentException e) {
 System.out.println("Invalid input! Please enter a valid option (A/B/C/D).");
 userAnswer = "";
 }
 }
 if (userAnswer.equals(answers[i])) {
 System.out.println("Correct!");
 score++;
 } else {
 System.out.println("Incorrect!");
 }
 }
 if(score<=3)
 {
 System.out.println("/n/n !! YOUR SCORE IS LESS THAN PASSING CRITERIA !!");
 while (true) {
 
 System.out.print("\nDo you want to play again? (Y/N): ");
 String playAgain = scanner.nextLine().toUpperCase();
 if (playAgain.equals("Y")) {
 score = 0;
 playQuiz();
 break;
 } else if (playAgain.equals("N")) {
 displayExitMessage();
 System.exit(0);
 } else {
 System.out.println("Invalid input! Please enter Y or N.");
 }
 
 }
 }
 }
 private static void getHelp() {
 System.out.println("\n--- Help ---");
 System.out.println("This is a simple quiz game.");
 System.out.println("You will be asked a series of questions and given multiple-choice 
options.");
 System.out.println("Enter the letter corresponding to your chosen answer (A, B, C, or 
D).");
 System.out.println("Your score will be displayed at the end.");
 }
 private static void displayScore() {
 
 System.out.println("\n--- Your Score ---");
 System.out.println("Total questions: " + questions.length);
 System.out.println("Correct answers: " + score);
 System.out.println("Incorrect answers: " + (questions.length - score));
 if(score==5)
 {
 
 System.out.println("CONGRATULATIONS YOU ARE WINNER !!");
 displayExitMessage();
 
 }
 
 
 }
 private static void displayExitMessage() {
 System.out.println("\nThank you for playing the Quiz Game!");
 System.out.println("*********");
 }
 private static void resetScore() {
 score = 0;
 System.out.println("\nScore has been reset to 0.");
 }
➢ }