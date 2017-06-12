package br.pokerhand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
class Carta {
	ValorCarta valorCarta;
	NaipeCarta naipeCarta;

	Carta(ValorCarta valorCarta, NaipeCarta naipeCarta) {
		this.valorCarta = valorCarta
		this.naipeCarta = naipeCarta
	}

	@Override
	String toString() {
		return valorCarta.toString() + " de " + naipeCarta.toString();
	}
}
