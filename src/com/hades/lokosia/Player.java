package com.hades.lokosia;

public class Player {
    static Player instance;
    private Weapon weapon;
    private Boon attack;
    private Boon special;
    private Boon cast;
    private Boon dash;
    private Boon call;
    private Boon[] passives;
    private int room;

    public void getInfo(){
        if(weapon != null) {
            String weaponStr = "Zagreus have %s with %s aspect;".formatted(weapon.getType(), weapon.getAspect());
            System.out.println(weaponStr);
        }
        System.out.println("Attack\t -\t" + attack);
        System.out.println("Special\t -\t" + special);
        System.out.println("Cast\t -\t" + cast);
        System.out.println("Dash\t -\t" + dash);
        System.out.println("Call\t -\t" + call);
        System.out.println("Passives -\t" + passives);
    }

    private Player(){

    }
    public static Player getInstance() {
        if(instance == null){
            instance = new Player();
            System.out.println("New player created!");
        }else{
            System.out.println("!==!Player changed!==!");
        }
        return instance;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Boon getAttack() {
        return attack;
    }

    public void setAttack(Boon attack) {
        this.attack = attack;
    }

    public Boon getSpecial() {
        return special;
    }

    public void setSpecial(Boon special) {
        this.special = special;
    }

    public Boon getCast() {
        return cast;
    }

    public void setCast(Boon cast) {
        this.cast = cast;
    }

    public Boon getDash() {
        return dash;
    }

    public void setDash(Boon dash) {
        this.dash = dash;
    }

    public Boon getCall() {
        return call;
    }

    public void setCall(Boon call) {
        this.call = call;
    }

    public Boon[] getPassives() {
        return passives;
    }

    public void setPassives(Boon[] passives) {
        this.passives = passives;
    }
}
