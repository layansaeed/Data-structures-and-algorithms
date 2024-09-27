package queue;



public class MinQueue {

	private class Node                         //create Node class, we used it when we want to insert value
	{
		int priority;
		String data;
		Node next;
		
		Node(int priority,String data)          //the constructor receive parameter because when we create node we off_course will insert data
		{
			this.priority=priority;
			this.data=data;
		}
	}
	
	Node head=null; //front indicate on first value in linkedList

	Node rear=null; //rear indicate on last value in LinkedList
	
	boolean isEmpty()
	{
		if(head==null)
			return true;
		
		return false;
			
	}
	
	void insert(int priority,String data)
	{
		Node newNode=new Node(priority,data);
		
		if(isEmpty())
		{
			head=newNode;
			rear=newNode;
		}
		
		else
		{
			
			if(head.priority>newNode.priority) //insert in the front of the queue
			{
				newNode.next=head;
				head=newNode;
			}
			
			else if(rear.priority<newNode.priority) //insert in the rear of the queue
			{
				rear.next=newNode;
				rear=newNode;
			}
			
			else
			{
					Node i=head;
					
					while(i.next!=null && i.next.priority<=newNode.priority)
					{
						
						i=i.next;
					}
					
					newNode.next=i.next;
					i.next=newNode;
			}
		}
	}
	
	void removeMin()
	{
		if(isEmpty())
		{
			//throw new IllegalArgumentException();
			System.out.println("the queue is empty");
		}
		
		else if(head==rear)
		{
			head=rear=null;
		}
		
		else
		{
			Node delete=head;
			head=head.next;
			delete.next=null;
		}
	}
	
	String getMin()
	{
		return head.data;
	}
	
	void print()
	{
		System.out.print("[");
		Node i=head;
		while(i != null) 
		{
			System.out.print(i.data);
			System.out.print(",");
			
			i=i.next;
		}
		System.out.println("]");
			
	}
}
