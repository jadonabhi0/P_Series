package ComparableAndComparetor;

public class StudentComparable implements Comparable<StudentComparable> {

    public StudentComparable(int id, String name, int sallary) {
        this.id = id;
        this.name = name;
        this.sallary = sallary;
    }

    @Override
    public String toString() {
        return "StudentComparable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sallary=" + sallary +
                '}';
    }

    private int id;
    private String name;
    private int sallary;

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

    public int getSallary() {
        return sallary;
    }

    public void setSallary(int sallary) {
        this.sallary = sallary;
    }


    @Override
    public int compareTo(StudentComparable o) {
        if (this.sallary > o.getSallary())return -1;
        else if(this.sallary < o.getSallary())  return 1;
        else return this.name.compareTo(o.getName());
    }
}
