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
	public void attack(Monster _char) {
		super.attack(_char);
		if(_char.HP==0) {
			items.push(_char.dropItem);
			System.out.println(name + "は" + _char.name + "から" + _char.dropItem.name + "を奪った。");
		}
	}
	
	public void battle(Monster _monster) {
		while(true) {
			attack(_monster);

			if(_monster.HP==0) {
				System.out.println(name + "は" + _monster.name + "を倒した．");
				break;
			}
			_monster.attack(this);
			if(HP==0) {
				System.out.println(name + "は" + _monster.name + "に殺害された．");
				break;
			}
		}
	}

}
