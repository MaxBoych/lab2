import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text, Text> {
    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();

        //Text systemInfo = new Text(iter.next());

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;

        for (; iter.hasNext(); ) {
            int current = Integer.parseInt(iter.next().toString());
            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }

            sum 

            /*Text call = iter.next();
            Text outValue = new Text(call.toString() + "\t" + systemInfo.toString());
            context.write(key.getFirst(), outValue);*/
        }
    }
}