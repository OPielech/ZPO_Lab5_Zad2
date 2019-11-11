import java.time.LocalDate;
import java.util.*;

public class BodyBuilderTest implements Comparator<BodyBuilder> {

    public static void main(String[] args) {
        BodyBuilder b1 = new BodyBuilder("Kamil", BodyBuilder.Sex.Male, 110, 195
                , LocalDate.of(1998, 02, 1));
        BodyBuilder b2 = new BodyBuilder("Agata", BodyBuilder.Sex.Female, 70, 170
                , LocalDate.of(1999, 03, 5));
        BodyBuilder b3 = new BodyBuilder("Marcin", BodyBuilder.Sex.Male, 120, 190
                , LocalDate.of(1997, 06, 21));
        BodyBuilder b4 = new BodyBuilder("Dominik", BodyBuilder.Sex.Male, 90, 180
                , LocalDate.of(2000, 10, 15));
        BodyBuilder b5 = new BodyBuilder("Ewa", BodyBuilder.Sex.Female, 65, 168
                , LocalDate.of(1998, 12, 30));

        List<BodyBuilder> list = Arrays.asList(b1, b2, b3, b4, b5);
        System.out.println(list);

        Collections.sort(list, new BodyBuilderTest());
        System.out.println("Name of body builder with the highest PPM: " + largest(list).getName());
    }//end of main

    public static BodyBuilder largest(List<BodyBuilder> list) {
        Collections.sort(list, new BodyBuilderTest());
        BodyBuilder bppm = list.get(0);
        return bppm;

    }//end of largest

    @Override
    public int compare(BodyBuilder b1, BodyBuilder b2) {
        return Integer.compare((int) b2.getMeasure(), (int) b1.getMeasure());
    }//end of compare
}//end of class
