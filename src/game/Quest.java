package game;
import enums.Species;

public class Quest {
	protected String name;
	protected Item reward;
	protected Species species;
	protected int restMonsters;

	public Quest(String _questName, Item _reward, Species _species, int _restMonsters) {
		name = _questName;
		reward = _reward;
		species = _species;
		restMonsters = _restMonsters;
	}
}
