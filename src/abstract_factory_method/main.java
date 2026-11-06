package abstract_factory_method;

interface Course{
    void courseDetails();
}

interface Grading {
    void gradingSystem();
}

interface Examination {
    void examPattern();
}

class UGCourse implements Course{
    public void courseDetails() {
        System.out.println("UG Course: BCA, BSc, BCom");
    }
}

class UGGrading implements Grading {
    public void gradingSystem() {
        System.out.println("UG Grading: Semester-based CGPA");
    }
}

class UGExamination implements Examination {
    public void examPattern() {
        System.out.println("UG Examination: Written and Practical");
    }
}

class PGCourse implements Course {
    public void courseDetails() {
        System.out.println("PG Course: MCA, MSc, MCom");
    }
}

class PGGrading implements Grading {
    public void gradingSystem() {
        System.out.println("PG Grading: CGPA and Research Evaluation");
    }
}

class PGExamination implements Examination {
    public void examPattern() {
        System.out.println("PG Examination: Written, Project and Viva");
    }
}

interface EducationFactory {
    Course createCourse();
    Grading createGrading();
    Examination createExamination();
}

class UGFactory implements EducationFactory {
    public Course createCourse() {
        return new UGCourse();
    }

    public Grading createGrading() {
        return new UGGrading();
    }

    public Examination createExamination() {
        return new UGExamination();
    }
}

class PGFactory implements EducationFactory {
    public Course createCourse() {
        return new PGCourse();
    }

    public Grading createGrading() {
        return new PGGrading();
    }

    public Examination createExamination() {
        return new PGExamination();
    }
}




public class Main {

    public static void main(String[] args) {
        EducationFactory factory;

        factory = new UGFactory();

        Course course = factory.createCourse();
        Grading grading = factory.createGrading();
        Examination exam = factory.createExamination();

        System.out.println("Undergraduate System:");
        course.courseDetails();
        grading.gradingSystem();
        exam.examPattern();

        System.out.println();

        factory = new PGFactory();

        course = factory.createCourse();
        grading = factory.createGrading();
        exam = factory.createExamination();

        System.out.println("Postgraduate System:");
        course.courseDetails();
        grading.gradingSystem();
        exam.examPattern();
    }
    
}
