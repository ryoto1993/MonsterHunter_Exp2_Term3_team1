package game;
import enums.Species;

import java.util.Random;

public class Monster extends Character{

	protected Item dropItem;
	protected Species species;

	public Monster(String _name, int _level, int _maxHP, int _AP, int _DP, Species _species, Item _dropItem) {
		super(_name, _level, _maxHP, _AP, _DP);
		dropItem = _dropItem;
		species = _species;
	}

	public void attack(Character _char) {
		Random rnd = new Random();

		if(rnd.nextInt(100)<30) {
			cure();
		} else {
			super.attack(_char);
		}

	}

	public void cure() {
		this.HP += this.maxHP*0.1;
		System.out.println(this.name + "は，HPを" + (int)(this.maxHP*0.1) + "自己回復した!");
	}
}
