package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;


/**
 * Created by guthierrezsouza on 06/06/17.
 */
class UmParClassificador implements PokerHandClassificador {
	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		if (pokerHand.findCartasMesmoValor(2)) {
			pokerHand.setCategoria(CategoriaMao.UM_PAR)
			return true
		}
		return false
	}
}
