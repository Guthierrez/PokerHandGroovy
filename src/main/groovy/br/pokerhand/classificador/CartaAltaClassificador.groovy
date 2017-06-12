package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
class CartaAltaClassificador implements PokerHandClassificador {
	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		pokerHand.setCategoria(CategoriaMao.CARTA_ALTA);
		return true
	}
}
