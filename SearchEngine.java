import java.util.Vector;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileNotFoundException;
import static java.lang.Math.pow;

public class SearchEngine
{   public InvertedPageIndex in=new InvertedPageIndex();

	public SearchEngine() 
	{
		in=new InvertedPageIndex();
	}

	public void performAction(String actionMessage)
	{
		int u=actionMessage.indexOf(32);
		float f;
		function fn;
		int flag;
		
		switch(actionMessage.substring(0,u))
		{
			case "addPage":
			                                      for(int p=0;p<in.pages.vector().size();p++)
			                                      {
			                                      	if(in.pages.vector().get(p).nameofpage().equals(actionMessage.substring(8)))
			                                         {
			                                      	    System.out.println(actionMessage.substring(8)+" ->page already there");
			                                      	    return;
			                                         }

			                                      }
			                                      
			                                      PageEntry p=new PageEntry(actionMessage.substring(8));
			                                      in.addPage(p);
			                                      
			                                      
			                                      
			                                      
			                                      break;

			case "queryFindPagesWhichContainWord":
                                                  String word=actionMessage.substring(31).toLowerCase();
                                                  if(word.length()>3&&word.charAt(word.length()-1)=='s')
				   	        					   {
				   	        					   word=word.substring(0,word.length()-1);
				   	        					   }
				   	       							String o=".,;'?#!-:)({}[]<>=";
				   	        

				   	        					for(int l=0;l<o.length();l++)
				   	       						 {   
				   	        						for(int j=0;j<word.length();j++)
				   	        							{
				   	        							if((word.charAt(j)==o.charAt(l))||(int)word.charAt(j)==34)
				   	        								{
				   	        								
				   	        								word=word.substring(0, j);
				   	        								}
				   	        							}

				   	        					 }

			                                      MySet<PageEntry> pages=in.getPagesWhichContainWord(word);
			                                      System.out.println("pages containing "+actionMessage.substring(30)+" are: (in priority order) ->"+pages.vector().size());
			                                      Vector <relevance> r=new Vector <relevance>();
			                                      for(int j=0;j<pages.vector().size();j++)
			                                      {
			                                      	 f=0;
			                                      	 fn=new function(word);
			                                      	Node<WordEntry> t=in.h.pg[fn.getindex()].getWordEntries().head();
												  
												  while(t.data()!=null)
												  {  
  												  	if(t.data().Word().equals(word))
												  	{
												  		Node<Position> y=t.data().getAllPositionsForThisWord().head();
												  		while(y.data()!=null)
												  		{  
												  			if(y.data().getPageEntry().nameofpage().equals(pages.V.get(j).nameofpage()))
												  			{   
												  				f+=1/Math.pow(y.data().getWordIndex(),2);
												  			}
												  			
												  		 y=y.next;
												        }
												  		break;
												  	}
												  	else
												  	{
												  		t=t.next;
												  	}
												  }







			                                      	



			                                      	 relevance tr=new relevance(pages.V.get(j).nameofpage(),f);
			                                      	r.add(tr);
			                                      }
			                                      Collections.sort(r);


			                                      for(int i=r.size()-1;i>=0;i--)
			                                      {
			                                      	System.out.println("-->"+r.get(i).name()+" of relevance value = "+r.get(i).value());
			                                      }
			                                      break;
			                                      

			case "queryFindPositionsOfWordInAPage":
												  int x=32;	int z=1;
												  while((int)actionMessage.charAt(x)!=32)
												  {
												  	x++;
												  }
												  String wor=actionMessage.substring(32,x).toLowerCase();
												  flag=0;
												  for( int yu=0;yu<in.pages.vector().size();yu++)
			                                      {
			                                      	if(in.pages.vector().get(yu).nameofpage().equals(actionMessage.substring(x+1)))
			                                         {
			                                      	    flag=1;
			                                         }

			                                      }
			                                      if(flag==0)
			                                      	{System.out.println("first add the respective webpage- "+actionMessage.substring(x+1)); return;}


												  
												  System.out.println("Respective positions of "+wor+" on webpage "+actionMessage.substring(x+1)+" are: ");
                                                 
                                                  if(wor.length()>3&&wor.charAt(wor.length()-1)=='s')
				   	        					   {
				   	        					   wor=wor.substring(0,wor.length()-1);
				   	        					  
				   	        					   
				   	        					   }
				   	       							String q=".,;'?#!-:)({}[]<>=";

				   	        

				   	        					for(int l=0;l<q.length();l++)
				   	       						 {   
				   	        						for(int j=0;j<wor.length();j++)
				   	        							{
				   	        							if((wor.charAt(j)==q.charAt(l))||(int)wor.charAt(j)==34)
				   	        								{
				   	        								
				   	        								wor=wor.substring(0, j);
				   	        								
				   	        								}
				   	        							}

				   	        					 }  
				   	        					  fn=new function(wor);
												   Node<WordEntry> t=in.h.pg[fn.getindex()].getWordEntries().head();
												 
												  while(t.data()!=null)
												  {  
												  	if(t.data().Word().equals(wor))
												  	{
												  		 Node<Position> y=t.data().getAllPositionsForThisWord().head();
												  		while(y.data()!=null)
												  		{ 
												  			if(y.data().getPageEntry().nameofpage().equals(actionMessage.substring(x+1)))
												  			{   if(z!=1)
												  				{System.out.print(", "); }
												  				z=2;
												  				System.out.print(y.data().getWordIndex());
												  			}
												  			
												  		 y=y.next;
												        }
												  		break;
												  	}
												  	else
												  	{
												  		t=t.next;
												  	}
												  }
												  if(z==1){System.out.println("Webpage "+actionMessage.substring(x+1)+" doesn't contain the word "+actionMessage.substring(32,x));}
						                           else{System.out.println("");}
												   break;

		  case "queryFindPagesWhichContainAllWords":

		                                            x=35;
		                                           int y;
		                                           y=x;
		                                            
		                                           int cn=0;
		                                            String str[]=new String[20];
												  	 while((int)actionMessage.charAt(y)!=32)
												      {
												  	    y++;
												      }
												      wor=actionMessage.substring(x,y).toLowerCase();
												      
												      x=y+1;
												      str[cn]=wor;
												  
												 
												  pages=in.getPagesWhichContainWord(wor);
												  MySet<PageEntry> result=new MySet<PageEntry>();
												  MySet<PageEntry> temp=new MySet<PageEntry>();
												 


												 
												  while(x<actionMessage.length())

												  { 
												     y=x;
												  	 while((int)actionMessage.charAt(y)!=32)
												      {
												  	    y++;
												  	    
												  	    if(y>=actionMessage.length())
												  	    {
												  	    	break;
												  	    }
												      }
												      wor=actionMessage.substring(x,y).toLowerCase();
												      
												      x=y+1;
												      cn++;
												      str[cn]=wor;
												      temp=in.getPagesWhichContainWord(wor);
												      result=pages.intersection(temp);
												      
												  }
												  System.out.println("pages containing all words are -:");
												  r=new Vector <relevance>();
												  float fl;
												  for( y=0;y<result.vector().size();y++)
												  {
												  	
												  	fl=result.V.get(y).getRelevanceOfPage(str,false,in);
												  	relevance tr=new relevance(result.V.get(y).nameofpage(),fl);
			                                      	r.add(tr);
			                                      }
			                                      Collections.sort(r);


			                                      for(int i=r.size()-1;i>=0;i--)
			                                      {
			                                      	System.out.println("-->"+r.get(i).name()+" of relevance value = "+r.get(i).value());
			                                      }
			                                      break;

			  case "queryFindPagesWhichContainAnyOfTheseWords":

			  										 x=42;
		                                           
		                                           y=x;
		                                           cn=0;
		                                           
		                                            String stri[]=new String[20];
												  	 while((int)actionMessage.charAt(y)!=32)
												      {
												  	    y++;
												      }
												      wor=actionMessage.substring(x,y).toLowerCase();
												      x=y+1;
												      stri[cn]=wor;
												  
												  
												   pages=in.getPagesWhichContainWord(wor);
												   result=new MySet<PageEntry>();
												   temp=new MySet<PageEntry>();
												 


												  while(x<actionMessage.length())
												  { 
												     y=x;
												  	 while((int)actionMessage.charAt(y)!=32)
												      {
												  	    y++;
												  	    if(y>=actionMessage.length())
												  	    {
												  	    	break;
												  	    }
												      }
												      wor=actionMessage.substring(x,y).toLowerCase();
												      x=y+1;
												      cn++;
												      stri[cn]=wor;
												      temp=in.getPagesWhichContainWord(wor);
												      result=pages.union(temp);
												  }
												   r=new Vector <relevance>();
												 
												  for( y=0;y<result.vector().size();y++)
												  {
												  	
												  	fl=result.V.get(y).getRelevanceOfPage(stri,false,in);
												  	relevance tr=new relevance(result.V.get(y).nameofpage(),fl);
			                                      	r.add(tr);
			                                      }
			                                      Collections.sort(r);
			                                       System.out.println("pages containing any of the words are -:");


			                                      for(int i=r.size()-1;i>=0;i--)
			                                      {
			                                      	System.out.println("-->"+r.get(i).name()+" of relevance value = "+r.get(i).value());
			                                      }
			                                      break;

			 case "queryFindPagesWhichContainPhrase":      
			 
			 										x=33;
		                                           
		                                           y=x;
		                                           cn=0;
		                                           
		                                           String strin[]=new String[20];
												  	 while((int)actionMessage.charAt(y)!=32)
												      {
												  	    y++;
												      }
												      wor=actionMessage.substring(x,y).toLowerCase();
												      x=y+1;
												      strin[cn]=wor;
												      
												  
												 
												 


												  while(x<actionMessage.length())
												  { 
												     y=x;
												  	 while((int)actionMessage.charAt(y)!=32)
												      {
												  	    y++;
												  	    if(y>=actionMessage.length())
												  	    {
												  	    	break;
												  	    }
												      }
												      wor=actionMessage.substring(x,y).toLowerCase();
												      
												      x=y+1;
												      cn++;
												      strin[cn]=wor;
												      
												  }
												  System.out.println("pages containing phrase -:");
												  result=in.getPagesWhichContainPhrase(strin);
												  if(result==null)
												  {
												  	System.out.println("no page found with given phrase");
												  	return;
												  }
												   r=new Vector <relevance>();
												  
												  for( y=0;y<result.vector().size();y++)
												  {
												  	
												  	fl=result.V.get(y).getRelevanceOfPage(strin,true,in);
												  	relevance tr=new relevance(result.V.get(y).nameofpage(),fl);
			                                      	r.add(tr);
			                                      }
			                                      Collections.sort(r);
			                                       


			                                      for(int i=r.size()-1;i>=0;i--)
			                                      {
			                                      	System.out.println("-->"+r.get(i).name()+" of relevance value = "+r.get(i).value());
			                                      }
			                                      break;
			                                                                     




											   



			  default:                            System.out.println("Error Message");
		}
		

	}
}
