package br.com.alura.jpa.modelo;

public class MediaComData {

	private Double media;
	private Integer dia;
	private Integer mes;

	public MediaComData(Double media, Integer dia, Integer mes) {
		this.media = media;
		this.dia = dia;
		this.mes = mes;
	}

	public Double getMedia() {
		return media;
	}

	public Integer getDia() {
		return dia;
	}

	public Integer getMes() {
		return mes;
	}

}
