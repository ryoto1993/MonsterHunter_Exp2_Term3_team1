package game;

import java.util.Random;

public class Character {
	protected Random rnd = new Random();

	protected String name;
	protected int level;
	protected int maxHP; // HitPoint
	protected int HP;
	protected int AP; // AttackPoint
	protected int DP; // DefencePoint

	public Character(String _name,
			int _level,
			int _maxHP,
			int _AP,
			int _DP) {
		name = _name;
		level = _level;
		maxHP = _maxHP;
		AP = _AP;
		DP = _DP;
		HP = maxHP;
	}

	public void attack(Character _char) {
		int tmp = AP - (rnd.nextInt(20)-10) + DP;
		_char.HP = _char.HP - tmp <0 ? 0 : _char.HP - tmp ;
		System.out.println(name + "は" + _char.name + "に" + tmp + "のダメージを与えた！");
		System.out.println(_char.name + "の残りHP : " + _char.HP);
		if(_char.HP==0)
			System.out.println(_char.name + "は死んだ。");
	}
}
