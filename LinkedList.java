package lordhelpme;

public class LinkedList{
	private String name;
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList(String n){
		name = n;
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addNode(String label){
		Node newNode = new Node(label);
		
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		size++;
	}
	
	public String getName(){
		return name;
	}
	
	
	
public static class Node {
	private static String nlabel;
	private Node nextNode;
	private Node prevNode;
	
	public Node(String label){
		nlabel = label;
		nextNode = null;
		prevNode = null;
	}
	
	public String getLabel(){
		return nlabel;
	}
	
	public void setLabel(String s){
		nlabel = s;
	}
	
	public Node getNext(){
		return nextNode;
	}
	
	public Node getPrev(){
		return prevNode;
	}
	
	public void setNext(Node n){
		nextNode = n;
	}
	
	public void setPrev(Node n){
		prevNode = n;
	}
}

}