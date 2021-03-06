package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (Innlegg i : innleggtabell) {
			if (i == null) return false;
			if (i.erLik(innlegg)) return true;
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig ++;
			return true;
		} else return false;
	}
	
	public String toString() {
		String s = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			s += innleggtabell[i].toString();
		}
		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utvidet = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < nesteledig; i++) {
			utvidet[i] = innleggtabell[i];
		} 
		innleggtabell = utvidet;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean success = leggTil(innlegg);
		if (!success && !ledigPlass()) {
			utvid();
			success = leggTil(innlegg);
		}
		return success;
	}
	
	public boolean slett(Innlegg innlegg) {
		int innleggIndex = finnInnlegg(innlegg);
		if (innleggIndex == -1) return false;
		innleggtabell[innleggIndex] = null;
		nesteledig--;
		return true;
	}
	
	public int[] search(String keyword) {
		int[] ids = new int[nesteledig];
		int amount = 0;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)) {
				ids[amount] = innleggtabell[i].getId();
				amount++;
			}
		}
		return ids;
	}
}