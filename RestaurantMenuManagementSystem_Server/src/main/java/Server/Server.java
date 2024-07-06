package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.FoodDao;
import dao.impl.FoodImpl;
import entity.Food;
import entity.Type;


public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(9999);) {

			System.out.println("Server started on port 9999");

			while (true) {
				Socket client = server.accept();

				System.out.println("Client connected");
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());

				Thread t = new Thread(new ClientHandle(client));
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	}


class ClientHandle implements Runnable{
	private Socket client;
	private FoodDao foodDao;
	public ClientHandle(Socket client) {
		this.client = client;
		foodDao = new FoodImpl();
	}

	@Override
	public void run() {
		try(ObjectInputStream in = new ObjectInputStream(client.getInputStream());
				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());){
			int choice = 0;
			choice = in.readInt();
			switch(choice) {
			case 1:
				Food food = (Food) in.readObject();
				boolean result = foodDao.addFood(food);
				out.writeBoolean(result);
				out.flush();
				break;
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}





