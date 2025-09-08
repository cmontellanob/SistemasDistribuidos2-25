package simplechat;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class SimpleChat extends ReceiverAdapter {

    JChannel channel; // Canal para el grupo de comunicación
    private String user_name; // atributo para el usuario
    final List<String> state = new LinkedList<>();

    public SimpleChat(String user_name) {
        this.user_name = user_name;
    }

    public void viewAccepted(View new_view) {
        System.out.println("Vista del grupo actualizada: " + new_view);
    }

    public void receive(Message msg) {
        String line = msg.getSrc() + ": " + msg.getObject();
        System.out.println(line);
        synchronized (state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    public void start() throws Exception {
        // Crear el canal y conectar al grupo
        channel = new JChannel();  // Utiliza UDP por defecto
        channel.setReceiver(this); // El objeto que recibirá los mensajes
        channel.connect("ChatCluster");  // Conecta al grupo ChatCluster
        channel.getState(null, 10000); // Opcional, para obtener estado compartido si lo hay
        eventLoop(); // Comienza a leer y enviar mensajes
        channel.close(); // Cierra el canal cuando se termine
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("> ");
                System.out.flush();
                String line = in.readLine().toLowerCase();
                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break; //finaliza el bucle
                }
                line = "[" + user_name + "] " + line;
                // Envía el mensaje al grupo
                Message msg = new Message(null, line); //crea mensaje
                channel.send(msg);  // envia al grupo
            } catch (Exception e) {
            }
        }
    }

}
