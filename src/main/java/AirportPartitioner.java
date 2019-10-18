import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class AirportPartitioner extends HashPartitioner {
    @Override
    public int getPartition(AirportWritableComparable key, Text value, int numReduceTasks) {
        return (Integer.valueOf(key.getAirportID()).hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
