
import java.util.Collections;
import java.util.Comparator;
import java.awt.*;
 public class relevance implements Comparable<relevance>
{
	String name;
	float value;
	

	public relevance(String s,float v)
	{
      name =s;
      value=v;
	}
	public static class relevancebypos implements Comparator <relevance> 
	{

        
        public int compare(relevance o1, relevance o2) 
        {
            return o1.compareTo(o2);
        }
    }
    public String name()
    {
    	return name;
    }
    public int compareTo(relevance o) {
        return this.value > o.value ? 1 : (this.value < o.value ? -1 : 0);
    }

    public float value()
    {
    	return value;
    }


}


