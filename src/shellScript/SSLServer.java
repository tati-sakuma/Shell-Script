package shellScript;
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLServer {
    public static void main(String[] args) throws Exception {
        // Carregar o KeyStore
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("server.jks"), "senhaDoKeystore".toCharArray());

        // Configurar o SSLContext
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "senhaDaChave".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, null);

        // Criar o servidor SSL
        SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(8443);

        System.out.println("Servidor SSL iniciado...");

        while (true) {
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            out.println("Conexão segura estabelecida!");
            sslSocket.close();
        }
    }
}
