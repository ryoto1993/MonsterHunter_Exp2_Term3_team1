package game;
import java.util.LinkedList;

import enums.ItemName;
import enums.Species;

public class Main {
	public static void main(String[] args) {

		Guild alice = new Guild("alice");
		alice.acceptHunter(new Hunter("Bob", 1, 100, 10, 20));
		alice.acceptHunter(new Hunter("Carroll", 10, 1000, 100, 200));
		alice.makeQuests("Donut", new Item(ItemName.Iron), new Monster("ウルフ", 3, 50, 10, 10, Species.Wolf, new Item(ItemName.Leather)), 3);
		alice.makeQuests("CupCake", new Item(ItemName.Iron), new Monster("ゴブリン", 1, 30, 5, 5, Species.Goblin, new Item(ItemName.Bone)), 1);
		alice.makeQuests("Eclair", new Item(ItemName.Iron), new BigMonster("ドラゴン", 5, 100, 15, 15, Species.Dragon, new Item(ItemName.Tail), 30), 1);


		LinkedList<Monster> goblins = new LinkedList<Monster>();
		LinkedList<Monster> wolfs = new LinkedList<Monster>();
		LinkedList<Monster> dragons = new LinkedList<Monster>();

		alice.hunters.get(0).quest = alice.getQuest();
		alice.hunters.get(0).battle(alice.hunters.get(0).quest.monsters.poll());

	}
}
