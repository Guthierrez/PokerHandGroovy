package br.pokerhand.classificador

import br.pokerhand.Carta
import br.pokerhand.CategoriaMao
import br.pokerhand.PokerHand;

/**
 * Created by guthierrezsouza on 06/06/17.
 */
class DoisParesClassificador implements PokerHandClassificador {
	@Override
	Boolean classificarMao(PokerHand pokerHand) {
		List<Carta> todasCartas = pokerHand.getCartas().clone()
		List<Carta> primeiroPar = pokerHand.findCartasMesmoValor(2)
		if (primeiroPar) {
			pokerHand.getCartas().removeAll(primeiroPar)
			if (pokerHand.findCartasMesmoValor(2)) {
				pokerHand.setCartas(todasCartas)
				pokerHand.setCategoria(CategoriaMao.DOIS_PARES)
				return true
			}
			pokerHand.setCartas(todasCartas)
		}
		return false
	}
}
