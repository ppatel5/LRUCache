import java.util.HashMap;

public class Cache {

	public int capacity;
	private HashMap<Integer, LinkedListNode> map = new HashMap<Integer, LinkedListNode>();
	private LinkedListNode head;
	private LinkedListNode tail;
	
	
	//defines Cache with max capacity
	public Cache(int size){
		capacity = size;
	}
	
	/*
	fetches value from cache
	Also updates Linkedlist, sets node in fron to mark it as recently used
	*/
	public String getKey(int key){
		LinkedListNode item = map.get(key);
		if(item==null)
			return null;
		
		if(item != head){
			removeItem(item);
			placeInFront(item);
		}
	return item.value;
	}
	
	
	//deleted value from linkedlist
	private void removeItem(LinkedListNode item){
		if(item==null){
			return;
		}		
		if(item.prev!=null){
			item.prev.next = item.next;
		}
		if(item.next!=null){
			item.next.prev = item.prev;
		}
		if(item == head){
			head=item.next;
		}
		if(item == tail){
			tail=item.prev;
		}	
		
	}
	
	//places node in from of linked list
	private void placeInFront(LinkedListNode item){
		if(head==null){
			head=item;
			tail=item;
		}
		else{
			head.prev =item;
			item.next=head;
			head=item;
		}
	}
	
	//deletes value from both linkedlist and map
	public boolean delete(int key){
		LinkedListNode item = map.get(key);
		removeItem(item);
		map.remove(key);
		return true;
	}
	
	/*
	   add new value to the cache, adds it to front of linkedlist, 
	   to mark as recently used.
	   if key already exists, delete key and add new record.
	   if capacity exceeds delete least recently used record, in our case
	   it would be last node in Linkedlist.
	*/
	public void addValue(int key, String value){
		delete(key);
		if(map.size() >= capacity && tail !=null){
			delete(tail.key);
		}
		
		LinkedListNode item = new LinkedListNode(key,value);
		placeInFront(item);
		map.put(key, item);
	}
	
	//delete all records from cache
	public void resetLRU(){
		head=null;
		tail=null;
		map.clear();		
	}
	
	//fetches all values from cache
	public HashMap<Integer,LinkedListNode> getAll(){
		return map;
	}
	
}
