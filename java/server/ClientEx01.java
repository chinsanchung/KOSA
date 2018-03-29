

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientEx01 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
		//소켓 객체 생성
			socket = new Socket( "192.168.3.217", 9000);
        //데이터 송수신에 사용할 입/출력 스트림 객체
			InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            String str = "Hello, Server";
       //write와 read 메소드 호출해서 데이터 송/수신
            out.write(str.getBytes());
            byte arr[] = new byte[100];
            in.read(arr);
            System.out.println(new String(arr));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { 
            //소켓 닫은 후 서버소켓도 닫아야함
                socket.close(); 
            } 
            catch (Exception e) {
            }
        }
    }
}