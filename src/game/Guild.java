package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

import enums.Species;

public class Guild {
	protected String name;
	protected ArrayList<Hunter> hunters = new ArrayList<Hunter>();
	protected LinkedList<Quest> quests = new LinkedList<Quest>();

	protected BufferedReader br =
			new BufferedReader(new InputStreamReader(System.in));

	public Guild(String _name) {
		name = _name;
		System.out.println(name + "ギルドを生成しました。");
		System.out.println();
	}

	public void makeQuests(String _questName, Item _reward, Monster _monster, int _restMonsters) {
		quests.add(new Quest(_questName, _reward, _monster, _restMonsters));
	}
	public void acceptHunter(Hunter _hunter) {
		hunters.add(_hunter);
	}

	public void joinInQuest(Hunter hunter) {
		int tmp = 0;

		System.out.println(hunter.name + "はどのクエストを受注しますか?");

		showQuest();

		System.out.print("クエスト番号 >> ");

		try{
			tmp = Integer.parseInt(br.readLine());
		} catch(IOException e){ }

		if(tmp<quests.size() && tmp>=0) {
			System.out.println();
			quests.get(tmp).hunters.add(hunter);
		} else {
			System.out.println("クエストに参加できませんでした．");
			System.out.println();
		}


	}
	public void showQuest(){
		System.out.println("====== 受注できるクエスト一覧 ======");
		System.out.println("　 クエスト名　報酬　モンスター　数");
		for(int i=0; i<quests.size(); i++){
			System.out.print(i+":");
			System.out.print(String.format("  %-11s", quests.get(i).name));
			System.out.print(String.format("%-6s", quests.get(i).reward.name));
			System.out.print(String.format("%-12s", quests.get(i).monsters.peek().species.name()));
			System.out.println(String.format("%-2d", quests.get(i).restMonsters));
		}
		System.out.println("====================================");
	}

}
