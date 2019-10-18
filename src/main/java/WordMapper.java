import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        StringTokenizer tokens = new StringTokenizer(value.toString().replaceAll("[^а-яА-Яa-zA-Z0-9\\s+]", "").toLowerCase());
        while (tokens.hasMoreTokens()) {
            Text word = new Text();
            word.set(tokens.nextToken());
            context.write(word, new IntWritable(1));
            int a = 0;
            int b = 2;
            

        }
    }
}
