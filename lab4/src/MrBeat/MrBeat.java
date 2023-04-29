package MrBeat;

import java.util.ArrayList;

public class MrBeat {
	
	private ArrayList<Time> times;

	
	
	public MrBeat() {
		this.times = new ArrayList<>();
	}



	public void incluirTime(String id, String nome, String mascote) {
		Time time = new Time(id, nome, mascote);
		
		if (existeTime(time)) { 
			System.out.println("TIME JÁ EXISTE!");
		} else {
			times.add(time);
			System.out.println("INCLUSÃO REALIZADA!");
		}
			
	}


	
	private boolean existeTime(Time time) {
		for (int i = 0; i < times.size(); i++) {
			if( times.get(i) != null && times.get(i).equals(time)) {
				return true;
			}
		}
		return false;
	} 
	
}
