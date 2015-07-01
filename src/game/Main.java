package game;
import java.util.LinkedList;

import enums.ItemName;
import enums.Species;

public class Main {
	public static void main(String[] args) {

		Guild garm = new Guild("Garm");
		garm.acceptHunter(new Hunter("Alex", 1, 100, 10, 20));
		garm.acceptHunter(new Hunter("Betty", 10, 1000, 100, 200));
		garm.makeQuests("Novice01", new Item(ItemName.Iron), new Monster("ウルフ", 3, 50, 10, 10, Species.Wolf, new Item(ItemName.Leather)), 3);
		garm.makeQuests("Novice02", new Item(ItemName.Iron), new Monster("ゴブリン", 1, 30, 5, 5, Species.Goblin, new Item(ItemName.Bone)), 1);
		garm.makeQuests("Expert01", new Item(ItemName.Iron), new BigMonster("ドラゴン", 5, 100, 15, 15, Species.Dragon, new Item(ItemName.Tail), 30), 1);

		garm.hunters.get(0).quest = alice.getQuest();
		garm.hunters.get(0).battle(alice.hunters.get(0).quest.monsters.poll());

	}
}
