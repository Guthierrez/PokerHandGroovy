package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand
import br.pokerhand.ValorCarta;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
class RoyalFlushClassificador implements PokerHandClassificador {

	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		if (pokerHand.isSequencia() && pokerHand.isFlush() && pokerHand.getCartas().first().getValorCarta().equals(ValorCarta.DEZ)) {
			pokerHand.setCategoria(CategoriaMao.ROYAL_FLUSH)
			return true
		}
		return false
	}
}
