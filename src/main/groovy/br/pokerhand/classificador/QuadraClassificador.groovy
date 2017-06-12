package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
class QuadraClassificador implements PokerHandClassificador {
	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		if (pokerHand.findCartasMesmoValor(4)) {
			pokerHand.setCategoria(CategoriaMao.QUADRA)
			return true
		}
		return false
	}
}
