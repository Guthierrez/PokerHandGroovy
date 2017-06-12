package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
class SequenciaClassificador implements PokerHandClassificador {
	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		if (!pokerHand.isFlush() && pokerHand.isSequencia()) {
			pokerHand.setCategoria(CategoriaMao.SEQUENCIA)
			return true
		}
		return false
	}
}
