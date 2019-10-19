import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    private static final int AIRPORT_ID = 14;
    private static final int DELAYED = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] parsed = AirportParserCSV.parse(value.toString(), 1);
        if (parsed.length == 0) {
            return;
        }
        context.write(new AirportWritableComparable(Integer.parseInt(parsed[AIRPORT_ID]), 1), new Text(parsed[DELAYED]));

        /*ServiceCall call = new ServiceCall(value);
        context.write(new TextPair(call.getSystemA().toString(),"1"),
                new Text(call.toString()));*/
    }
}