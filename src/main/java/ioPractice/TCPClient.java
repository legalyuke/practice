package ioPractice;

import java.io.*;
import java.net.Socket;

/**
 * @author liyuke
 * @date 2021-06-11 8:29
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;
//        BufferedReader inFromUer = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("127.0.0.1", 8986);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        sentence = inFromUer.readLine();
        outToServer.writeBytes("GET /test/hello HTTP/1.1" + '\n');
        outToServer.writeBytes("Host: 127.0.0.1:8986" + '\n');
        outToServer.writeBytes("Connection: close" + '\n');
        outToServer.writeBytes("User-agent: Mozilla/4.0" + '\n');
        while ((modifiedSentence = inFromServer.readLine()) != null) {
            System.out.println("FROM SERVER:" + modifiedSentence);
        }
        clientSocket.close();

    }
}
