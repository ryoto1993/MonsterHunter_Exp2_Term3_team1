package game;

import enums.Species;

public class BigMonster extends Monster{

	protected int specialAP;

	public BigMonster(String _name, int _level, int _maxHP, int _AP, int _DP, Species _species, Item _dropItem, int _specialAP) {
		super(_name, _level, _maxHP, _AP, _DP, _species, _dropItem);
		specialAP = _specialAP;
	}

	public void specialAttack() {

	}


}
