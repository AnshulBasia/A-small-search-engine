import java.util.Vector;
public class MyHashTable
{    function f;
	public PageIndex[] pg=new PageIndex[25];
	public MyHashTable()
	{PageIndex[] pg=new PageIndex[25];}

	public int getHashIndex(String str)
	{
		 f=new function(str);
		return f.getindex();
	}

	public void addhashPositionsForWord(WordEntry w)
	{
		
		f=new function(w.Word());
		int x=f.getindex();
		
		if(pg[x]==null)
		{
			PageIndex p=new PageIndex();
			p.addPos(w.Word(),w.getAllPositionsForThisWord());
			pg[x]=p;
			return;
		}
		else
		{   Node<WordEntry> n=pg[x].getWordEntries().head();
			int j=pg[x].getWordEntries().no_elements();
			for(int i=0;i<j;i++)
			{
                  if(n.data.Word().equals(w.Word()))
                  {
                  	  n.data().addPositions(w.getAllPositionsForThisWord());
                  	  return;
                  }
                  else
                  {
                  	n=n.next;
                  }
			}

			pg[x].getWordEntries().addelement(w);
		}

	}



}
