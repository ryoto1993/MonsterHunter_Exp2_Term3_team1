package game;

import java.util.LinkedList;
import java.util.Random;

public class Quest {
	protected String name;
	protected Item reward;
	protected LinkedList<Monster> monsters = new LinkedList<Monster>();
	protected LinkedList<Hunter> hunters = new LinkedList<Hunter>();
	protected int restMonsters;

	public Quest(String _questName, Item _reward, Monster _monster, int _restMonsters) {
		name = _questName;
		reward = _reward;
		Monster tmp = _monster;
		restMonsters = _restMonsters;
		for(int i=0; i<restMonsters; i++) {
			tmp.name = tmp.name + String.valueOf(i+1);
			monsters.add(tmp);
		}
	}

	public void joinInQuest(Hunter hunter) {
		hunters.add(hunter);
	}

	public void startBattle() {
		Boolean onBattle = true;
		Random rnd = new Random();
		Monster currentMonster = monsters.peek();

		while(onBattle) {
			for(int i=0; i<hunters.size(); i++) {
				hunters.get(i).battle(currentMonster);
				// ハンターが死んだら
				if(hunters.get(i).HP == 0) {
					hunters.remove(i);
					i--;
					// 全員死んだら
					if(hunters.size()==0) {
						System.out.println("クエストの参加者は全滅した．");
						onBattle = false;
						break;
					}
				}


				// モンスターが死んだら
				if(currentMonster.HP==0) {
					monsters.remove(currentMonster);
					restMonsters--;
					// 全員倒したら
					if(monsters.size()==0) {
						System.out.println("クエスト達成！");
						for(int j=0; j<hunters.size(); j++) {
							hunters.get(j).items.push(this.reward);
							System.out.println(hunters.get(j).name + "は，クエスト" + name + "を達成し，報酬として" + this.reward.name + "を手に入れた．");
						}
						onBattle = false;
					}
					break;
				}
			}

		}
	}
}
