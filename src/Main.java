import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Creer une liste des etudiants
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(new Etudiant(1, "Alice", 20));
        etudiants.add(new Etudiant(2, "Bob", 22));
        etudiants.add(new Etudiant(3, "Charlie", 21));

        // Creer une instance de studentmanagement
        StudentManagement studentManagement = new StudentManagement();

        // Afficher tous les etudiants
        System.out.println("Displaying all students:");
        studentManagement.displayStudents(etudiants, System.out::println);
        System.out.println();

        // Filtre les etudiants par age
        System.out.println("Displaying students aged 21 and above:");
        studentManagement.displayStudentsByFilter(etudiants, etudiant -> etudiant.getAge() >= 21, System.out::println);
        System.out.println();

        // Retourner noms des etudiants
        System.out.println("Returning students' names:");
        String names = studentManagement.returnStudentsNames(etudiants, Etudiant::getNom);
        System.out.println(names);
        System.out.println();

        // Creer un nouveau etudiant avec supplier
        System.out.println("Creating a new student:");
        Etudiant newEtudiant = studentManagement.createStudent(() -> new Etudiant(4, "David", 19));
        System.out.println("New student: " + newEtudiant);
        System.out.println();

        // Trier Etudiants par ID
        System.out.println("Sorting students by ID:");
        List<Etudiant> sortedStudents = studentManagement.sortStudentsById(etudiants, Comparator.comparing(Etudiant::getId));
        sortedStudents.forEach(System.out::println);
        System.out.println();

        // Convertir etudiants en stream
        System.out.println("Converting students to a stream:");
        Stream<Etudiant> etudiantStream = studentManagement.convertToStream(etudiants);
        etudiantStream.forEach(System.out::println);
    }
}