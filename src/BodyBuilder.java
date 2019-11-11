import java.time.LocalDate;

public class BodyBuilder implements Measurable {
    public enum Sex {Male, Female}

    private final String name;
    private final Sex sex;
    private double weight;
    private final double height;
    private final LocalDate dateOfBirth;

    public BodyBuilder(String name, Sex sex, double weight, double height, LocalDate dateOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;

        if (weight <= 0)
            throw new IllegalArgumentException();
        else
            this.weight = weight;

        if (height <= 0)
            throw new IllegalArgumentException();
        else
            this.height = height;

    }//end of constructor

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int age() {
        LocalDate date = LocalDate.now();
        return date.getYear() - dateOfBirth.getYear();
    }//end of age

    @Override
    public String toString() {
        return "Name: " + name
                + ", sex: " + sex
                + ", weight: " + weight
                + ", height: " + height
                + ", date of birth: " + dateOfBirth.toString()
                + "\n";
    }//end of toString

    @Override
    public double getMeasure() {
        double ppm = 0;
        if (sex.equals(Sex.Female))
            ppm = 655.1 + (9.563 * getWeight()) + (1.85 * getHeight()) - (4.676 * age());

        if (sex.equals(Sex.Male))
            ppm = 66.5 + (13.75 * getWeight()) + (5.003 * getHeight()) - (6.775 * age());

        return ppm;
    }//end of getMeasure
}//end of class
