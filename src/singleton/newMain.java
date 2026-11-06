package singleton;

// project specific implementation 

class AcademicConfiguration {
    private static volatile AcademicConfiguration instance;

    String semesterStart;
    String semesterEnd;
    String registrationDeadline;
    int attendanceThreshold;

    private AcademicConfiguration(String semesterStart, String semesterEnd, String registrationDeadline, int attendanceThreshold) {
        this.semesterStart = semesterStart;
        this.semesterEnd = semesterEnd;
        this.registrationDeadline = registrationDeadline;
        this.attendanceThreshold = attendanceThreshold;
    }

    public static AcademicConfiguration getInstance(String semesterStart, String semesterEnd, String registrationDeadline, int attendanceThreshold) {
        if (instance == null) {
            synchronized (AcademicConfiguration.class) {
                if (instance == null) {
                    instance = new AcademicConfiguration(semesterStart, semesterEnd, registrationDeadline, attendanceThreshold);
                }
            }
        }
        return instance;
    }

    public void display() {
        System.out.println("Semester Start: " + semesterStart);
        System.out.println("Semester End: " + semesterEnd);
        System.out.println("Registration Deadline: " + registrationDeadline);
        System.out.println("Attendance Threshold: " + attendanceThreshold + "%");
    }
}

public class NewMain {
    public static void main(String[] args) {

        AcademicConfiguration a1 = AcademicConfiguration.getInstance("01-01-2026", "30-05-2026", "15-01-2026", 75);

        AcademicConfiguration a2 = AcademicConfiguration.getInstance("01-06-2026", "30-11-2026", "15-06-2026", 40);

        a1.display();

        System.out.println("\nSecond Object:");
        a2.display();

        System.out.println("\nSame Instance: " + (a1 == a2));
    }
}
