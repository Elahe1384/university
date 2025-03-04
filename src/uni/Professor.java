package uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int PersonID;
    public int MajorID;

    public Professor(int PersonID, int MajorID) {
        this.PersonID = PersonID;
        this.MajorID = MajorID;
        this.id = professorList.size() + 1;
        professorList.add(this);

    }

    public static Professor findByID(int id) {
        for (Professor professor : professorList) {
            if (professor.id == id) {
                return professor;
            }
        }
        return null;
    }
}
