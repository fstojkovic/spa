package main;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;

public class JSLista extends AJSLista {

	@Override
	public int zbirElemenataUCiklicnoj() throws LabisException {

		if (prvi == null) {
			throw new LabisException("");

		}
		int zbir = prvi.podatak;
		CvorJSListe pom = prvi.sledeci;
		while (pom != prvi) {
			zbir += pom.podatak;
			pom = pom.sledeci;

		}
		return zbir;
	}

	@Override
	public int izbaciTrenutni(CvorJSListe t) throws LabisException {

		if (prvi == null || t == null) {
			return 0;
		}

		/*
		 * CvorJSListe tekuci = prvi; while (tekuci != null) {
		 * 
		 * if (tekuci.sledeci == t) {
		 * 
		 * tekuci.sledeci = t.sledeci;
		 * 
		 * } else throw new LabisException("U listi ne postoji trazeni element."
		 * );
		 * 
		 * }
		 * 
		 * return t.podatak;
		 */

		if (prvi == t) {
			prvi = prvi.sledeci;
			return t.podatak;
		}
		CvorJSListe pom = prvi;
		while (pom.sledeci != t && pom.sledeci != null) {
			pom = pom.sledeci;
		}
		if (pom.sledeci != null) {
			pom.sledeci = t.sledeci;
			return t.podatak;
		}

		throw new LabisException("");

	}

	@Override
	public void invertovanjeSaPomocnom() throws LabisException {

		if (prvi == null || prvi.sledeci == null) {
			return;
		}

		CvorJSListe noviPrvi = null;
		CvorJSListe pom = prvi;
		while (pom != null) {
			noviPrvi = new CvorJSListe(pom.podatak, noviPrvi);
			pom = pom.sledeci;
		}
		// jako bitno, lokalna promenjiva je noviPrvi nestace bez ovog
		prvi = noviPrvi;
	}

	@Override
	public void invertovanjeBezPomocne() throws LabisException {
		if (prvi == null || prvi.sledeci == null) {
			return;
		}

		CvorJSListe p = prvi;
		CvorJSListe pom = prvi;
		while (p.sledeci != null) {
			pom = p.sledeci;
			p.sledeci = pom.sledeci;
			pom.sledeci = prvi;
			prvi = pom;
		}

	}
	// npr 8, 22, 4
		// prvi____"422"+8
		   //prvi.sledeci___"4"+22
		    //prvi.sledeci.sledeci___""+4
		          //prvi.sledeci.sledeci.sledeci____""
	@Override
	public String ispisiObrnuto(CvorJSListe prvi) throws LabisException {

		if (prvi == null) {
			return "";
		}

		return ispisiObrnuto(prvi.sledeci) + prvi.podatak;
	}
	
	//prvi__8_
	  //prvi.sledeci__22_
	    //prvi.sledeci.sledeci__4_
		  //prvi.sledeci.sledeci.sledeci_null___
	@Override
	public CvorJSListe klonirajRekurzivno(CvorJSListe pom) throws LabisException {
		
		if(pom == null){
			return null;
		}
		return new CvorJSListe(pom.podatak, klonirajRekurzivno(pom));
		
	
	}
	
}
