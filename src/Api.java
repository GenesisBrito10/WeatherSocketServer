import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Api {
    private static final String API_KEY = "39bb5b6d";
   
    public static JSONObject consultaApi(String cidade) throws Exception{
         try {
            URL url = new URL("https://api.hgbrasil.com/weather?key=" + API_KEY + "&city_name=" + cidade);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            
            JSONParser parser = new JSONParser();
            JSONObject consulta = (JSONObject) parser.parse(response.toString());

            return consulta;
            

        } catch (Exception e) {
           
            e.printStackTrace(); 
            throw e;
        }
    }
    public static String getTemperature(String cidade) {
        try {
            
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String temperature = results.get("temp").toString();

            return temperature;

        } catch (Exception e) {
            
            e.printStackTrace(); 
            return "Não foi possível obter a temperatura para " + cidade;
        }
    }  


    public static String getHoras(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String horas = results.get("time").toString();
            
            return horas;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter as horas para " + cidade;
        }
    }  

    public static String getPeriodoDia(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String periodo = results.get("currently").toString();
            
            return periodo;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter o periodo para " + cidade;
        }
    } 

    public static String getClima(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String clima = results.get("description").toString();
            
            return clima;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter o clima para " + cidade;
        }
    }

    public static String getClimaAmanha(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            JSONArray previsoes = (JSONArray) results.get("forecast");
            
            if (previsoes.size() > 0) {
                JSONObject primeiraPrevisao = (JSONObject) previsoes.get(1);
                String clima_amanha = primeiraPrevisao.get("description").toString();
                
                return clima_amanha;
            } else {
                return "Nenhuma clima disponível.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter o clima para " + cidade;
        }
    }
    
     public static String getNebulosidade(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String neb = results.get("cloudiness").toString();
            
            return neb;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter a nebulosidade para " + cidade;
        }
    }

    public static String getUmidade(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String umid = results.get("humidity").toString();
            
            return umid;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter as Umidades para " + cidade;
        }
    }

    public static String getChuva(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String chuva = results.get("rain").toString();
            
            return chuva;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter os Volumes de chuva para " + cidade;
        }
    }

    public static String getNascerSol(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String nasc_sol = results.get("sunrise").toString();
            
            return nasc_sol;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter o horário do nascer do sol para " + cidade;
        }
    }
    public static String getVelVento(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String vel_vento = results.get("wind_speedy").toString();
            
            return vel_vento;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter a velocidade do vento de " + cidade;
        }
    }

    public static String getFusoHorario(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String fuso_hor = results.get("timezone").toString();
            
            return fuso_hor;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter o fuso horário para " + cidade;
        }
    }

    public static String getPorSol(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String por_sol = results.get("sunset").toString();
            
            return por_sol;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter o horário do por do sol para " + cidade;
        }
    }

    public static String getFaseLua(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String fase = results.get("moon_phase").toString();
            
            switch (fase) {
                case "new":
                    fase = "Lua nova";
                    break;
                case "waxing_crescent":
                    fase = "Lua crescente";
                    break;
                case "first_quarter":
                    fase = "Quarto crescente";
                    break;
                case "waxing_gibbous":
                    fase = "Gibosa crescente";
                    break;
                case "full":
                    fase = "Lua cheia";
                    break;
                case "waning_gibbous":
                    fase = "Gibosa minguante";
                    break;
                case "last_quarter":
                    fase = "Quarto minguante";
                    break;
                case "waning_crescent":
                    fase = "Lua minguante";
                    break;
                default:
                    fase = "Fase desconhecida";
            }
            
            return fase;
            

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter o fase da lua para " + cidade;
        }
    }
    public static String getDirecaoVento(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            String dir = results.get("wind_cardinal").toString();
            
            return dir;

        } catch (Exception e) {
           
            e.printStackTrace(); 
            return "Não foi possível obter a direção do vento para " + cidade;
        }
    }
    public static String getTempMaxHoje(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            JSONArray previsoes = (JSONArray) results.get("forecast");
            
            if (previsoes.size() > 0) {
                JSONObject primeiraPrevisao = (JSONObject) previsoes.get(0);
                String max = primeiraPrevisao.get("max").toString();
                return max;
            } else {
                return "Nenhuma previsão disponível.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter a temperatura máxima de hoje para " + cidade;
        }
    }

    public static String getTempMinHoje(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            JSONArray previsoes = (JSONArray) results.get("forecast");
            
            if (previsoes.size() > 0) {
                JSONObject primeiraPrevisao = (JSONObject) previsoes.get(0);
                String min = primeiraPrevisao.get("min").toString();
                return min;
            } else {
                return "Nenhuma previsão disponível.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter a temperatura mínima de hoje para " + cidade;
        }
    }
    public static String getTempMaxAmanha(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            JSONArray previsoes = (JSONArray) results.get("forecast");
            
            if (previsoes.size() > 0) {
                JSONObject primeiraPrevisao = (JSONObject) previsoes.get(1);
                String max = primeiraPrevisao.get("max").toString();
                return max;
            } else {
                return "Nenhuma previsão disponível.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter a temperatura máxima de amanhã para " + cidade;
        }
    }

    public static String getTempMinAmanha(String cidade) {
        try {
            JSONObject consulta = consultaApi(cidade);
            JSONObject results = (JSONObject) consulta.get("results");
            JSONArray previsoes = (JSONArray) results.get("forecast");
            
            if (previsoes.size() > 0) {
                JSONObject primeiraPrevisao = (JSONObject) previsoes.get(1);
                String min = primeiraPrevisao.get("min").toString();
                return min;
            } else {
                return "Nenhuma previsão disponível.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter a temperatura mínima de amanhã para " + cidade;
        }
    }
}
