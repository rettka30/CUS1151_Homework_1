import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
   A class to keep track of students and their course grades.
*/
public class Grades2
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
   public static void printGrades(Map<Student, String> gradeMap)
   {
      Set<Student> studentSet = gradeMap.keySet();
      System.out.println("List of Students:");
      for (Student student : studentSet)
      {
         System.out.printf("%s: %s\n", student, gradeMap.get(student));
      }
   }

   /**
Modifies an entry based on user input.  Prints an error if an invalid student is modified
      @param gradeMap the map to modify
      @param idToStudentMap  the map to associate student id with a student
   */
   public static void modifiyStudent(Map<Student, String> gradeMap,
      Map<Integer, Student> idToStudentMap)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the ID of the student to modify: ");
      int id = in.nextInt();
      if (idToStudentMap.containsKey(id))
      {
         System.out.println("Enter the new grade: ");
         String grade = in.next();
         gradeMap.put(idToStudentMap.get(id), grade);
      }
      else
      {
         System.out.println("No such student exists!");
      }
   }

   /**
      Removes a student from the map based on user input
      @param gradeMap the map to remove the student from
      @param idToStudentMap the map to associate student id with a student
   */
   public static void removeStudent(Map<Student, String> gradeMap,
      Map<Integer, Student> idToStudentMap)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the id of the student to remove: ");
      int id = in.nextInt();
      //TO Do; write code to remove student; make sure to remove stdeunt from both map, id map and grade map
      Student student = idToStudentMap.get(id);
      idToStudentMap.remove(id);
      gradeMap.remove(student);
   }

   /**
      Adds a student based on user input.  Prints an error if a student
      is added that already exists in the map.
      @param idToGradeMap the map to add the student to
      @param idToStudentMap the map to associate student id with a student
   */
   public static void addStudent(Map<Student, String> idToGradeMap,
      Map<Integer, Student> idToStudentMap)
   {
      Scanner in = new Scanner(System.in);
      Student student = Student.createStudent();
      if (!idToStudentMap.containsKey(student.getId()))
      {
         System.out.println("Enter the new grade: ");
         // TO Do; write code to add student
         String grade = in.next();
         idToStudentMap.put(student.getId(), student);
         idToGradeMap.put(student, grade);
      }
      else
      {
         System.out.println("That student is already in the roster.");
      }
   }

   public static void main(String[] args)
   {
      Map<Student, String> gradeMap = new TreeMap<Student, String>();
      Map<Integer, Student> idToStudentMap = new TreeMap<Integer, Student>();

      String choice = printMenuAndGetChoice();
      while (!choice.equals("Q"))
      {
         if (choice.equals("A"))
         {
            addStudent(gradeMap, idToStudentMap);
         }
         if (choice.equals("R"))
         {
            removeStudent(gradeMap, idToStudentMap);
         }
         if (choice.equals("M"))
         {
            modifiyStudent(gradeMap, idToStudentMap);
         }
         if (choice.equals("P"))
         {
            printGrades(gradeMap);
         }
         choice = printMenuAndGetChoice();
      }
   }
}