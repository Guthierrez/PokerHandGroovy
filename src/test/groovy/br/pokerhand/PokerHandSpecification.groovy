package br.pokerhand

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by guthierrezsouza on 08/06/17.
 */
class PokerHandSpecification extends Specification {
	@Unroll
	def "teste com mao vencedora"(){
		given:
		AbstractHand handUm = new PokerHand(cartas)
		AbstractHand handDois = new PokerHand(cartasOponente)

		expect:
		handUm.compareWith(handDois) == resultado

		where:
		cartas           | cartasOponente     | resultado
		"TC TH 5C 5H KH" | "9C 9H 5C 5H AC"   | Result.WIN
		"TS TD KC JC 7C" | "JS JC AS KC TD"   | Result.LOSS;
		"7H 7C QC JS TS" | "7D 7C JS TS 6D"   | Result.WIN;
		"5S 5D 8C 7S 6H" | "7D 7S 5S 5D JS"   | Result.LOSS;
		"AS AD KD 7C 3D" | "AD AH KD 7C 4S"   | Result.LOSS;
		"TS JS QS KS AS" | "AC AH AS AS KS"   | Result.WIN;
		"TS JS QS KS AS" | "TC JS QC KS AC"   | Result.WIN;
		"TS JS QS KS AS" | "QH QS QC AS 8H"   | Result.WIN;
		"TD TS TC TH 7H" | "3D 3H 3C 3S 4H"	  |	Result.WIN
		"TD TS TC TH 7H" | "AD AH AC AS 4H"	  |	Result.LOSS
		"3D 4D 5S 6D 7D" | "4D 5S 6D 7D 8D"	  |	Result.LOSS
		"3D 3C 3S 6D 7D" | "4D 4S 4H 7D 8D"	  |	Result.LOSS
		"5D 5C 5S 6D 7D" | "4D 4S 4H 7D 9D"	  |	Result.WIN
		"5D 5C 6S 6D 7D" | "4D 4S 7H 7D 9D"	  |	Result.LOSS
		"AC AH AS AS KS" | "TC JS QC KS AC"   | Result.WIN
		"AC AH AS AS KS" | "QH QS QC AS 8H"   | Result.WIN
		"TC JS QC KS AC" | "QH QS QC AS 8H"   | Result.WIN
		"7H 8H 9H TH JH" | "JH JC JS JD TH"   | Result.WIN
		"7H 8H 9H TH JH" | "4H 5H 9H TH JH"   | Result.WIN
		"7H 8H 9H TH JH" | "7C 8S 9H TH JH"   | Result.WIN
		"7H 8H 9H TH JH" | "TS TH TD JH JD"   | Result.WIN
		"7H 8H 9H TH JH" | "JH JD TH TC 4C"   | Result.WIN
		"JH JC JS JD TH" | "4H 5H 9H TH JH"   | Result.WIN
		"JH JC JS JD TH" | "7C 8S 9H TH JH"   | Result.WIN
		"JH JC JS JD TH" | "TS TH TD JH JD"   | Result.WIN
		"JH JC JS JD TH" | "JH JD TH TC 4C"   | Result.WIN
		"4H 5H 9H TH JH" | "7C 8S 9H TH JH"   | Result.WIN
		"4H 5H 9H TH JH" | "TS TH TD JH JD"   | Result.LOSS
		"4H 5H 9H TH JH" | "JH JD TH TC 4C"   | Result.WIN
		"7C 8S 9H TH JH" | "TS TH TD JH JD"   | Result.LOSS
		"7C 8S 9H TH JH" | "JH JD TH TC 4C"   | Result.WIN
		"TS TH TD JH JD" | "JH JD TH TC 4C"   | Result.WIN
	}

	@Unroll
	def "teste com maos que empatam" (){
		given:
		AbstractHand handUm = new PokerHand(cartas)
		AbstractHand handDois = new PokerHand(cartasOponente)

		expect:
		handUm.compareWith(handDois) == resultado

		where:
		cartas           | cartasOponente     | resultado
		"7D 8D 9D TD JD" | "7H 8H 9H TH JH"   | Result.SPLIT
		"7H 7D 9H TH JH" | "7H 7D 9H TH JH"   | Result.SPLIT
		"9C 9H 5C 5H AH" | "9C 9H 5C 5H AC"   | Result.SPLIT
		"8H 7D 9H TH AH" | "8H 7D 9H TH AH"   | Result.SPLIT
		"JH JC JS TD TH" | "JH JC JS TD TH"   | Result.SPLIT
	}
}
