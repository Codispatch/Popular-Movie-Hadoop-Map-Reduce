import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.TaskID;

public class StubReducer extends Reducer<Text, Text, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {


	  double highest_rating=0.0;
	  String movie_title ="";
	  for(Text val:values)
	  {
		  String s[] = val.toString().split("\t");
		  
			  if(Double.parseDouble(s[2]) >highest_rating){	  
				  highest_rating=Double.parseDouble(s[2]);
				  movie_title = " Most watched movie----> Movie: "+s[0] +", FaceBook likes: "+s[1]+", IMBD rating: "+ s[2] +"\n";
				  
			  }
	  }
	
	  
	  context.write(new Text(key), new Text(movie_title));
  }
}