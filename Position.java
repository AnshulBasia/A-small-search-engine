public class Position
{
	public PageEntry p;
	public int position;
	public int spl;

	public Position(PageEntry x,int y,int z)
	{
       p=x;
       position=y;
       spl=z;
	}

	public PageEntry getPageEntry()
	{
		return p;
	}

	public int getWordIndex()
	{
		return position;
	}

	public int poswithoutconnector()
	{
		return spl;
	}
}
