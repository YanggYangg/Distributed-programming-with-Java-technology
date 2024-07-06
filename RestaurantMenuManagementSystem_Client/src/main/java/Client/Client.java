package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import entity.Food;
import entity.Type;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		try(Socket socket = new Socket("DELL", 9999); Scanner sc = new Scanner(System.in);){
			ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			int choice = 0;
			
			while(true) {
				System.out.println("1.Add Food");
				
				choice = sc.nextInt();
				sc.nextLine();
				
				outObj.writeInt(choice);
				outObj.flush();
				
				switch(choice) {
				case 1:
					Food food = new Food("F114", "Soup", 50000, "Soup cua ga", false, Type.APPETIZER, 20, 5);
					outObj.writeObject(food);
					outObj.flush();
					
					boolean result = in.readBoolean();
					if (result) {
						System.out.println("Add food successfully");
					} else {
						System.out.println("Add food failed");
					}
					break;
				}
			}
		}
	}

}
