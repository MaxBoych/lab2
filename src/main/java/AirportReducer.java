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

        double max = Double.MIN_VALUE, min = Double.MAX_VALUE, sum = 0.0, size = 0.0;
        String airportName = "";
        for (; iter.hasNext(); size++) {
            String str = iter.next().toString();
            //System.out.println(str);
            //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            //System.out.println();
            if (str.isEmpty()) {
                continue;
            } else if (str.matches(".*[a-zA-Z]+.*")) {
                airportName = str;
                continue;
            }
            double current = Double.parseDouble(str);

            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }
            sum += current;

            /*Text call = iter.next();
            Text outValue = new Text(call.toString() + "\t" + systemInfo.toString());
            */
        }

        context.write(new Text(airportName), new Text("Max: " + max + " | Min: " + min + " | Middle: " + sum / size));
    }
}