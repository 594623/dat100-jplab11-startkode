package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		
		try {
			Blogg blogg = new Blogg();
			BufferedReader br = new BufferedReader(new FileReader(mappe + filnavn));
			String l = br.readLine();
			while (l != null) {
				if (l.equals(TEKST)) {
					Tekst t = new Tekst(
							Integer.parseInt(br.readLine()),
							br.readLine(),
							br.readLine(),
							Integer.parseInt(br.readLine()),
							br.readLine()
					);
					blogg.leggTil(t);
				} else if (l.equals(BILDE)) {
					Bilde b = new Bilde(
							Integer.parseInt(br.readLine()),
							br.readLine(),
							br.readLine(),
							Integer.parseInt(br.readLine()),
							br.readLine(),
							br.readLine()
					);
					blogg.leggTil(b);
				}
				l = br.readLine();
			}
			br.close();
			return blogg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
