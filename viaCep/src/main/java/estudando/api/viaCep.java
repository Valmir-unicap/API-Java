package estudando.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class viaCep {

    private Endereco endereco;

    private static final String BASE_URL = "http://viacep.com.br/ws/";

    private final HttpClient client = HttpClient.newHttpClient();

    private final ObjectMapper mapper = new ObjectMapper();

    public Endereco getLocalidade(String cep){
        try{
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL+cep+"/json/")).build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            endereco = mapper.readValue(response.body(), Endereco.class);    //Conversão de JSON para Objeto
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return endereco;
    }
}
