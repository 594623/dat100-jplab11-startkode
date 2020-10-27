package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
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
			if (i != null) {
				if (i.erLik(innlegg)) {		
					return true;
				}
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		if (innleggtabell.length > nesteledig) {
			return true;
		} else return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		boolean idFinnes = false;
		int innleggId = innlegg.getId();
		for (Innlegg i : innleggtabell) {
			if (i != null) {
				if (i.getId() == innleggId) {
					idFinnes = true;
				}
			}
		}
		
		if (!idFinnes) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else return false;
	}
	
	public String toString() {
		String s = nesteledig + "\n";
		for (Innlegg i : innleggtabell) {
			s += i.toString();
		}
		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}