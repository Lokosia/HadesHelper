package com.hades.lokosia;

import com.hades.lokosia.enums.Gods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Setup {
    public final String WELCOME_MESSAGE = "Welcome to Lokosia's Hades game helper.";
    public final String WEAPON_TYPE_INPUT = "Please, choose your weapon and enter it's choice number:";
    public final String WEAPON_ASPECT_INPUT = "Please, choose your weapon aspect and enter it's choice number:";
    public final String NUMBER_CHOOSE_ERROR_MESSAGE = "No such choice available, please enter a valid choice number.";
    public final String BOONS_NUMBER = "How many boons you have to choose?";
    public final String MENU_WELCOME = "Please, choose an action:";
    public final String BOON_GOD_CHOOSE = "Choose god of boon:";

    public void menu(){
        System.out.println(MENU_WELCOME);
        //room rating
        //boon rating
        System.out.println("1. Room recommendation");
        System.out.println("2. Boon recommendation");
        if(choice(2) == 0){
            //room choosing
        }else{
            //boon choosing
            boonSetup();
        }
    }

    public void boonSetup() {
        System.out.println(BOON_GOD_CHOOSE);
        int numberOfGods = Gods.values().length;
        for (int i = 0; i < numberOfGods; i++) {
            System.out.println(i+1 + ". " + Gods.values()[i]);
        }
        var boonChoice = choice(numberOfGods);
        System.out.println(Arrays.toString(Gods.values()));
        System.out.println(Gods.values()[boonChoice]);
        var hj = BoonSearcher.search(Gods.values()[boonChoice]);

        //System.out.println(Arrays.toString(Gods.values()));

        //System.out.println(BOONS_NUMBER);
        // TODO: 11.03.2021 Make dynamic
        int numberOfBoons = 3;
        //ask for 3 boons, show their rating and ask to choose boon

        Boon[] boons = new Boon[numberOfBoons];



        //boon constructor
        //ask which god to choose
        //ask slot
        //ask rarity
        //show list of available boons according to god/slot/prereq-> enter number -> add that boon to "boons" var
    }

    public Weapon getWeapon() {
        HashMap<String, String[]> types = Weapon.WeaponPrefs();

        String[] weaponTypeArray = types.keySet().toArray(new String[0]);
        System.out.println(WEAPON_TYPE_INPUT);
        String weaponTypeChoice = weaponAndAspectFinder(weaponTypeArray);

        String[] weaponAspectsArray = types.get(weaponTypeChoice);
        System.out.println(WEAPON_ASPECT_INPUT);
        String weaponAspectChoice = weaponAndAspectFinder(weaponAspectsArray);

        Weapon weapon = Weapon.getInstance(weaponTypeChoice, weaponAspectChoice);

        return weapon;
    }

    public void start() {
        System.out.println(WELCOME_MESSAGE);
    }

    String weaponAndAspectFinder(String[] strings) {
        int arrLength = strings.length;
        for (int i = 0; i < arrLength; i++) {
            String str = (i + 1) + ". " + strings[i];
            System.out.println(str);
        }
        String tmpResult = strings[choice(arrLength)];
        System.out.println(tmpResult + " chosen...");
        return tmpResult;
    }

    int choice(int optionsNumber) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String userInput = reader.readLine();
                try {
                    int convertedInput = Integer.parseInt(userInput);
                    if (convertedInput > 0 && convertedInput <= optionsNumber) {
                        return choiceConverter(convertedInput);
                    } else {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println(NUMBER_CHOOSE_ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    int choiceConverter(int choice) {
        return choice - 1;
    }
}
