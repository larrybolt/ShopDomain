package domain.verkoop;

public interface Observer {
	public void update(Subject subject);
	// TODO: vragen of dit de juiste manier is!!
	/*
	 * We gebruiken pull
	 * Ik doe het zo, omdat anders onze Observer (meestal SwingViews) een instantie moet hebben
	 * van Subject, aldus niet via de ShopFacade passeert.
	 * Op deze manier geeft de Subject bij een update een referentie naar zichzelf door
	 * (nog beter een clone van zichzelf), de observer kan dan met instanceOf bepalen wat voor
	 * Subject de update heeft getriggerd.
	 * Bij push is de Observer te gelimiteerd, tenzij we een Object meegeven die eender wat kan zijn...
	 */
}