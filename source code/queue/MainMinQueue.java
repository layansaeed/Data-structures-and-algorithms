package queue;

public class MainMinQueue {

	public static void main(String[] args) {
		MinQueue object=new MinQueue();
		
		
		object.insert(1, "Ahmad");
		object.insert(16, "Ali");
		object.insert(4, "Hani2");
		
		object.insert(20, "layan");
	
		object.insert(17, "Hani3");
		object.insert(2, "Hani1");
		
		object.insert(7, "Sali");
	
		
		
		//object.removeMin();
		
	//System.out.println(object.getMin());	
		object.print();
		
	}

}
