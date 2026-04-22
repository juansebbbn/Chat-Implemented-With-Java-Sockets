import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente extends Thread {
    private int id;
    private Socket connection;
    private HashMap<Integer, ArrayList<String>> mensajes_clave_valor;

    public Cliente(int id) {
        this.id = id;
        this.mensajes_clave_valor = new HashMap<>();
    }

    @Override
    public void run() {
        try {
            establecer_conexion();
            recibirMensaje();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void establecer_conexion() throws UnknownHostException, IOException {
        this.connection = new Socket("localhost", 8081);

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());

        out.writeInt(id);

        out.flush();
    }

    public void enviarMensaje(String msg, int receptor) throws IOException {

        DataOutputStream out = new DataOutputStream(connection.getOutputStream());

        out.writeInt(receptor);

        out.writeBytes(msg + "\n");

        out.flush();
    }

    public void recibirMensaje() throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while (true) {

            String mensaje = "";

            while ((mensaje = entrada.readLine()) != null) {
                System.out.println("Recibido: " + mensaje);

                char idMandatario = mensaje.charAt(0);
                int idMandatarioToInt = (int) idMandatario;

                System.out.println(idMandatarioToInt);

                if (!mensajes_clave_valor.containsKey(idMandatarioToInt)) {
                    ArrayList<String> mensajes = new ArrayList<>();
                    mensajes.add(mensaje.substring(1, mensaje.length() - 1));

                    mensajes_clave_valor.put(idMandatarioToInt, mensajes);
                } else {
                    ArrayList<String> mensajes = mensajes_clave_valor.get(idMandatarioToInt);

                    mensajes.add(mensaje);

                    mensajes_clave_valor.put(idMandatarioToInt, mensajes);
                }

                for (Integer clave : this.mensajes_clave_valor.keySet()) {
                    ArrayList<String> mensajes = this.mensajes_clave_valor.get(clave);
                    System.out.println("Los mensajes del cliente " + clave + " Hacia el cliente 2 son ");

                    for (String string : mensajes) {
                        System.out.println(string);
                    }
                    
                }

            }

        }
    }

    public HashMap<Integer, ArrayList<String>> getMensajes_clave_valor() {
        return mensajes_clave_valor;
    }

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        Cliente cliente1 = new Cliente(1);
        Cliente cliente2 = new Cliente(2);

        cliente1.start();
        cliente2.start();

        Thread.sleep(1000);

        cliente1.enviarMensaje("Pepe", 2);

    }

}
