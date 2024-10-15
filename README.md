

# SSL Server-Client Application with Java and KeyStore

Este projeto demonstra uma comunicação segura SSL/TLS entre um servidor e um cliente implementados em Java, utilizando Java KeyStore (JKS) para gerenciar certificados e chaves privadas.

## Estrutura do Projeto

O projeto contém as classes Java para o servidor e o cliente, além dos arquivos JKS que armazenam os certificados. A estrutura é organizada para facilitar o entendimento e a implementação.

## Guia Passo a Passo

### Pré-requisitos

Antes de começar, você precisa ter:
- Java Development Kit (JDK) instalado (versão 8 ou superior).
- OpenSSL instalado para gerar certificados e chaves.

### Passo 1: Gerar o Certificado e a Chave do Servidor

Primeiro, você deve gerar um certificado autoassinado e uma chave privada para o servidor usando o OpenSSL. Isso cria os arquivos necessários para configurar a segurança do servidor.

### Passo 2: Converter Certificado e Chave para Formato PKCS12

Em seguida, converta o certificado e a chave gerados para o formato PKCS12, que é um formato mais compatível com o Java KeyStore. Você precisará definir uma senha para proteger este arquivo.

### Passo 3: Importar o PKCS12 no Java KeyStore

Depois de converter para PKCS12, importe esse arquivo para criar o KeyStore no formato JKS, que será usado pelo servidor Java para carregar o certificado e a chave privada. Use a mesma senha definida anteriormente.

### Passo 4: Gerar o KeyStore do Cliente

Agora, crie um KeyStore separado para o cliente. Este arquivo armazenará as informações necessárias para que o cliente se conecte ao servidor de forma segura.

### Passo 5: Colocar os Arquivos KeyStore no Projeto

Coloque os arquivos JKS gerados (`server.jks` e `client.jks`) na raiz do diretório do projeto ou em um local onde o código Java possa acessá-los.

### Passo 6: Configurar e Executar o Servidor SSL

Abra a classe do servidor no seu IDE e ajuste o caminho para o arquivo KeyStore e a senha usada durante sua criação. Em seguida, execute o servidor para que ele comece a escutar conexões seguras.

### Passo 7: Configurar e Executar o Cliente SSL

Faça o mesmo com a classe do cliente: ajuste o caminho para o KeyStore do cliente e a senha definida. Depois, execute o cliente para se conectar ao servidor e estabelecer a comunicação segura.

### Passo 8: Testar a Comunicação Segura

Com o servidor em execução, inicie o cliente e verifique se a conexão é estabelecida corretamente. Uma mensagem indicará se a comunicação segura foi configurada com sucesso.

## Estrutura do Projeto

```bash
shellScript/
├── src/
│   ├── shellScript/
│   │   ├── SSLServer.java        # Java SSL Server
│   │   └── SSLClient.java        # Java SSL Client
├── resources/
│   ├── gerar_certificado.bat     # Script para gerar certificados e chaves usando OpenSSL
│   ├── server.crt                # Certificado do servidor
│   ├── server.key                # Chave privada do servidor
│   └── server.p12                # Arquivo PKCS12 do servidor
├── server.jks                    # Java KeyStore para o servidor
├── client.jks                    # Java KeyStore para o cliente
└── README.md                     # Documentação do projeto
