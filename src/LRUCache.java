import java.util.Scanner;

public class LRUCache {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		//create cache with max capacity
		System.out.print("Enter Cache maximum capcity: ");
		Cache lru = new Cache(scanner.nextInt());
		
		System.out.println(" Press 1 to add value, 2 to get value of key, 3 to delete, 4 to reset,5 to get all items in cache");
		
		
		while(true){
		String userInput = scanner.next();
		if(userInput.equals("1")){
			System.out.println("Enter key and value ");
			int key = scanner.nextInt();
			String value = scanner.next();
			lru.addValue(key,value );
			System.out.println(key+","+value+" added to cache");
		}
		else if(userInput.equals("2")){
			System.out.println("Enter key to fetch value");
			System.out.println("Value is "+lru.getKey(scanner.nextInt()));
		}
		else if(userInput.equals("3")){
			System.out.println("Enter key to delete");
			lru.delete(scanner.nextInt());
			System.out.println("Key is deleted");
		}
		else if(userInput.equals("4")){
			lru.resetLRU();
			System.out.println("LRU is empty now size is "+lru.getAll().size());
		}
		else if(userInput.equals("5")){
			if(lru.getAll().size()==0){
				System.out.println("Cache is empty");
			}
			for(int key: lru.getAll().keySet()){
				System.out.println("Key is "+key+"  value is "+lru.getKey(key));
			}
		}
		else{
			break;
		}
		}	
		scanner.close();
		
	}

}
