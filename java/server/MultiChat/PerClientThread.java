import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClientThread extends Thread {
	//동기화 가능한 리스트 객체만들어주는 collections~
	//List는 arraylist의 부모클래스...들어오고 나가고 등 동시에 처리하려고..
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	
	Socket socket;
	PrintWriter writer;
	
	PerClientThread(Socket socket){
		this.socket = socket;
		try {
		//소켓에서 수신하는게 바이트단위라서 프린트라이터로 문자단위로 만들어줌
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine();
			sendAll("#" + name + "님이 들어오셨습니다");
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				sendAll(name + ">" + str);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			list.remove(writer);
			sendAll("#" + name + "님이 나가셨습니다");
			try {
				socket.close();
			}
			catch (Exception ignored) {
				
			}
		}
	}
	
	private void sendAll(String str) {
		for (PrintWriter writer : list) {
		//송신하는 데이터 타입은 문자열
			writer.println(str);
			writer.flush();
		}
	}

}