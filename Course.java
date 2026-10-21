
import java.util.Vector;
import java.util.Enumeration;

public class Course {

    private String title;
    private Vector<CourseRecord> courseRecords;

    Course() {
        courseRecords = new Vector<CourseRecord>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    // Mencetak seluruh mahasiswa yang mengambil mata kuliah
    public void printCourseStudents() {
        System.out.println("Daftar Mahasiswa Mata Kuliah: " + title);

        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord record = records.nextElement();
            Student student = record.getStudent();

            if (student != null) {
                System.out.println("- " + student.getName());
            }
        }
    }

    // Mencetak mahasiswa dengan nilai rata-rata terbaik
    public void printBestStudent() {
        Student bestStudent = null;
        double bestAverage = -1;

        Enumeration<CourseRecord> records = getCourseRecords();

        while (records.hasMoreElements()) {
            CourseRecord record = records.nextElement();
            Student student = record.getStudent();

            if (student == null) {
                continue;
            }

            try {
                double average = calculateAverage(record);

                if (average >= 0 && average > bestAverage) {
                    bestAverage = average;
                    bestStudent = student;
                }
            } catch (NotYetSetException e) {
                // Lewati mahasiswa yang masih memiliki nilai belum diisi
            }
        }

        System.out.println("Mahasiswa dengan Nilai Rata-rata Terbaik:");

        if (bestStudent != null) {
            System.out.println("Nama: " + bestStudent.getName());
            System.out.println("Rata-rata: " + bestAverage);
        } else {
            System.out.println("Belum ada nilai lengkap untuk dihitung.");
        }
    }

    // Mencetak mahasiswa yang layak mengikuti ujian akhir
    public void printFinalExamStudents() {
        final double MINIMUM_AVERAGE = 60.0;

        System.out.println("Mahasiswa yang Layak Ujian Akhir:");

        Enumeration<CourseRecord> records = getCourseRecords();
        boolean found = false;

        while (records.hasMoreElements()) {
            CourseRecord record = records.nextElement();
            Student student = record.getStudent();

            if (student == null) {
                continue;
            }

            try {
                double average = calculateAverage(record);

                if (average >= MINIMUM_AVERAGE) {
                    System.out.println(
                        "- " + student.getName()
                        + " (Rata-rata: " + average + ")"
                    );

                    found = true;
                }
            } catch (NotYetSetException e) {
                // Nilai yang belum diisi membuat mahasiswa belum memenuhi syarat
            }
        }

        if (!found) {
            System.out.println("Belum ada mahasiswa yang memenuhi syarat.");
        }
    }

    // Menghitung nilai rata-rata seluruh assignment
    private double calculateAverage(CourseRecord record)
            throws NotYetSetException {

        Enumeration<Assignment> assignments =
                record.getAssignments();

        double total = 0;
        int count = 0;

        while (assignments.hasMoreElements()) {
            Assignment assignment = assignments.nextElement();

            total += assignment.getMark();
            count++;
        }

        if (count == 0) {
            return -1;
        }

        return total / count;
    }
}
