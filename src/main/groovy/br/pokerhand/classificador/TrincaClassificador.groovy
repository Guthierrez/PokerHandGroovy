package br.pokerhand.classificador

import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
public class TrincaClassificador implements PokerHandClassificador {
	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		if (!pokerHand.findCartasMesmoValor(2) && pokerHand.findCartasMesmoValor(3)) {
			pokerHand.setCategoria(CategoriaMao.TRINCA)
			return true
		}
		return false
	}
}
