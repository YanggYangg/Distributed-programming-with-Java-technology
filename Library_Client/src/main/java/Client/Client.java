package Client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entity.DocGia;
import entity.Sach;

public class Client {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (Socket socket = new Socket("DELL", 4451); Scanner sc = new Scanner(System.in);) {

			ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			int choice = 0;

			while (true) {
				System.out.println("1. Them chi tiet muon sach");
				System.out.println("2. Update chi tiet muon sach");
				System.out.println("3. getDsSachMuonTheoTenSach");
				choice = sc.nextInt();
				sc.nextLine(); // Consume newline character
				outObj.writeInt(choice);
				outObj.flush();
				switch (choice) {
				case 1:
					Sach sach = new Sach("S0020", "Java nâng cao", "Quỳnh Giang", 2024, 300000);
					DocGia docGia = new DocGia("DG0020", "Quỳnh Giang", "123456789", "Giang123@gmail.com");
					outObj.writeObject(docGia);
					outObj.writeObject(sach);
					outObj.flush();
					Boolean result = in.readBoolean();
					if (result) {
						System.out.println("Them thanh cong");
					} else {
						System.out.println("Them that bai");
					}

					break;

				case 2:
					Sach sach1 = new Sach("S0029", "Java nâng cao", "Quỳnh Giang", 2024, 600000);

					outObj.writeObject(sach1);
					outObj.flush();
					Boolean result1 = in.readBoolean();
					if (result1) {
						System.out.println("Update thanh cong");
					} else {
						System.out.println("Update that bai");
					}

					break;
				case 3:
					String tưaSach = "AV";
					outObj.writeObject(tưaSach);
					outObj.flush();
					List<DocGia> dsDocGia = (List<DocGia>) in.readObject();
					dsDocGia.forEach(System.out::println);
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
