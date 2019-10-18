import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.StringTokenizer;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //SystemInfo system = new SystemInfo(value);
        //System.out.println("qwerty");
        //System.out.println(value.toString());
        String[] idAndName = AirportParserCSV.parse(value.toString());
        if (idAndName.length == 0) {
            return;
        }
        context.write(new AirportWritableComparable(Integer.parseInt(idAndName[0]), 0), new Text(idAndName[1]));
    }
}
