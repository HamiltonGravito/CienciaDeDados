package com.dados.d.ciencia.resource;
/**
 * Esse recurso recebe uma url, um topico (Texto que deve conter na página), um delimitador (texto que deve conter
 * no href) e numero de páginas a pesquisar e retorna uma lista contendo as urls encontradas com esses atributos 
 * O método recursivo trabalha procurando as especificações em cada url subsequente encontrada.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dados.d.ciencia.service.WebCrawlerService;

@RequestMapping("/webcrawler")
@RestController
public class WebCrawlerResource {

	@Autowired
	private WebCrawlerService crawlerService;
	
	@GetMapping
	public ResponseEntity<List<String>> listaDePaginas(
			@RequestParam(value = "urlInicial", required = true) String urlInicial, 
			@RequestParam (value = "topico", required = true) String topico,
			@RequestParam (value = "delimitador", required = true) String delimitador, 
			@RequestParam (value = "nDePagLimite", required = true) int nDePagLimite) {
		List<String> listaVisitada = crawlerService.visitarPaginas(urlInicial, topico, delimitador, nDePagLimite);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listaVisitada);
	}
	
}