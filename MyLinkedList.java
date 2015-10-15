import java.util.Vector;

public class MyLinkedList<E>
{    
	public Node<E> head;
	public int num_elements;

	public MyLinkedList()
	{
		num_elements=0;
		head=new Node<E>();
	}
	public Node<E> head()
	{ 
		return head;
	}

	public int no_elements()
	{
		return num_elements;
	}

	public void addelement(E el)
	{    
		
		Node<E> n=new Node<E>();
		
		
			
		
		n.data=el;
		n.next=head;
		head=n;

		
		
		num_elements++;
	}


	public void deleteelement(E el)
	{
		Node<E> n=head;
		if(head.data()==el)
		{
			head = head.next;
			num_elements--;
			return;
		}
		else
		{   while(n.next!=null)
			{
				if(n.next.data==el)
			    {
			       n.next=n.next.next;
			       num_elements--;
 				   return;
			    }
			    else
			    {
			    	n=n.next;
			    }
			}
			
		}

		System.out.println("element you ar etrying to delete is not in the list");
	}

	


	public E elementatpos(int i)
	{
		if(i>=num_elements||i<0)
		{
			System.out.println("wrong index intered");
			return null;
		}

		Node<E> n=head;
		for(int j=0;j<i;j++)
		{
			n=n.next;
		}

		return n.data();
	}




}
