import java.util.Vector;
import java.io.File;

public class InvertedPageIndex
{
	public MySet<PageEntry> pages=new MySet<PageEntry>();
	public MyHashTable h=new MyHashTable();
	public function fn;
	public InvertedPageIndex()
	{
		 pages=new MySet<PageEntry>();
	     h=new MyHashTable();
	}

	public void addPage(PageEntry p)
	{
		pages.addElement(p);
		Node<WordEntry> n=p.getPageIndex().getWordEntries().head();
		while(n.data()!=null)
		{
			h.addhashPositionsForWord(n.data());
			n=n.next;
		}
	}

	public MySet<PageEntry> getPagesWhichContainWord(String str)
	{
		MySet<PageEntry> res=new MySet<PageEntry>();
		int x=pages.V.size();
		
		for(int i=0;i<x;i++)
		{    
			Node<WordEntry> k=pages.V.get(i).getPageIndex().getWordEntries().head();
			
			
			while(k.data()!=null)
			{  
		        String l=k.data().Word();
				  if(l.equals(str))
			       {      
                         res.addElement(pages.vector().get(i));
                         break;
			       }
			       else
			       {
			       	  k=k.next;
			       }
			}
			

		}
		return res;
		
	}
	public MySet<PageEntry> getPagesWhichContainPhrase(String str[])
	{
		MySet<PageEntry> set=new MySet<PageEntry>();
		
		int count=0;
		int i=0;
		Boolean phrase=false;;
          while(str[i]!=null){count++;i++;} 
		fn=new function(str[0]);
	    Node<WordEntry> t=this.h.pg[fn.getindex()].getWordEntries().head();
	    if(t.data()==null)
	    	{return null;}
	   
												  
	    while(t.data()!=null)
	   {
	      if(t.data().Word().equals(str[0]))
	      {
	      	Node<Position> y=t.data().getAllPositionsForThisWord().head();
	      	while(y.data()!=null)
	      	{
	      		for(int k=1;k<count;k++)
	      		{   fn=new function(str[k]);
	      			Node<WordEntry> m=this.h.pg[fn.getindex()].getWordEntries().head();
	      			while(m.data()!=null)
	      			{
	      				if(m.data().Word().equals(str[k]))
	      				{
	      					
	      					Position ps=new Position(y.data().getPageEntry(),0,y.data().poswithoutconnector()+k);
	      					
	      					if(m.data().t.search(ps,m.data().t.Root())==true)
	      					{
	      						phrase=true;
	      						
	      					}
	      					else
	      					{
	      						phrase=false;
	      						break;
	      					}
	      					if(phrase==false){break;}
	      				}
	      				m=m.next;
	      			}
	      		}
	      		if(phrase==true)
	      		{
	      			set.addElement(y.data().getPageEntry());
	      			
	      		}

	      		y=y.next;
	      	}


	        break;
	      } 

	      t=t.next; 
	   }
	   return set;

	}

}
