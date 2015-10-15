public class avlnode
{
	public avlnode right;
	public avlnode left;
	public Position p;
	public int height ;
	public avlnode(Position s)
	{
		right=null;
		left=null;
		p=new Position(s.getPageEntry(),s.getWordIndex(),s.poswithoutconnector());
		height=1;
	}
	public int Height()
	{
		return height;
	}
	public Position getpos()
	{
		return p;
	}
	

}
