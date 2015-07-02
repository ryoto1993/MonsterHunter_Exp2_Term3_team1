package game;

import java.util.Random;

import enums.Species;

public class BigMonster extends Monster{

	protected int specialAP;
	Random rnd = new Random();

	public BigMonster(String _name, int _level, int _maxHP, int _AP, int _DP, Species _species, Item _dropItem, int _specialAP) {
		super(_name, _level, _maxHP, _AP, _DP, _species, _dropItem);
		specialAP = _specialAP;
	}

	public void attack(Character _char) {
		if(rnd.nextInt(100)<40){
			int tmp = specialAP - (rnd.nextInt(20)-10) + DP;
			_char.HP = _char.HP - tmp <0 ? 0 : _char.HP - tmp ;
			System.out.println(name + "は" + _char.name + "に" + tmp + "特別ダメージを与えた！");
			System.out.println(_char.name + "の残りHP : " + _char.HP);
			if(_char.HP==0)
				System.out.println(_char.name + "は死んだ。");
		}
		else{
			int tmp = AP - (rnd.nextInt(20)-10) + DP;
			_char.HP = _char.HP - tmp <0 ? 0 : _char.HP - tmp ;
			System.out.println(name + "は" + _char.name + "に" + tmp + "ダメージを与えた！");
			System.out.println(_char.name + "の残りHP : " + _char.HP);
			if(_char.HP==0)
				System.out.println(_char.name + "は死んだ。");
		}

	}
}
