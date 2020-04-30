package lol;

public class playDemo {
  public static void main(String[] args) {
      player p1 = new player();
      p1.setAccount("景");
      p1.setHero("剑圣");
      p1.setMissionId("弗雷尔卓德-1001");

      p1.addEquipments("多兰剑");
      p1.addKilledSoldiers();
      p1.addKilledSoldiers();
      p1.addKilledSoldiers();
      p1.addKilledSoldiers();
      p1.addKills();
      p1.addKills();
      p1.addKills();
      p1.addKills();
      p1.addKills();
      p1.addKills();
      p1.addKills();
      p1.addEquipments("破败");
      p1.addEquipments("攻速鞋");
      p1.addAssistants();
      p1.addAssistants();
      p1.addAssistants();
      p1.addAssistants();
      p1.addAssistants();
      System.out.println("玩家等级"+p1.getHeroLevel());
      System.out.println("玩家得分"+p1.getMissionScore());
      System.out.println("玩家账号"+p1.getAccount());
  }
}
