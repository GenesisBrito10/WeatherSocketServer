import java.io.*;
import java.net.*;

class Cliente {
    public static void main(String[] args) {
        try {

            String serverName = "192.168.1.31";
            int port = 8722;
            Socket socket = new Socket(serverName, port);

            System.out.println("Conetado no server: " + serverName);
            Client(socket);
            
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro ao conectar no servidor.");
            e.printStackTrace();
        }
    }

    private static void tempo() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    private static void Client(Socket socket) {
        try {
            BufferedReader msgFromUser = new BufferedReader(new InputStreamReader(System.in)); //le cliente
            PrintStream toServer = new PrintStream(socket.getOutputStream()); // escreve dados servidor
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream())); //le dados servidor

            String userInput;
            System.out.print("Digite seu nome: ");
            String name = msgFromUser.readLine();
            System.out.print("\nBem vindo " + name + ", ao Servidor de Previsão climática das cidades brasileiras."
                    + " \n");
            tempo();
            

            do {
                System.out.print(
                        "\n\n\nDigite o que deseja\n\n1-Temperatura -> #temp#Cidade#/temp#\n\n2-Horas -> #horas#Cidade#/horas#\n\n3-Temperatura Máxima de hoje-> #max_dia#Cidade#/max_dia#\n\n4-Temperatura Mínima de hoje -> #min_dia#Cidade#/min_dia#\n\n5-Dia/noite da cidade -> #periodo#Cidade#/periodo#\n\n6-Umidade -> #umid#Cidade #/umid#\n\n7-nebulosidade -> #neb#Cidade#/neb#\n\n8-Volume de chuva -> #chuva#Cidade#/chuva#\n\n9-Velocidade do vento -> #vel_vent#Cidade#/vel_vent#\n\n10-Horário nascer do sol -> #nasc_sol#Cidade#/nasc_sol#\n\n11-Fase da Lua -> #lua#Cidade#/lua#\n\n12-Fuso horário -> #fuso_hora#Cidade#/fuso_hora#\n\n13-Direção do vento -> #dir_vento#Cidade#/dir_vento#\n\n14-Horário pôr do sol -> #por_sol#Cidade#/por_sol#\n\n15-Previsão de ontem -> #prev_ant#Cidade#/prev_ant#\n\n16-Condição do clima de hoje-> #clima#Cidade#/clima#\n\n17-Temperatura Mínima de amanhã -> #min_amanha#Cidade#/min_amanha#\n\n18-Temperatura Máxima de amanhã -> #max_amanha#Cidade#/max_amanha#\n\n19-Condição do clima de amanhã-> #clima_amanha#Cidade#/clima_amanha#\n\n20-Sair do servidor -> #sair#Sair#/sair#\n\n");
                System.out.flush();
                System.out.println("------------------------------");
                System.out.println("Digite o comando abaixo: ");
                userInput = msgFromUser.readLine();

                toServer.println(userInput);

                String responseFromServer = fromServer.readLine();
                

                if (responseFromServer.equals("sair")) {
                    break;
                }
                System.out.println("\n----------------------------------------------------");
                System.out.println(responseFromServer);
                System.out.println("------------------------------------------------------");
                tempo();


            } while (!userInput.equals("sair"));
        } catch (IOException e) {
            System.out.println("Conexão Fechada pelo Cliente: " + socket.getInetAddress());
        }
    }
}
