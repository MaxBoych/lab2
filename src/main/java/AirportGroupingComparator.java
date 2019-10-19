import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirportGroupingComparator extends WritableComparator {
    AirportGroupingComparator() {
        super(AirportWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        AirportWritableComparable a1 = (AirportWritableComparable) a;
        AirportWritableComparable b1 = (AirportWritableComparable) b;

        int i = a1.getAirportID() - b1.getAirportID();
        //System.out.println("Comp | a1.ID: " + a1.getAirportID() + " b1.ID: " + b1.getAirportID());
        //System.out.println(i);
        //System.out.println();
        return i;
    }
}
