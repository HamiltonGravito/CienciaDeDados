package com.dados.d.ciencia.service;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.dados.d.ciencia.model.WebCrawlerModel;

@Service
public class WebCrawlerService {
	WebCrawlerModel crawlerModel = new WebCrawlerModel();

	public List<String> visitarPaginas(String urlInicial, String topico, String delimitador, int nDePagLimite) {

		crawlerModel.setUrlInicial(urlInicial);
		crawlerModel.setTopico(topico);
		crawlerModel.setUrlLimite(delimitador);
		crawlerModel.setQtdLimitePag(nDePagLimite);

		if (crawlerModel.getListaDePaginas().size() <= crawlerModel.getQtdLimitePag()) {

			if (crawlerModel.getListaVisitados().contains(urlInicial)) {
				// Não faz nada.
			} else {
				crawlerModel.getListaVisitados().add(urlInicial);
			}

			try {
				Document doc = Jsoup.connect(urlInicial).get();
				if (doc.text().contains(crawlerModel.getTopico())) {
					System.out.println((crawlerModel.getListaDePaginas().size() + 1) + ": [" + urlInicial + "]");
					crawlerModel.getListaDePaginas().add(urlInicial);

					Elements elementos = doc.select("a[href]");
					for (Element link : elementos) {
						if (link.attr("href").contains(crawlerModel.getUrlLimite())) {
							visitarPaginas(link.attr("abs:href"), crawlerModel.getTopico(), crawlerModel.getUrlLimite(), crawlerModel.getQtdLimitePag());
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {

			}
		}
		return crawlerModel.getListaVisitados();
	}
}
