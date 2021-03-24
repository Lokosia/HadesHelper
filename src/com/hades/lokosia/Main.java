package com.hades.lokosia;

import com.hades.lokosia.enums.Gods;
import com.hades.lokosia.enums.Slots;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player player = Player.getInstance();

        Setup setup = new Setup();
        setup.start();

        player.setWeapon(setup.getWeapon());

        setup.menu();
        //player.getInfo();
        //BoonSearcher boonSearcher = new BoonSearcher();
        //boonSearcher.search(Gods.APHRODITE, Slots.Attack);
    }
}
