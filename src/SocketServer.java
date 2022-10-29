import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {


    public static void main(String args[]) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        Socket socket = null;
        serverSocket = new ServerSocket(1234);

        System.out.println("waiting for connection ");

        while (true){

            try{
                socket = serverSocket.accept();
                System.out.println("connection established");
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter =new BufferedWriter(outputStreamWriter);

                bufferedWriter.write("you are connected to one thread server  I hope you will enjoy" );
                bufferedWriter.newLine();
                bufferedWriter.flush();


                while (true){

                    String msgFromClient = bufferedReader.readLine();
                System.out.println("client : " + msgFromClient);
                bufferedWriter.write("msg received");
                bufferedWriter.newLine();
                bufferedWriter.flush();


                if(msgFromClient.equalsIgnoreCase("BYE")){
                    System.out.println("connection closed");
                    break;
                }

                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
