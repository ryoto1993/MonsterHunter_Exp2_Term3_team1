package game;

import enums.ItemName;

public class Goods extends Item {
    protected int plusHP;

    public Goods(ItemName _name) {
        super(_name);
        switch (_name) {
            case Medicine:
                this.plusHP = 10;
                break;

        }
    }

    public int useItem() {
        System.out.println (name + "を使ってHPを" + plusHP + "回復した!");
        return  plusHP;
    }
}
