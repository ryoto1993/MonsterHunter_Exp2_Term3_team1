package game;
import java.util.LinkedList;

import enums.ItemName;
import enums.Species;

public class Main {
	public static void main(String[] args) {

		Guild alice = new Guild("alice");
		alice.acceptHunter(new Hunter("Bob", 1, 100, 10, 20));
		alice.acceptHunter(new Hunter("Carroll", 10, 1000, 100, 200));
		alice.makeQuests("Donut", new Item(ItemName.Iron), Species.Wolf, 3);
		alice.makeQuests("CupCake", new Item(ItemName.Iron), Species.Goblin, 1);
		alice.makeQuests("Eclair", new Item(ItemName.Iron), Species.Dragon, 1);


		LinkedList<Monster> goblins = new LinkedList<Monster>();
		LinkedList<Monster> wolfs = new LinkedList<Monster>();
		LinkedList<Monster> dragons = new LinkedList<Monster>();

		for(int i=0; i<10; i++) {
			goblins.push(new Monster("ゴブリン"+i, 1, 30, 5, 5, Species.Goblin, new Item(ItemName.Bone)));
			wolfs.push(new Monster("ウルフ"+i, 3, 50, 10, 10, Species.Wolf, new Item(ItemName.Leather)));
			dragons.push(new BigMonster("ドラゴン"+i, 5, 100, 15, 15, Species.Dragon, new Item(ItemName.Tail), 30));
		}


		alice.hunters.get(0).quest = alice.getQuest();
		alice.hunters.get(0).buttle(goblins.poll());

	}
}
