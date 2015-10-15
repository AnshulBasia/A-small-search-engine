public class avltree
{
	public avlnode root;
	public void setroot(avlnode k)
	{
		root=k;
	}
	public avltree()
	{
		root=null;
	}
	public avlnode Root()
	{
		return root;
	}
	public Boolean isempty()
	{
		if(root==null){return true;}
		return false;
	}
	public int height(avlnode n)
    {
    	if(n==null){return 0;}
    	return n.Height();
    }
    public int balance(avlnode j)
    {
    	return height(j.left)-height(j.right);
    }

    public avlnode rightrotate(avlnode f)
    {
    	avlnode x=f.left;
    	if(x==null){System.out.println("fault "+f.p.getWordIndex());}
    	avlnode y=x.right;
    	x.right=f;
    	f.left=y;
    	f.height=Math.max(height(f.right),height(f.left))+1;
    	x.height=Math.max(height(x.right),height(x.left))+1;
    	return x;

    }
    public avlnode leftrotate(avlnode o)
    {
    	avlnode x=o.right;
    	avlnode y=x.left;
    	x.left=o;
    	o.right=y;
    	o.height=Math.max(height(o.right),height(o.left))+1;
    	x.height=Math.max(height(x.right),height(x.left))+1;
    	return x;
    }
    
	

	public avlnode insert(Position a, avlnode r)
	{
       if(r==null)
       {
       	  r=new avlnode(a);
       	  //System.out.println("inserting");
       	  return r;
       }

       else
       {
           if(a.getWordIndex()>=r.p.getWordIndex())
           {
           	  r.right=insert(a,r.right);
           }
           else
           {
           	  r.left=insert(a,r.left);
           }
           	  
           r.height=Math.max(height(r.left),height(r.right))+1;
           int bal=balance(r);

           if(bal>1)
           {
           		if(a.getWordIndex()<r.left.p.getWordIndex())
           		{
           			return rightrotate(r);
           		}
           		else
           		{
                   r.left=leftrotate(r.left);
                   return rightrotate(r);
           		}	

           }
           if(bal<-1)
           {
           	 if(a.getWordIndex()>r.right.p.getWordIndex())
           	  {
           		return leftrotate(r);
              }
              else
              {
              	
              	if(a.getWordIndex()==r.right.p.getWordIndex())
              	{
              		return leftrotate(r);
              	}
              	r.right=rightrotate(r.right);
              	return leftrotate(r);
              }
           }
           return r;
       }
	}

	public void preOrder(avlnode root)
    {
      if(root!= null)
      {
        System.out.println(root.p.poswithoutconnector());
        preOrder(root.left);
        preOrder(root.right);
      }
    }

    public Boolean search(Position b, avlnode r)
    {
    	 
    	if(r==null)
    	{
    		
    		return false;
    	}
    	if(b.poswithoutconnector()<r.p.poswithoutconnector())
    	{
    		
    		search(b,r.left);
    	}
    	if(b.poswithoutconnector()>r.p.poswithoutconnector())
    	{
    		
    		search(b,r.right);
    	}
    	if(b.poswithoutconnector()==r.p.poswithoutconnector())
    	{
    		
    		if(b.getPageEntry().nameofpage().equals(r.p.getPageEntry().nameofpage()))
    		{
    			
    			return true;
    		}
    		search(b,r.right);
    	}
    	return false;
    

    }




}
