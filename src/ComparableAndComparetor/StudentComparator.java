package ComparableAndComparetor;

import java.util.Comparator;

public class StudentComparator {

    private int id;
    private String name;

    public StudentComparator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentComparator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
