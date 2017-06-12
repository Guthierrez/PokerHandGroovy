package br.pokerhand.classificador

import br.pokerhand.AbstractHand
import br.pokerhand.PokerHand
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by guthierrezsouza on 08/06/17.
 */
class PokerHandClassificadorSpecification extends Specification {

	@Unroll
	def "teste classificacao royal flush"(){
		given:
		PokerHandClassificador classificador = new RoyalFlushClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"TD JD QD KD AD" | true
		"TD AD QD KD JD" | true
		"TS AD QD KD JD" | false
		"4D 5D 6D 7C 8D" | false
	}


	@Unroll
	def "teste classificacao straight flush"(){
		given:
		PokerHandClassificador classificador = new StraightFlushClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"4D 5D 6D 7D 8D" | true
		"4D 5D 6D 7C 8D" | false
	}

	@Unroll
	def "teste classificação quadra"(){

		given:
		PokerHandClassificador classificador = new QuadraClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"TD TS TC TH 7H" | true
		"TC AS 3H 4C 6D"  | false

	}

	@Unroll
	def "teste classificacao fullhouse"(){
		given:
		PokerHandClassificador classificador = new FullHouseClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"TD TS TC 4H 4D" | true
		"TD TS TC 4H 9D"  | false
		"TD TS TC 4H 9D"  | false
	}

	@Unroll
	def "teste classificacao flush"(){
		given:
		PokerHandClassificador classificador = new FlushClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"8D TD 3D 4D 7D" | true
		"4D 5D 6D 7C 8D" | false
		"4D 4D 6D 7D 7D" | true
	}

	@Unroll
	def "teste classificacao sequencia"(){
		given:
		PokerHandClassificador classificador = new SequenciaClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"8D TD 3D 4D 7D" | false
		"4D 5D 6D 7C 8D" | true
		"4D 5D 6D 7D 8D" | false
		"7D 5D 8D 4C 6D" | true
	}

	@Unroll
	def "teste classificacao trinca"(){
		given:
		PokerHandClassificador classificador = new TrincaClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"8D 8S 8C 3D 7D" | true
		"8D 8S 8C 3D 3S" | false
		"8D 8S 8C 8H 3S" | false
	}

	@Unroll
	def "teste classificacao dois pares"(){
		given:
		PokerHandClassificador classificador = new DoisParesClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"8D 8S 3C 3D 7D" | true
		"8D 8S 5C 3D 6S" | false
		"8D 8S 5C 3D 5S" | true
	}

	@Unroll
	def "teste um par"(){
		given:
		PokerHandClassificador classificador = new UmParClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"8D 8S 3C TD 7D" | true
		"2D KS 5C 3D QS" | false
		"8D 8S AC 3D 5S" | true
	}

	@Unroll
	def "teste classificação carta alta"(){
		given:
		PokerHandClassificador classificador = new CartaAltaClassificador()
		AbstractHand hand = new PokerHand(mao)

		expect:
		classificador.classificarMao(hand) == resultado

		where:
		mao | resultado
		"4D TH 6C 7C 5H" | true
	}

}
