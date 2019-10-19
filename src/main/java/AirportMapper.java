import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    private static final int AIRPORT_ID = 0;
    private static final int AIRPORT_NAME = 1;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] parsed = AirportParserCSV.parse(value.toString(), 0);
        if (parsed.length == 0) {
            return;
        }
        System.out.println(parsed[AIRPORT_ID] + "   " + parsed[AIRPORT_NAME]);
        context.write(new AirportWritableComparable(Integer.parseInt(parsed[AIRPORT_ID]), 0), new Text(parsed[AIRPORT_NAME]));
    }
}
