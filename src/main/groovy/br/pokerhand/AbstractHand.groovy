package br.pokerhand

/**
 * Created by guthierrezsouza on 08/06/17.
 */
abstract class AbstractHand {
	List<Carta> cartas = []
	Categoria categoria = null

	Result compareWith(PokerHand other) {
		if (this.getCategoria().getPesoCategoria() > other.getCategoria().getPesoCategoria()) {
			return Result.WIN
		} else if (this.getCategoria().getPesoCategoria() < other.getCategoria().getPesoCategoria()) {
			return Result.LOSS
		} else {
			return this.desempatarPorCategoria(other)
		}
	}

	Result desempatarPorCategoria(PokerHand other) {
		if (this.getCategoria().getDesempateCategoria(this) > other.getCategoria().getDesempateCategoria(other)) {
			return Result.WIN
		} else if (this.getCategoria().getDesempateCategoria(this) < other.getCategoria().getDesempateCategoria(other)) {
			return Result.LOSS
		} else {
			return this.desempatarPorKicker(other)
		}
	}

	Result desempatarPorKicker(PokerHand other) {
		for (int i = 0; i < getCartas().size(); i++) {
			if (this.getCartas().get(i).getValorCarta().getPeso() > other.getCartas().get(i).getValorCarta().getPeso()) {
				return Result.WIN
			}
			if (this.getCartas().get(i).getValorCarta().getPeso() < other.getCartas().get(i).getValorCarta().getPeso()) {
				return Result.LOSS
			}
		}
		return Result.SPLIT
	}

	@Override
	String toString() {
		return getCategoria().toString() + '--' + cartas.toString()
	}
}