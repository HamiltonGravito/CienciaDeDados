package com.dados.d.ciencia.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdquirirPagHtmlService {

	public String adquirirTextoHtml(String pagina) {
		URL url = null;
		HttpURLConnection conexao = null;
		StringBuilder paginaHtml = new StringBuilder();
		InputStreamReader isr;
		try {
			// Cria URL e estabelece uma conexão
			url = new URL(pagina);
			conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod("GET");
			conexao.connect();

			// Carrega dados e copia-os no buffer para saída
			isr = new InputStreamReader(conexao.getInputStream());
			BufferedReader buffer = new BufferedReader(isr);
			String linha = null;
			do {
				linha = buffer.readLine();
				paginaHtml.append(linha + "\n");
			} while (linha != null);
		} catch (MalformedURLException e) {
			System.out.println("Erro: " + e.getMessage());
			paginaHtml.append(String.valueOf(HttpStatus.BAD_REQUEST));
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
			try {
				paginaHtml.append(String.valueOf(conexao.getResponseCode()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} finally {

		}
		return paginaHtml.toString();
	}
}
