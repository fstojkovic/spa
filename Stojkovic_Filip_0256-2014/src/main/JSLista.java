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

		/*CvorJSListe tekuci = prvi;
		while (tekuci != null) {

			if (tekuci.sledeci == t) {

				tekuci.sledeci = t.sledeci;

			} else 
				throw new LabisException("U listi ne postoji trazeni element.");

		}

		return t.podatak;*/
		
		
		if(prvi == t){
			prvi = prvi.sledeci;
			return t.podatak;
		}
		CvorJSListe pom = prvi;
		while(pom.sledeci != t && pom.sledeci != null){
			pom = pom.sledeci;
		}
		if(pom.sledeci!=null){
			pom.sledeci = t.sledeci;
			return t.podatak;
		}
			
		throw new LabisException("");

	}

}
