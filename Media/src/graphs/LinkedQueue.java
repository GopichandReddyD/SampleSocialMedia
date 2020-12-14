package graphs;

/**
 * @author Tajinder Sharma
 * group: code burgers
 */

public final class LinkedQueue<T> implements QueueInterface<T>
{
	private Node firstNode;
	private Node lastNode;
	
	public LinkedQueue() 
	{
		firstNode = null;
		lastNode = null;
	}
	
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry);
		
		if(isEmpty())
		{
			firstNode = newNode;
		}
		else
			lastNode.setNextNode(newNode); 
		
		lastNode = newNode; 
	}
	
	public T dequeue()
	{
		T removed = getFront(); 
		
		if(isEmpty())
		{
			lastNode = null; 
		}
		else 
		{
			firstNode.setData(null); 
			firstNode = firstNode.getNextNode(); 
		}
			
		return removed; 
	}
	
	public T getFront()
	{
		T front = null; 
		
		if (isEmpty()) 
		{
			throw new EmptyQueueException("The queue is empty!"); 
		}
		else
			front = firstNode.getData(); 
		
		return front;
	}
	
	public boolean isEmpty()
	{
		if (firstNode == null) 
				return true; 
		else
			return false;
	}

	public void clear()
	{
		while(!isEmpty())
		{
			dequeue(); 
		}
	}
	
	class Node
	{
		private T data; 
        private Node next; 

        private Node(T dataPortion) {
            this(dataPortion, null);
        } 

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } 

        private T getData() {
            return data;
        } 

        private void setData(T newData) {
            data = newData;
        } 

        private Node getNextNode() {
            return next;
        } 

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
     }
	} 
