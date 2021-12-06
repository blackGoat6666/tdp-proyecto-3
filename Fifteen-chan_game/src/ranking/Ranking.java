package ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;

public class Ranking implements Serializable {
	private List<Nombres> ranking;
	
	public Ranking() {
		this.ranking = new ArrayList<Nombres>();
	}
	
	public void addRanking( Nombres p ) {
		this.ranking.add(p);
	}
	
	public void printPlayers(JLabel[] puntajes) {
		Collections.sort(this.ranking, Collections.reverseOrder());
		System.out.println();
		int i = 0;
		for(Nombres p : this.ranking) {
			
			if( i== 5 ) break;
			puntajes[i].setText(p.getNombre() + ".............." + p.getPuntaje());
			i++;
		}
	}

	}
	
	

