package br.usjt.projeto.semestral.Controller;

import java.io.FileWriter;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.usjt.projeto.semestral.Model.Usuario;

public class Rest {

	
	private String montaURL()
	{
		String url = "http://localhost:8080/SistemaChamado/rest/chamados/user/";
	
		return url;
		
	}
	
	
	@Transactional
	public Usuario buscaRest(Usuario usuario)
	{
		RestTemplate template =  new RestTemplate();
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		System.out.println(json);
		
		try {
			//Escreve Json convertido em arquivo chamado "file.json"
			FileWriter writer = new FileWriter("C:\\Users\\Bruni\\workspace\\SistemaChamado\\file.json");
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("final metodo");
		Usuario resultado  = template.getForObject(montaURL(), Usuario.class);
		System.out.println("RResultado da minha requisição"+resultado);
		
		
		return resultado;
	}
}
