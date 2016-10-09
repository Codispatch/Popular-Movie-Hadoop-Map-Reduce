import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<LongWritable, Text, Text, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

	  // Split each column of the Row  
	  String [] words = value.toString().split(",");
	  
	 	  
	  String str = words[0]+"\t"+words[1]+"\t"+words[2]+"\t";
	  
	  
	  
	  String [] genres = words[3].split("\\^");
	  
	 //for(String gen:genres)
	 //{
		  context.write(new Text(genres[0]), new Text(str));
	// }
		 
	 
    
	  
  

  }
}