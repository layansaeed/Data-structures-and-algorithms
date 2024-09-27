package Plaindrome;


public class LinkedStack {

	private class Node {

		char data;
		Node next;

		public Node(char data) {
			this.data=data;
		}

	}
	
	 Node top=null;
	
	void push(char data)
	{
		Node newNode= new Node(data);
		if (top== null)
		{
			top=newNode;
		}
		
		else
		{
			newNode.next=top;
			top=newNode;
		}
				
	}
	boolean isEmpty()
	{
		return top==null;
	}
	
	void print() //O(n)
	{
		Node i=top;
		while(i != null)
		{
			System.out.println(i.data);
			i=i.next;
		}
	}
	
	char pop()
	{
		char element;
		if(isEmpty())
		{
		throw new IllegalArgumentException();
		}
		
		else
		{
			element=top.data;
		Node delete=top;
		top=top.next;
		delete.next=null;
		}
		return element;
	}
	
	void push_from_string(String data)
	{
		
		
		for(int i=0; i<data.length();i++)
		{
			Node newNode = new Node(data.charAt(i));
			
			if(top==null)
			{
				top=newNode;
			}
			else
			{
				newNode.next=top;
				top=newNode;
			}
		}
	}
	
	String pop_all()
	{
		String result = "";
		
		while(top!=null)
		{
			result+=top.data;
			top=top.next;
		}
		return result;
	}
	
	char top()
	{
		return top.data;
	}
	
}
