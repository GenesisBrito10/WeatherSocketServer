import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Servidor {
    public static void main(String args[]) throws Exception {

        int port = 8722;
        try {
            System.out.println("Aguardando conexão...");
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Servidor iniciado na porta " + port + ".");

            while (true) {
                Socket socket = ss.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());

                Thread cliente = new Multicliente(socket);
                cliente.start();
            }
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o servidor.");
            e.printStackTrace();
        }

    }
}

class Multicliente extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintStream outputStream;

    public Multicliente(Socket socket) {
        this.socket = socket;
    }

    private static String extrairprotocolo(String input) {
        
        Pattern pattern = Pattern.compile("#([a-z_]+)#(.+?)#/([a-z_]+)#");
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            String inicio = matcher.group(1);
            String cidade = matcher.group(2);
            String fim = matcher.group(3);

            if (!inicio.equals(fim)) {
                return "Protocolo Incorreto, Digite Novamente!";
            } else {
                if (inicio.equals("temp")) {
                    String temperatura = Api.getTemperature(cidade);
                    return "A temperatura em " + cidade + " é de : " + temperatura + "°C";
                }
                else if(inicio.equals("horas")){
                    String horas = Api.getHoras(cidade);
                    return"Horário da última atualização em " + cidade + " " + horas;
                }
                else if(inicio.equals("clima")){
                    String clima = Api.getClima(cidade);
                    return"A cidade de " + cidade + " hoje está com o clima de " + clima;                   
                }
                else if(inicio.equals("clima_amanha")){
                    String clima_amanha = Api.getClimaAmanha(cidade);
                    return"A cidade de " + cidade + " amanhã estará com " + clima_amanha;
                }
                else if(inicio.equals("periodo")){
                    String periodo = Api.getPeriodoDia(cidade);
                    return "O periodo atual de " + cidade + " é "+periodo;
                }
                else if(inicio.equals("umid")){
                    String umid = Api.getUmidade(cidade);
                    return "A umidade de " + cidade + " é de " + umid +"%";
                    
                }
                else if(inicio.equals("neb")){
                    String neb = Api.getNebulosidade(cidade);
                    return " O percentual de neblina de "+ cidade +" é de " + neb + "%";
                }
                else if(inicio.equals("chuva")){
                    String chuva = Api.getChuva(cidade);
                    return "O Volume de chuva para " + cidade + " é " + chuva + "mm";
                    
                }
                else if(inicio.equals("vel_vent")){
                    String vel_vento = Api.getVelVento(cidade);
                    return "A velocidade do vento em " + cidade + " é de "+ vel_vento;
                }
                else if(inicio.equals("nasc_sol")){
                    String nasc_sol = Api.getNascerSol(cidade);
                    return "O Horário do nascer do sol para " + cidade + " é " + nasc_sol;
                    
                }
                else if(inicio.equals("lua")){
                    String fase = Api.getFaseLua(cidade);
                    return "A fase da Lua em " + cidade + " é "+ fase;
                }
                else if(inicio.equals("fuso_hora")){
                    String fuso_hor = Api.getFusoHorario(cidade);
                    return "O Fuso Horário de " + cidade + " é " + fuso_hor;
                    
                }
                else if(inicio.equals("dir_vento")){
                    String dir_vento = Api.getDirecaoVento(cidade);
                    return "A direção do vento em " + cidade + " é " + dir_vento;
                }
                else if(inicio.equals("por_sol")){
                    String por_sol = Api.getPorSol(cidade);
                    return "O Horário do pôr do sol para " + cidade + " é " + por_sol;                    
                }
                
                else if(inicio.equals("max_dia")){
                    String max = Api.getTempMaxHoje(cidade);
                    return "A temperatura máxima de hoje é de "+ max+ "°";
                }
                else if(inicio.equals("min_dia")){
                    String min = Api.getTempMinHoje(cidade);
                    return "A temperatura mínima de hoje é de "+ min+ "°";
                }
                else if(inicio.equals("max_amanha")){
                    String max = Api.getTempMaxAmanha(cidade);
                    return "A temperatura máxima de amanhã vai ser de "+ max+ "°";
                }
                else if(inicio.equals("min_amanha")){
                    String min = Api.getTempMinAmanha(cidade);
                    return "A temperatura mínima de amanhã vai ser de "+ min+ "°";
                }
                else if(inicio.equals("sair")){
                    return "sair";
                }
            }
        }

        return "Protocolo Incorreto, Digite Novamente!";
    }

    public void start() {
        try {

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintStream(socket.getOutputStream());
            
            String clientRequest;
            String responseToClient;

            while ((clientRequest = reader.readLine()) != null) {
                
    
                // O QUE O CLIENTE
                // MANDOU
                String protocolo = extrairprotocolo(clientRequest);
                responseToClient = protocolo;

                outputStream.println(responseToClient);
                System.out.println("Reposta enviada ao cliente"); // O QUE A
                // GENTE
                // ENVIA
            }

            socket.close();
            System.out.println("Cliente disconectado: " + socket.getInetAddress());
        } catch (IOException e) {
            System.out.println("Cliente disconectado: " + socket.getInetAddress());
        }
    }
}
