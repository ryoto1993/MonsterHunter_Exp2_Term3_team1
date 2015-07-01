package game;

import java.util.LinkedList;

public class Hunter extends Character{

	protected Guild myGuild;
	protected Armor armor;
	protected Weapon weapon;
	protected LinkedList<Item> items = new LinkedList<Item>();
	
	public Hunter(String _name, int _level, int _HP, int _AP, int _DP) {
		super(_name, _level, _HP, _AP, _DP);

	}

	public void useItem(Item _item) {
		//
	}
	
	public void battle(Monster _monster) {
		attack(_monster);

		if(_monster.HP==0) {
			System.out.println(this.name + "は" + _monster.name + "を倒した．");
			items.push(_monster.dropItem);
			System.out.println(name + "は" + _monster.name + "から" + _monster.dropItem.name + "を奪った。");
			return;
		}
		_monster.attack(this);
		if(HP==0) {
			System.out.println(this.name + "は" + _monster.name + "に殺害された．");
			return;
		}
	}

}
