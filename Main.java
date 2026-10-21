
public class Main {

    public static void main(String[] args) {

        // Membuat mata kuliah
        Course course = new Course();
        course.setTitle("Pemrograman Berorientasi Objek");

        // Membuat mahasiswa pertama
        Student student1 = new Student();
        student1.setName("Andi");

        CourseRecord record1 = new CourseRecord();
        record1.setStudent(student1);

        Assignment assignment1 = new Assignment();
        assignment1.setMark(80);

        Assignment assignment2 = new Assignment();
        assignment2.setMark(90);

        record1.addAssignment(assignment1);
        record1.addAssignment(assignment2);

        course.addCourseRecord(record1);

        // Membuat mahasiswa kedua
        Student student2 = new Student();
        student2.setName("Budi");

        CourseRecord record2 = new CourseRecord();
        record2.setStudent(student2);

        Assignment assignment3 = new Assignment();
        assignment3.setMark(70);

        Assignment assignment4 = new Assignment();
        assignment4.setMark(75);

        record2.addAssignment(assignment3);
        record2.addAssignment(assignment4);

        course.addCourseRecord(record2);

        // Menjalankan ketiga method
        course.printCourseStudents();

        System.out.println();

        course.printBestStudent();

        System.out.println();

        course.printFinalExamStudents();
    }
}