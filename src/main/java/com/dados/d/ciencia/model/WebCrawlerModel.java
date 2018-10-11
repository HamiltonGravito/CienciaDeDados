package com.dados.d.ciencia.model;

import java.util.ArrayList;

public class WebCrawlerModel {

	public WebCrawlerModel() {

	}

	public WebCrawlerModel(String topico, String urlInicial, String urlLimite, int qtdLimitePag,
			ArrayList<String> listaVisitados, ArrayList<String> listaDePaginas) {
		super();
		this.topico = topico;
		this.urlInicial = urlInicial;
		this.urlLimite = urlLimite;
		this.qtdLimitePag = qtdLimitePag;
		this.listaVisitados = listaVisitados;
		this.listaDePaginas = listaDePaginas;
	}

	// Palavra chave
	private String topico;
	// URL inicial
	private String urlInicial;
	// Palavra contida no link para validá-lo
	private String urlLimite;
	// Numero máximo de páginas
	private int qtdLimitePag;
	// Paginas que já foram visitadas
	private ArrayList<String> listaVisitados = new ArrayList<>();
	// URL das páginas de interesse
	private ArrayList<String> listaDePaginas = new ArrayList<>();

	public String getTopico() {
		return topico;
	}

	public void setTopico(String topico) {
		this.topico = topico;
	}

	public String getUrlInicial() {
		return urlInicial;
	}

	public void setUrlInicial(String urlInicial) {
		this.urlInicial = urlInicial;
	}

	public String getUrlLimite() {
		return urlLimite;
	}

	public void setUrlLimite(String urlLimite) {
		this.urlLimite = urlLimite;
	}

	public int getQtdLimitePag() {
		return qtdLimitePag;
	}

	public void setQtdLimitePag(int qtdLimitePag) {
		this.qtdLimitePag = qtdLimitePag;
	}

	public ArrayList<String> getListaVisitados() {
		return listaVisitados;
	}

	public void setListaVisitados(ArrayList<String> listaVisitados) {
		this.listaVisitados = listaVisitados;
	}

	public ArrayList<String> getListaDePaginas() {
		return listaDePaginas;
	}

	public void setListaDePaginas(ArrayList<String> listaDePaginas) {
		this.listaDePaginas = listaDePaginas;
	}

}
