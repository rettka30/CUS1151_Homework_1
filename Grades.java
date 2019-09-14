import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
   A class to keep track of students and their course grades.
*/
public class Grades
{

   /**
Prints the options menu and returns the letter that the user types does not check for invalid selection
      @return the next token on the input stream
   */
   public static String printMenuAndGetChoice()
   {
      System.out.println("A)dd student.");
      System.out.println("R)emove student.");
      System.out.println("M)odify grades.");
      System.out.println("P)rint all grades.");
      System.out.println("Q)uit.");
      System.out.println("Select one: ");
      Scanner in = new Scanner(System.in);
      return in.next();
   }

   /**
      Prints the students and grades
      @param gradeMap the map to print
   */
   public static void printGrades(Map<String, String> gradeMap)
   {
      if(gradeMap.isEmpty()) {
         System.out.println("There are no students.");
      } else {
         Set<String> studentSet = gradeMap.keySet();
         Object[] students = studentSet.toArray();
   	  
         // TO do, write code to print students and their grades
         System.out.println("List of Students:");
         for(int i = 0; i < students.length; i++) {
            String grade = gradeMap.get(students[i]);
            System.out.println(students[i] + ": " + grade);
         }
      }
   }

   /**
Modifies an entry based on user input.  Prints an error if an invalid student is modified
      @param gradeMap the map to modify
   */
   public static void modifiyStudent(Map<String, String> gradeMap)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of the student to modify: ");
      String name = in.next();
      if (gradeMap.containsKey(name))
      {
         System.out.println("Enter the new grade: ");
         String grade = in.next();
		 
         // To Do; write code to modify stdeutns 
         gradeMap.replace(name, grade);
      }
      else
      {
         System.out.println("No such student exists!");
      }
   }

   /**
      Removes a student from the map based on user input
      @param gradeMap the map to remove the student from
   */
   public static void removeStudent(Map<String, String> gradeMap)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of the student to remove: ");
      String name = in.next();
      
	  //TO do; write code to remove student 
     gradeMap.remove(name);
   }

   /**
      Adds a student based on user input.  Prints an error if a student
      is added that already exists in the map.
      @param gradeMap the map to add the student to
   */
   public static void addStudent(Map<String, String> gradeMap)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the name of the student to add: ");
      String name = in.next();
      if (!gradeMap.containsKey(name))
      {
         System.out.println("Enter the new grade: ");
         String grade = in.next();
		 
         // To Do; write code to add stduent and its grade to map
         gradeMap.put(name, grade);
      }
      else
      {
         System.out.println("That student is already in the roster.");
      }
   }

   public static void main(String[] args)
   {
      Map<String, String> gradeMap = new TreeMap<String, String>();

      String choice = printMenuAndGetChoice();
      while (!choice.equals("Q"))
      {
         if (choice.equals("A"))
         {
            addStudent(gradeMap);
         }
         if (choice.equals("R"))
         {
            removeStudent(gradeMap);
         }
         if (choice.equals("M"))
         {
            modifiyStudent(gradeMap);
         }
         if (choice.equals("P"))
         {
            printGrades(gradeMap);
         }
         choice = printMenuAndGetChoice();
      }
   }
}