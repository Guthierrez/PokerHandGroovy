package br.pokerhand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
enum NaipeCarta {

	ESPADAS("S", "Espadas"),
	COPAS("H", "Copas"),
	OUROS("D", "Ouros"),
	PAUS("C", "Paus");

	String valor
	String descricao

	NaipeCarta(String valor, String descricao){
		this.valor = valor
		this.descricao = descricao
	}

	static NaipeCarta getNaipeCarta(String valor){
		NaipeCarta.values().find{it.valor == valor}
	}

	@Override
	String toString() {
		return descricao
	}
}
