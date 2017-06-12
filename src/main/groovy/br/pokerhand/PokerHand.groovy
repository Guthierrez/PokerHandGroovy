package br.pokerhand

import br.pokerhand.classificador.CartaAltaClassificador
import br.pokerhand.classificador.DoisParesClassificador
import br.pokerhand.classificador.FlushClassificador
import br.pokerhand.classificador.FullHouseClassificador
import br.pokerhand.classificador.PokerHandClassificador
import br.pokerhand.classificador.QuadraClassificador
import br.pokerhand.classificador.RoyalFlushClassificador
import br.pokerhand.classificador.SequenciaClassificador
import br.pokerhand.classificador.StraightFlushClassificador
import br.pokerhand.classificador.TrincaClassificador
import br.pokerhand.classificador.UmParClassificador


/**
 * Created by guthierrezsouza on 08/06/17.
 */
class PokerHand extends AbstractHand {

	private final static INTERVALO_TAMANHO_SEQUENCIA = 4
	private final static QUANTIDADE_PARA_FLUSH = 5

	private classificadores = [
			new RoyalFlushClassificador(), new StraightFlushClassificador(), new QuadraClassificador(),
			new FullHouseClassificador(), new FlushClassificador(), new SequenciaClassificador(),
			new TrincaClassificador(), new DoisParesClassificador(), new UmParClassificador(), new CartaAltaClassificador()
	]

	PokerHand(String mao) {
		this.buildListCartas(mao)
		this.classificarMao()
		this.ordenarCartas()
	}

	Boolean isSequencia() {
		for(int i=0; i < getCartas().size()-1; i++){
			if(getCartas().get(i+1).getValorCarta().getPeso() != getCartas().get(i).getValorCarta().getPeso()+1){
				return false
			}
		}
		return true
	}

	Boolean isFlush() {
		Integer contadorNaipe = getCartas().findAll { it.getNaipeCarta() == getCartas().first().getNaipeCarta()}.size()
		return contadorNaipe == QUANTIDADE_PARA_FLUSH
	}

	List<Carta> findCartasMesmoValor(Integer quantidade) {
		List<Carta> cartasEncontradas = []
		for (Carta carta in getCartas()) {
			cartasEncontradas = getCartas().findAll{carta.getValorCarta() == it.getValorCarta()}
			if (cartasEncontradas.size() == quantidade) {
				return cartasEncontradas
			}
		}
		return cartasEncontradas.clear()
	}

	Carta getMaiorCarta() {
		return getCartas().last()
	}

	private void ordenarCartas() {
		getCartas().sort { it.getValorCarta().getPeso() }
	}

	private void buildListCartas(String mao) {
		String[] cartas = mao.split(" ")
		cartas.each {
			ValorCarta valorCarta = ValorCarta.getValorCarta(it.substring(0, 1))
			NaipeCarta naipeCarta = NaipeCarta.getNaipeCarta(it.substring(1, 2))
			this.getCartas().add(new Carta(valorCarta, naipeCarta))
		}
	}

	private void classificarMao() {
		classificadores.find { it.classificarMao(this) }
	}
}
