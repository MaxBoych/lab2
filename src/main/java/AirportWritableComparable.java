import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
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
    public int compareTo(AirportWritableComparable obj) {
        int i = (this.airportID == obj.airportID) ?
                (this.keyData - obj.keyData) :
                (this.airportID - obj.airportID);
        System.out.println("ID: " + this.airportID + " " + obj.airportID);
        System.out.println("Key: " + this.keyData + " " + obj.keyData);
        System.out.println(i);
        System.out.println();
        return i;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.airportID);
        dataOutput.writeInt(this.keyData);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.airportID = dataInput.readInt();
        this.keyData = dataInput.readInt();
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportWritableComparable that = (AirportWritableComparable) o;
        return airportID == that.airportID &&
                keyData == that.keyData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportID, keyData);
    }*/
}
