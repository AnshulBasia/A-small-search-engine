import java.util.Vector;

public class MySet<T>
{
   Vector<T> V = new Vector<T>();

	public void addElement( T element)
	{
        V.add(element);
	}

	public Vector<T> vector()
	{
		return V;
	}

	public MySet<T> union(MySet<T> otherSet)
	{ 
		 MySet<T> S =new MySet<T>();
		 S.V.addAll(V);
		 for(int i=0;i<otherSet.V.size();i++)
		 {
             if(V.contains(otherSet.V.elementAt(i)))
             	{continue;}
             S.addElement(otherSet.V.elementAt(i));

		 }
		 
		 return S;
         
	}

	public MySet<T> intersection(MySet<T> otherSet)
	{
          MySet<T> S =new MySet<T>();
          for(int i=0;i<otherSet.V.size();i++)
          {
          	if(V.contains(otherSet.V.elementAt(i)))
              {
              	S.addElement(otherSet.V.elementAt(i));
              }
          }
          return S;
	}


	
}
