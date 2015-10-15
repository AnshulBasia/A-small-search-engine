import java.util.Vector;
public class WordEntry
{
	public String word;
	public MyLinkedList<Position> L=new MyLinkedList<Position>();
	public avltree t=new avltree();
	public WordEntry(String s)
	{
		word=s; 
		L=new MyLinkedList<Position>();
		t=new avltree();
	}

	public String Word()
	{
		return word;
	}

	public void addPosition(Position pos)
	{
         
         L.addelement(pos);
         avlnode n=t.insert(pos,t.Root());
         t.setroot(n);

	}

	public void addPositions(MyLinkedList<Position> positions)
	{
         for(int i=0;i<positions.no_elements();i++)
         {
         	L.addelement(positions.elementatpos(i));
         	//t.Insert(positions.elementatpos(i));
         	avlnode n=t.insert(positions.elementatpos(i),t.Root());
            t.setroot(n);
         }
	}

	public MyLinkedList<Position> getAllPositionsForThisWord()
	{
		return L;
	}
	public avltree gettreeofpos()
	{
		return t;
	}
}
