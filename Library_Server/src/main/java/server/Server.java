package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import dao.ChiTietMuonSachDao;
import dao.DocGiaDao;
import dao.SachDao;
import dao.impl.ChiTietMuonSachImpl;
import dao.impl.DocGiaImpl;
import dao.impl.SachImpl;
import entity.DocGia;
import entity.Sach;


public class Server {
	public static void main(String[] args) {

		try (ServerSocket server = new ServerSocket(4451);) {

			System.out.println("Server started on port 4451");

			while (true) {
				Socket client = server.accept();

				System.out.println("Client connected");
				System.out.println("Client IP: " + client.getInetAddress().getHostName());
				System.out.println("Client Port: " + client.getPort());

				Thread t = new Thread(new ClientHandler(client));
				t.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class ClientHandler implements Runnable {
	private Socket socket;
	private DocGiaDao DocGiaDao;
	private SachDao SachDao;
	private ChiTietMuonSachDao ChiTietMuonSachDao;

	public ClientHandler(Socket client) {
		super();
		this.socket = client;
		this.DocGiaDao = new DocGiaImpl();
		this.SachDao = new SachImpl();
		this.ChiTietMuonSachDao = new ChiTietMuonSachImpl();

	}

	@Override
	public void run() {
		try {
			ObjectInputStream inObj = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());

			int choice = 0;

			while (true) {
				choice = inObj.readInt();
				switch (choice) {
				case 1:
					DocGia DocGia = (DocGia) inObj.readObject();
					Sach Sach = (Sach) inObj.readObject();
					Boolean result = ChiTietMuonSachDao.themChiTietMuonSach(DocGia, Sach);
					outObj.writeBoolean(result);
					outObj.flush();
					break;
				case 2:
					Sach Sach1 = (Sach) inObj.readObject();
					Boolean result1 = SachDao.updateSach(Sach1);
					outObj.writeBoolean(result1);

					outObj.flush();
					break;
				case 3:
					String tuaSach = (String) inObj.readObject();
					List<DocGia> dsDocGia = DocGiaDao.getDSDocGia1(tuaSach);
					outObj.writeObject(dsDocGia);
					outObj.flush();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

}
