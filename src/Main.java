import java.util.*;
import uni.*;
import base.Person;

public class Main {
    public static void main(String[] args) {

        Person sara = new Person("Sara", "1111");
        Person john = new Person("John", "2222");
        Person charlie = new Person("Charlie", "3333");
        Person david = new Person("David", "4444");
        Person alice = new Person("Alice", "5555");

        Major math = new Major("Math", 45);
        Major english = new Major("English", 76);

        Student saraStu = new Student(sara.id, 1403, math.id);
        Student johnStu = new Student(john.id, 1400, math.id);
        Student charlieStu = new Student(charlie.id, 1401, english.id);

        Professor davidPro = new Professor(david.id, 1);
        Professor alicePro = new Professor(alice.id, 2);

        Course mathCourse = new Course("Mathematics 1", 4);
        Course englishCourse = new Course("English", 1);
        Course physicCourse = new Course("Physic", 3);

        PresentedCourse mathP = new PresentedCourse(mathCourse.id, davidPro.id, 25);
        PresentedCourse englishP = new PresentedCourse(englishCourse.id, davidPro.id, 12);
        PresentedCourse physicP = new PresentedCourse(physicCourse.id, alicePro.id, 12);

        mathP.addStudent(saraStu.id);
        mathP.addStudent(johnStu.id);

        englishP.addStudent(saraStu.id);
        englishP.addStudent(charlieStu.id);
        englishP.addStudent(johnStu.id);

        physicP.addStudent(charlieStu.id);

        Transcript saraTranscript = new Transcript(saraStu.id);
        Transcript johnTranscript = new Transcript(johnStu.id);
        Transcript charlieTranscript = new Transcript(charlieStu.id);

        saraTranscript.setGrade(mathP.id, 18.34);
        saraTranscript.setGrade(englishP.id, 12.5);

        johnTranscript.setGrade(mathP.id, 17.5);
        johnTranscript.setGrade(englishP.id, 20);

        charlieTranscript.setGrade(englishP.id, 14);
        charlieTranscript.setGrade(physicCourse.id, 20);

        saraTranscript.printTranscript();
        johnTranscript.printTranscript();
        charlieTranscript.printTranscript();

    }
}