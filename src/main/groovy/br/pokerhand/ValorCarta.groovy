package br.pokerhand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
enum ValorCarta {

	DOIS("2", 2),
	TRES("3", 3),
	QUATRO("4", 4),
	CINCO("5", 5),
	SEIS("6", 6),
	SETE("7", 7),
	OITO("8", 8),
	NOVE("9", 9),
	DEZ("T", 10),
	VALETE("J", 11),
	DAMA("Q", 12),
	REI("K", 13),
	AS("A", 14)

	String valor
	Integer peso

	ValorCarta(String valor, Integer peso){
		this.valor = valor
		this.peso = peso
	}

	static ValorCarta getValorCarta(String valor){
		ValorCarta.values().find{it.getValor() == valor}
	}

	@Override
	String toString() {
		return getValor()
	}
}
