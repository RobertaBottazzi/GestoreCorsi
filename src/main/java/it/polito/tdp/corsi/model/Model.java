package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.db.CorsoDAO;

public class Model {
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso,Integer> getIscrittiByPeriodo(Integer pd){
		return corsoDao.getIscrittiByPeriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(String codice){
		return corsoDao.getStudentiByCorso(new Corso(codice,null,null,null));
	}
	
	public Map<String,Integer> getDivisioneCDS(String codice) {
		//potrei anche creare una classe DivisioneCDS che raccoglie le informazioni che mi restituisce e metterli in una lista
		//quello che mi aspetto di ottenere è per un corso ABC ci sono: 
		//GEST ->50
		//INF ->40
		//MAT ->30
		
		//SOLUZIONE 1 BASATA SUL MIO CODICE
		/*Map<String,Integer> divisione= new HashMap<>();
		List<Studente> studenti= this.getStudentiByCorso(codice);
		for(Studente s: studenti) {
			if(s.getCDS()!=null && !s.getCDS().equals("")) { //posso avere uno studente non associato a quel corso di studi
				if(divisione.get(s.getCDS())==null) {
					divisione.put(s.getCDS(), 1);
				} else {
					divisione.put(s.getCDS(), divisione.get(s.getCDS())+1);
				}				
			}			
		}
		return divisione;*/
		
		//SOLUZIONE 2 PASSANDO DAL DATABASE		
		return corsoDao.getDivisioneStudenti(new Corso(codice,null,null,null));		
	}
	
	public boolean esisteCorso(String codice) {		
		return corsoDao.esisteCorso(new Corso(codice,null,null,null));
	}
	
	
}
