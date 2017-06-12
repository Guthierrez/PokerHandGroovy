package br.pokerhand

/**
 * Created by guthierrezsouza on 06/06/17.
 */
enum CategoriaMao implements Categoria {
	ROYAL_FLUSH(10, "Royal Flush"),
	STRAITGH_FLUSH(9, "Straigth Flush"),
	QUADRA(8, "Quadra"){
		@Override
		Integer getDesempateCategoria(PokerHand pokerHand) {
			return pokerHand.findCartasMesmoValor(4).first().getValorCarta().getPeso()
		}
	},
	FULL_HOUSE(7, "Full House"){
		@Override
		Integer getDesempateCategoria(PokerHand pokerHand) {
			return pokerHand.findCartasMesmoValor(3).first().getValorCarta().getPeso()
		}
	},
	FLUSH(6, "Flush"),
	SEQUENCIA(5, "Sequência"),
	TRINCA(4, "Trinca"){
		@Override
		Integer getDesempateCategoria(PokerHand pokerHand) {
			return pokerHand.findCartasMesmoValor(3).first().getValorCarta().getPeso()
		}
	},
	DOIS_PARES(3, "Dois Pares"){
		@Override
		Integer getDesempateCategoria(PokerHand pokerHand) {
			List<Carta> todas = pokerHand.getCartas().clone()
			List<Carta> pares = pokerHand.findCartasMesmoValor(2)
			pokerHand.getCartas().removeAll(pares)
			pares.addAll(pokerHand.findCartasMesmoValor(2))
			pokerHand.setCartas(todas)
			return pares.last().getValorCarta().getPeso()
		}
	},
	UM_PAR(2, "Um Par"){
		@Override
		Integer getDesempateCategoria(PokerHand pokerHand) {
			return pokerHand.findCartasMesmoValor(2).first().getValorCarta().getPeso()
		}
	},
	CARTA_ALTA(1, "Carta Alta");

	Integer peso
	String descricao

	CategoriaMao(Integer peso, descricao) {
		this.peso = peso
		this.descricao = descricao
	}

	Integer getDesempateCategoria(PokerHand pokerHand) {
		return pokerHand.getMaiorCarta().getValorCarta().getPeso()
	}

	Integer getPesoCategoria() {
		return this.peso
	}

	@Override
	String toString() {
		return getDescricao()
	}
}
