package game;

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
		garm.makeQuests("Expert02", new Item(ItemName.Medicine), new BigMonster("ドラゴン", 7, 140, 30, 25, Species.Dragon, new Item(ItemName.Tail), 50), 4);

		garm.hunters.get(0).items.push(new Goods(ItemName.Medicine));

		garm.joinInQuest(garm.hunters.get(0));
		garm.joinInQuest(garm.hunters.get(1));

		garm.quests.get(3).startBattle();

	}
}
