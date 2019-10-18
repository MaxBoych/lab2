import org.apache.hadoop.io.WritableComparator;

public class AirportGroupingComparator extends WritableComparator {
    AirportGroupingComparator() {
        super(AirportWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparator a, WritableComparator b) {
        AirportGroupingComparator a1 = (AirportGroupingComparator) a;
        AirportGroupingComparator b1 = (AirportGroupingComparator) b;

        return 
    }
}
