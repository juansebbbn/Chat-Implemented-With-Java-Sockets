
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Map<Integer, Socket> clientesConectados = new HashMap<>();

    public static void acceptConnections() throws IOException {
        try (ServerSocket svSock = new ServerSocket(8081)) {
            System.out.println("SV escuchando en puerto 8081");

            while (true) {
                Socket socket = svSock.accept();

                Thread clientThread = new Thread(() -> {
                    try {
                        DataInputStream entrada = new DataInputStream(socket.getInputStream());
                        int miId = entrada.readInt();
                        clientesConectados.put(miId, socket);

                        readData(socket, miId, entrada);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                });
                clientThread.start();
            }
        }
    }

    public static void readData(Socket socket, int idMandatario, DataInputStream entrada) throws IOException {
       
        while (true) {

            int idReceptor = entrada.readInt();
            String texto = entrada.readLine();

            System.out.println("Mensaje de " + idMandatario + " Para " + idReceptor + ": " + texto);

            Socket socketReceptor = clientesConectados.get(idReceptor);

            PrintWriter out = new PrintWriter(socketReceptor.getOutputStream(), true);

            char idMandatarioToChar = (char) idMandatario;

            String mensaje = idMandatarioToChar + texto;

            out.println(mensaje);
            System.out.println("Mensaje enviado: " + mensaje);
            
        } 
    }

    public static void main(String[] args) throws IOException {
        acceptConnections();
    }

}