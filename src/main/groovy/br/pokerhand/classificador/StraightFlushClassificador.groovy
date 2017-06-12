package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;


/**
 * Created by guthierrezsouza on 06/06/17.
 */
class StraightFlushClassificador implements PokerHandClassificador {

	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		if (pokerHand.isSequencia() && pokerHand.isFlush()) {
			pokerHand.setCategoria(CategoriaMao.STRAITGH_FLUSH)
			return true
		}
		return false
	}
}
