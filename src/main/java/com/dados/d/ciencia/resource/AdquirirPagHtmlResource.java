package com.dados.d.ciencia.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dados.d.ciencia.service.AdquirirPagHtmlService;
/**
 *Esse Recurso tem como função receber uma url e retornar uma String constando todo o texto da página. 
 **/
@RestController
@RequestMapping("/adquirir")
public class AdquirirPagHtmlResource {

	@Autowired
	private AdquirirPagHtmlService adquirirService;

	@GetMapping
	public ResponseEntity<String> getStringPagHTML(@RequestParam(value = "pagHtml", required = true) String pagHtml) {
		String paginaHtml = adquirirService.adquirirTextoHtml(pagHtml);
		if(paginaHtml.length() < 3) {
			int responseCode = Integer.parseInt(paginaHtml);
			if (responseCode < 200) {
				return ResponseEntity.status(HttpStatus.CONTINUE).body(paginaHtml);
			} else if (responseCode > 199 && responseCode < 300) {
				return ResponseEntity.status(HttpStatus.OK).body(paginaHtml);
			} else if (responseCode > 299 && responseCode < 400) {
				return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES).body(paginaHtml);
			} else if(responseCode > 399 && responseCode < 500) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(paginaHtml);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(paginaHtml);
			}
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(paginaHtml);
		}
	}
}
