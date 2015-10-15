import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PageEntry
{     public String name;
	 public PageIndex x=new PageIndex();
	 public int pos=0;
	 public int post=0;
	 public Position p;
	 
	 public Boolean connector;
	 public function fn;
	 public String nameofpage()
	 {
	 	return name;
	 }
	public PageEntry(String pageName)
	{       name=pageName;
		 x=new PageIndex();
		
           BufferedReader br = null;
           
            
			String word;
			try{
				
			br = new BufferedReader(new FileReader(pageName));
			
			Scanner s=new Scanner(br);
			
			   while (s.hasNext())
			   {   word=s.next();
			   	  
			   	   pos++;
				   word=word.toLowerCase();
				   switch(word)
				   {
				   	case"a":connector=true;break;
				   	case"an":connector=true;break;
				   	case"the":connector=true;break;
				   	case"they":connector=true;break;
				   	case"these":connector=true;break;
				   	case"for":connector=true;break;
				   	case"is":connector=true;break;
				   	case"are":connector=true;break;
				   	case"or":connector=true;break;
				   	case"of":connector=true;break;
				   	case"and":connector=true;break;
				   	case"does":connector=true;break;
				   	case"will":connector=true;break;
				   	case"whose":connector=true;break;
				   	default:
				   	        connector=false;
				   	        if(word.length()>3&&word.charAt(word.length()-1)=='s')
				   	        {
				   	        	word=word.substring(0,word.length()-1);
				   	        	
				   	        }
				   	       String pu=".,;'?#!-:)({}[]<>=";
				   	        

				   	        for(int l=0;l<pu.length();l++)
				   	        {   
				   	        	for(int j=0;j<word.length();j++)
				   	        	{
				   	        		if(word.charAt(j)==pu.charAt(l)||(int)word.charAt(j)==34)
				   	        		{
				   	        		   if(j==0){word=word.substring(1);}
				   	        		   	else
				   	        		   	{
				   	        		   		if(j==word.length()-1){word=word.substring(0,j);}
				   	        		   
				   	        		     else
				   	        		     	{p=new Position(this,pos,post);
				   	        			x.addPostionForWord(word.substring(0, j),p);
				   	        			pos++;
				   	        			word=word.substring(j+1);}
				   	        		}
				   	        			
				   	        		}
				   	        	}

				   	        }
				   	    }
                  if(connector==true){continue;}
                  else
                  	{  post++;
                  	  p=new Position(this,pos,post);
                  	 x.addPostionForWord(word,p);
                  	 
                  	}
				  	    

				 

			   }
			   System.out.println(pageName+"  -ADDED successfully");
		    } 
		    catch(FileNotFoundException e)
		    {System.err.println("File you were looking was not found -> "+pageName); return;}
		    catch (IOException e)
		    {
			  e.printStackTrace();
		    } 
		    finally 
		    {
			    try 
			       {
				     if (br != null)br.close();
			       }
			    catch (IOException ex)
			       {
				ex.printStackTrace();
			       }
		    }
		}
		
		    
	

	public PageIndex getPageIndex()
	{  
		return x;
	}

	public float getRelevanceOfPage(String str[],Boolean doTheseWordsRepresentAPhrase,InvertedPageIndex in)
	{   int count=0;
		int i=0;
		float fl=0;
		Boolean phrase=false;
         while(str[i]!=null){count++;i++;} 
      if(doTheseWordsRepresentAPhrase==true)
	  {
	    
		
		fn=new function(str[0]);
	    Node<WordEntry> t=in.h.pg[fn.getindex()].getWordEntries().head();
												  
	    while(t.data()!=null)
	   {
	      if(t.data().Word().equals(str[0]))
	      {
	      	Node<Position> y=t.data().getAllPositionsForThisWord().head();
	      	while(y.data()!=null)
	      	{
	      		for(int k=1;k<count;k++)
	      		{  
	      			fn=new function(str[k]);
	      			Node<WordEntry> m=in.h.pg[fn.getindex()].getWordEntries().head();
	      			while(m.data()!=null)
	      			{
	      				if(m.data().Word().equals(str[k]))
	      				{  
	      					Position ps=new Position(y.data().getPageEntry(),0,y.data().poswithoutconnector()+k);
	      					if(m.data().gettreeofpos().search(ps,m.data().gettreeofpos().Root())==true)
	      					{
	      						phrase=true;
	      						
	      					}
	      					else
	      					{
	      						phrase=false;
	      						break;
	      					}
	      				}
	      				m=m.next;
	      			}
	      		}
	      		if(phrase==true)
	      		{
	      			
	      			fl+=1/Math.pow(y.data().getWordIndex(),2);
	      			
	      		}

	      		y=y.next;
	      	}


	        break;
	      } 

	      t=t.next; 
	   }
	   return fl;
    }

	else
	{ fl=0;
		for(i=0;i<count;i++)
			{  
				
						fn=new function(str[i]);
	                    Node<WordEntry> t=in.h.pg[fn.getindex()].getWordEntries().head();
	                    while(t.data()!=null)
	                     {
	                      if(t.data().Word().equals(str[i]))
	                         {
	      	                    Node<Position> y=t.data().getAllPositionsForThisWord().head();
	      	                       while(y.data()!=null)
	      	                        {
	      	                        	if(y.data().getPageEntry().nameofpage().equals(name))
	      	                        	{fl+=1/Math.pow(y.data().getWordIndex(),2);}
	      	                        	y=y.next;
	      	                        	


	      	                        }
	      	                        break;
					         }  
				          else 
					         {t=t.next;}
			              }
			                

	        }
	        return fl;

	}

        


       
  }
}
