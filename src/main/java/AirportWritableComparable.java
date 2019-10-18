import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable {
    private int airportID;
    private int keyData;

    AirportWritableComparable(int airportID, int keyData) {
        this.airportID = airportID;
        this.keyData = keyData;
    }

    public int getAirportID() {
        return this.airportID;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
