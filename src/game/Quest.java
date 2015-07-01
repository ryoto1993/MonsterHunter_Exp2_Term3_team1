package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			monsters.add(new Monster(tmp.name + String.valueOf(i+1), tmp.level, tmp.maxHP, tmp.AP, tmp.DP, tmp.species, tmp.dropItem));
		}
	}

	public void startBattle() {
		Boolean onBattle = true;
		Random rnd = new Random();
		Monster currentMonster = monsters.peek();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sw = -1;
		Goods goods = null;



		while(onBattle) {
			for(int i=0; i<hunters.size(); i++) {

				System.out.println(hunters.get(i).name + "はどうする？");
				System.out.println("0 : アイテムを使う　｜ 1 : 攻撃する");
				System.out.print("Command >> ");
				try {
					sw = Integer.parseInt(br.readLine());
				} catch (Exception e) {

				}

				switch (sw) {
					case 0:
						System.out.println("=== 所持アイテム一覧 ===");
						System.out.println("　 アイテム　　回復HP");
						for(int j=0; j<hunters.get(i).items.size(); j++) {
							if(hunters.get(i).items.get(j).getClass().equals(Goods.class)) {
								System.out.print(j + ":");
								System.out.print(String.format("  %-11s", hunters.get(i).items.get(j).name));
								Goods tmp = (Goods)(hunters.get(i).items.get(j));
								System.out.println(String.format("%-6s", tmp.plusHP));
							}
						}
						System.out.println("=========================");
						System.out.print("使用アイテム >> ");
						try {
							int tmp = Integer.parseInt(br.readLine());
							if (tmp>=hunters.get(i).items.size() || tmp < 0) {
								System.out.println("そのアイテムは使えない!");
							}
							else if (hunters.get(i).items.get(tmp).getClass().equals(Goods.class)) {
								goods = (Goods)hunters.get(i).items.get(tmp);
								hunters.get(i).items.remove(tmp);
							} else {
								System.out.println("そのアイテムは使えない!");
							}

						} catch (IOException e) {}
						hunters.get(i).battle(currentMonster, goods);
						goods = null;
						break;
					default:
						hunters.get(i).battle(currentMonster, null);
						break;
				}

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
					monsters.remove();
					restMonsters--;
					currentMonster = monsters.peek();
					// 全員倒したら
					if(monsters.size()==0) {
						System.out.println("クエスト達成！");
						for(int j=0; j<hunters.size(); j++) {
							hunters.get(j).items.push(this.reward);
							System.out.println(hunters.get(j).name + "は，クエスト" + name + "を達成し，報酬として" + this.reward.name + "を手に入れた．");
						}
						onBattle = false;
					}
				}
			}

		}
	}
}
