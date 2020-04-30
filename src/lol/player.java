package lol;

import java.util.ArrayList;

public class player {
    private String account;
    private String missionId;
    private String hero;
    private ArrayList<String> equipments = new ArrayList<String>();
    private int assistants;
    private int kills;
    private int killedSoldiers;
    private int missionScore;
    private int amountScore;
    private int heroLevel;

    public void setAccount (String account) {
        this.account = account;
    }

    public void setMissionId (String missionId) {
        this.missionId = missionId;
    }

    public void setHero (String hero) {
        this.hero = hero;
    }

    public void addEquipments (String equipment) {
        // 添加装备 并且没添加一件装备得分就+5,历史累计得分也要加
        this.equipments.add(equipment);
        this.missionScore += 5;
        this.amountScore +=5;
        setHeroLevel();
    }

    public void addAssistants () {
        // 计算助攻，并且每获得一次助攻得分就+10，历史得分也要加
        this.assistants ++;
        this.missionScore += 10;
        this.amountScore += 10;
        setHeroLevel();
    }

    public void addKills () {
        this.kills ++;
        this.missionScore += 20;
        this.amountScore += 20;
        setHeroLevel();
    }

    public void addKilledSoldiers () {
        this.killedSoldiers ++;
        this.missionScore += 2;
        this.amountScore += 2;
        setHeroLevel();
    }

    private void setHeroLevel() {
        // 更新英雄等级的方法
        if(this.amountScore >= 0 && this.amountScore < 100){
            this.heroLevel = 1;
        }
        else if(this.amountScore >= 100 && this.amountScore < 200){
            this.heroLevel = 2;
        }
        else if(this.amountScore < 300){
            this.heroLevel = 3;
        }
        else {
            this.heroLevel = 4;
        }
    }

    public String getAccount() {
        return account;
    }

    public String getMissionId() {
        return missionId;
    }

    public int getAssistants() {
        return assistants;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public int getMissionScore() {
        return missionScore;
    }
}
