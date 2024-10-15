package shellScript;

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLClient {
    public static void main(String[] args) throws Exception {
        // Carregar o KeyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("client.jks"), "senhaDoKeystore".toCharArray());

        // Configurar o SSLContext
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Criar o cliente SSL
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        SSLSocket socket = (SSLSocket) socketFactory.createSocket("localhost", 8443);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Servidor: " + in.readLine());

        socket.close();
    }
}
