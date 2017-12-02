import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TranslationServer{
 private static ServerSocket serverSocket;

  public static void main(String[] args){
    try {
      serverSocket = new ServerSocket(8080);
    } catch (IOException e) {
      System.out.println(e);
    }
    while (true) {
      try {
        Socket client = serverSocket.accept();
        BufferedReader InputBuffer = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        while(true) {
          try {
            String country = InputBuffer.readLine();
            while(true) {
              try {
                String phrase = InputBuffer.readLine();
                //TRANSLATION CODE HERE
                String translation = country + phrase;
                //TRANSLATION CODE
                PrintWriter pw = new PrintWriter(client.getOutputStream());
                pw.write(translation);
                client.close();
              } catch (IOException e){}
            }
          } catch (IOException e){}
        }
      }
      catch (IOException e) {
        System.out.println(e);
      }
    }

  }
}

