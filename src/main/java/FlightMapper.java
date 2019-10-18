import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        
        context.write(new AirportWritableComparable(0, 0), new Text("abcdef " + value.toString()));
        /*ServiceCall call = new ServiceCall(value);
        context.write(new TextPair(call.getSystemA().toString(),"1"),
                new Text(call.toString()));*/
    }
}