package game;
import enums.Species;

public class Monster extends Character{

	protected Item dropItem;
	protected Species species;

	public Monster(String _name, int _level, int _maxHP, int _AP, int _DP, Species _species, Item _dropItem) {
		super(_name, _level, _maxHP, _AP, _DP);
		dropItem = _dropItem;
		species = _species;
	}

	public void cure() {
		this.maxHP += 5;
	}
}
