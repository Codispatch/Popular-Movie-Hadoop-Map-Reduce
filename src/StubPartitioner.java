import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class StubPartitioner extends   Partitioner < Text, Text > {
	
	      @Override
	      public int getPartition(Text key, Text value, int numReduceTasks)
	      {
	    	  
	         String col[] = value.toString().split("\t");
	         
	         double imdb_score = Double.parseDouble(col[2]);
	          
	         if(numReduceTasks == 0)
	         {
	            return 0;
	         }   
	         else  if(imdb_score<=7)
	         {
	            return 0;
	         }
	         else if(imdb_score>7 && imdb_score<=8)
	         {
	            return 1 % numReduceTasks;
	         }
	         else if(imdb_score>8 && imdb_score<=9)
	         {
	            return 2 % numReduceTasks;
	         }
	         else
	         {
	            return 3 % numReduceTasks;
	         }
	         
	      }
	   }