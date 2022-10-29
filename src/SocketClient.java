import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class SocketClient {

    public static void main(String [] args) throws IOException, ClassNotFoundException {


       Socket socket = null;
       InputStreamReader inputStreamReader = null;
       OutputStreamWriter outputStreamWriter = null;
       BufferedReader bufferedReader = null;
       BufferedWriter bufferedWriter = null;


       try{

           socket = new Socket("localhost",1234);

           inputStreamReader = new InputStreamReader(socket.getInputStream());
           outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

           bufferedReader = new BufferedReader(inputStreamReader);
           bufferedWriter =new BufferedWriter(outputStreamWriter);


           Scanner scanner = new Scanner(System.in);
           System.out.println("server: " + bufferedReader.readLine());
           while(true){


               System.out.println("type your message : \t");
               String msgToSend = scanner.nextLine();
               bufferedWriter.write(msgToSend);
               bufferedWriter.newLine();
               bufferedWriter.flush();

               System.out.println(bufferedReader.readLine());

               if(msgToSend.equalsIgnoreCase("BYE"))
                   break;
           }

        }catch (IOException e ){
           e.printStackTrace();
       }
       finally{
           try{

               if(socket != null)
                   socket.close();
               if(inputStreamReader != null)
                   inputStreamReader.close();
               if(outputStreamWriter != null)
                   outputStreamWriter.close();
               if(bufferedReader !=null)
                   bufferedReader.close();
               if(bufferedWriter != null)
                   bufferedWriter.close();
           }catch (IOException e){
               e.printStackTrace();
           }
       }





    }
}
