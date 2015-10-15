import static java.lang.Math.pow;
public class function
{
	String str;
	int index;
	public function(String s)
	{
		str=s;
		index=0;
		for(int i=0;i<s.length();i++)
		{
             index+=Math.pow((int)s.charAt(i),i);
		}
		index=index%25;

	}

	public int getindex()
	{
		  
		return index;

	}
}
