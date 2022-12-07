import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SqServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }
    private static void serverClient(Socket socket) throws IOException {
        System.out.println("Сервисный клиент" + socket.getInetAddress());
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        int request;
        do {
            request = inputStream.read();
            System.out.println("Результат:" + request);
            outputStream.write(request + 1);

        } while (request < 9);
        outputStream.flush();
    }
}