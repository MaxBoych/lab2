import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritableComparable implements WritableComparable {
    private int airportID;
    private int keyData;

    public AirportWritableComparable() {}

    AirportWritableComparable(int airportID, int keyData) {
        this.airportID = airportID;
        this.keyData = keyData;
    }

    int getAirportID() {
        return this.airportID;
    }

    @Override
    public int compareTo(Object obj) {
        return (this.airportID == obj.airportID) ? (this.keyData - obj.keyData) : (this.airportID - obj.airportID);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
