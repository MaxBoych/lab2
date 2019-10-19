import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] parsed = AirportParserCSV.parse(value.toString(), 1);
        if (parsed.length == 0) {
            return;
        }
        context.write(new AirportWritableComparable(Integer.parseInt(parsed[14]), 1), new Text(parsed[18]));

        /*ServiceCall call = new ServiceCall(value);
        context.write(new TextPair(call.getSystemA().toString(),"1"),
                new Text(call.toString()));*/
    }
}