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
	}

	public void makeQuests(String _questName, Item _reward, Monster _monster, int _restMonsters) {
		quests.add(new Quest(_questName, _reward, _monster, _restMonsters));
	}
	public void acceptHunter(Hunter _hunter) {
		hunters.add(_hunter);
	}
	public Quest getQuest() {
		int tmp = 0;
		Quest qtmp;

		showQuest();
		
		System.out.println("どのクエストを受注しますか? >");
		try{
			tmp = Integer.parseInt(br.readLine());
		} catch(IOException e){ }

		if(tmp<quests.size() && tmp>=0) {
			qtmp = quests.get(tmp-1);
			quests.remove(tmp-1);
			return qtmp;
		} else {
			return null;
		}

	}
	public int joinInQuest(Hunter hunter) {

		int tmp = 0;
		Quest qtmp;

		showQuest();

		System.out.println("どのクエストを受注しますか? >");
		try{
			tmp = Integer.parseInt(br.readLine());
		} catch(IOException e){ }
		/*
		if(tmp<quests.size() && tmp>=0) {
			qtmp = quests.get(tmp-1);
			quests.remove(tmp-1);

			hunters.add(hunter);
			//return qtmp;
		} else {
			//return null;
		}
*/


		hunters.add(hunter);
		return tmp;
	}
	public void showQuest(){
		System.out.println("受注できるクエスト一覧");
		System.out.println("　 クエスト名　報酬　モンスター　数");
		for(int i=0; i<quests.size(); i++){
			System.out.print(i+1+":");
			System.out.print(String.format(" %-10s", quests.get(i).name));
			System.out.print(String.format("%-6s", quests.get(i).reward.name));
			System.out.print(String.format("%-10s", quests.get(i).monsters.peek().species.name()));
			System.out.println(String.format("%-2d", quests.get(i).restMonsters));


		}
		System.out.println("");
	}

}
