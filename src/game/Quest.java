package game;
import enums.Species;

import java.util.LinkedList;

public class Quest {
	protected String name;
	protected Item reward;
	protected LinkedList<Monster> monsters = new LinkedList<Monster>();
	protected int restMonsters;

	public Quest(String _questName, Item _reward, Monster _monster, int _restMonsters) {
		name = _questName;
		reward = _reward;
		Monster tmp = _monster;
		restMonsters = _restMonsters;
		for(int i=0; i<restMonsters; i++) {
			tmp.name = tmp.name + String.valueOf(i+1);
			monsters.add(tmp);
		}
	}
}
