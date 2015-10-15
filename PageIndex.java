import java.util.Vector;
public class PageIndex
{
	public MyLinkedList<WordEntry> w=new MyLinkedList<WordEntry>();
	public PageIndex()
	{
		 w=new MyLinkedList<WordEntry>();
	}

	public void addPostionForWord(String str,Position p)
	{
		 for(int i=0;i<w.no_elements();i++)
		 {
		 	if(w.elementatpos(i).Word().equals(str))
		 	{
		 		w.elementatpos(i).addPosition(p);
		 		return;
		 	}
		 }


		 WordEntry W =new WordEntry(str);
		 W.addPosition(p);
		 w.addelement(W);


	}
	public void addPos(String str,MyLinkedList<Position> p)
	{
		 for(int i=0;i<w.no_elements();i++)
		 {
		 	if(w.elementatpos(i).Word().equals(str))
		 	{
		 		w.elementatpos(i).addPositions(p);
		 		return;
		 	}
		 }


		 WordEntry W =new WordEntry(str);
		 W.addPositions(p);
		 w.addelement(W);


	}

	public MyLinkedList<WordEntry> getWordEntries()
	{
		return w;
	}
}
