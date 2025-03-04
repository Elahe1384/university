package uni;
import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }
    public void setGrade(int PresentedCourseID , double grade) {
        transcript.put(PresentedCourseID, grade);
        System.out.println("Grade set to " + grade + " for course " + PresentedCourseID);

    }
    public void printTranscript() {
        System.out.println("Student's Transcript" + studentID + ":");
        for (HashMap.Entry<Integer, Double> entry : transcript.entrySet()) {
            int presentedCourseID = entry.getKey();
            double grade = entry.getValue();
            PresentedCourse presentedCourse = PresentedCourse.findById(presentedCourseID);
            if (presentedCourse != null) {
                Course course = Course.findByID(presentedCourse.CourseID);
                if (course != null) {
                    System.out.println("course : " + course.title + " | grade :" + grade);
                } else {
                    System.out.println("course" + presentedCourse.CourseID + "not found.");
                }
            } else {
                System.out.println("presented course" + presentedCourseID + "not found.");
            }
        }
        System.out.println("average : " + getGPA());
    }

    public double getGPA() {
        if(transcript.isEmpty()) {
            return 0.0;
        }
        else {
            double sum = 0.0;
            int unitSum = 0;
            for (Integer id : transcript.keySet()) {
                Course course = Course.findByID(id);
                if (course != null) {
                    sum += transcript.get(id) * course.units;
                    unitSum += course.units;
                }
                else {
                    System.out.println("course " + id + "not found.");
                }
            }
            return sum / unitSum;
        }
    }
}