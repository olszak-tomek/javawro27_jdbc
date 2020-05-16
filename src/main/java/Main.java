import model.Student;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

//        StudentDao dao = new StudentDao();
//
//        Student student = Student.builder()
//                .firstName("Paweł")
//                .lastName("Gaweł")
//                .alive(true)
//                .wzrost(1.8)
//                .age(25)
//                .build();
//
//        System.out.println(dao.getAllStudents());
//
//// U - Update
//        Student studentToUpdate = Student.builder()
//                .firstName("Gracjan")
//                .lastName("Nowak")
//                .alive(false)
//                .wzrost(2.13)
//                .age(36)
//                .id(1L)         // wymaga podania identyfikatora
//                .build();
//        //dao.updateStudent(studentToUpdate);
//
//        Student studentToDelete = Student.builder().id(1L).build();
//
//
//        dao.deleteStudent(studentToDelete);


        StudentDao dao = new StudentDao();
        Scanner scanner = new Scanner(System.in);

        String komenda;

        do{
            // https://pl.spoj.com/
            System.out.println("Podaj komendę [add/list/delete/update/quit]");
            komenda = scanner.nextLine();

            if(komenda.equalsIgnoreCase("add")){
                addStudents(dao, scanner);
            }else if(komenda.equalsIgnoreCase("list")){
                listStudents(dao);
            }else if(komenda.equalsIgnoreCase("delete")){
                deleteStudent(dao, scanner);
            }else if(komenda.equalsIgnoreCase("update")){
                updateStudent(dao, scanner);
            }

        }while (!komenda.equalsIgnoreCase("quit"));

    }

    private static void addStudents(StudentDao dao, Scanner scanner) {
        System.out.println("Podaj parametry: IMIE NAZWISKO WZROST WIEK ŻYWY");
        String linia = scanner.nextLine();
        String[] slowa = linia.split(" ");

        Student student = Student.builder()
                .firstName(slowa[0])
                .lastName(slowa[1])
                .wzrost(Double.parseDouble(slowa[2]))
                .age(Integer.parseInt(slowa[3]))
                .alive(Boolean.parseBoolean(slowa[4]))
                .build();

        dao.addToDatabase(student);
    }

    private static void listStudents(StudentDao dao) {
        System.out.println("Lista: ");

        dao.getAllStudents().forEach(System.out::println);
    }

    private static void deleteStudent(StudentDao dao, Scanner scanner) {
        System.out.println("Podaj parametry: Identyfikator");
        Long id = Long.valueOf(scanner.nextLine());

        dao.deleteStudent(id);
    }

    private static void updateStudent(StudentDao dao, Scanner scanner) {
        System.out.println("Podaj parametry: IMIE NAZWISKO WZROST WIEK ŻYWY");
        String linia = scanner.nextLine();
        String[] slowa = linia.split(" ");

        System.out.println("Podaj parametry: Identyfikator");
        Long id = Long.valueOf(scanner.nextLine());

        Student student = Student.builder()
                .firstName(slowa[0])
                .lastName(slowa[1])
                .wzrost(Double.parseDouble(slowa[2]))
                .age(Integer.parseInt(slowa[3]))
                .alive(Boolean.parseBoolean(slowa[4]))
                .id(id)
                .build();

        dao.updateStudent(student);


    }


}
