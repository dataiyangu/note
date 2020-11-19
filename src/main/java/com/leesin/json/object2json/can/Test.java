package com.leesin.json.object2json.can;

import java.text.ParseException;

public class Test {
    // 格式：对象()
    private static final String OBJECT_STRING =
            "BiggieWeeklyReportDTO(biggieWeeklyIncomeDTO=BiggieWeeklyIncomeDTO(orderTotalIncome=0.2, orderTotalIncomeDesc=超过了平台s%的大神, totalIncomePercentage=1, orderAmountDiffLastWeek=-0.15), biggieWeeklyDayIncomeDTO=BiggieWeeklyDayIncomeDTO(monIncome=0, monday=Mon Oct 12 00:00:00 CST 2020, tueIncome=0, tuesday=Tue Oct 13 00:00:00 CST 2020, wedIncome=0, wednesday=Wed Oct 14 00:00:00 CST 2020, thuIncome=0, thursday=Thu Oct 15 00:00:00 CST 2020, friIncome=0, friday=Fri Oct 16 00:00:00 CST 2020, satIncome=0, saturday=Sat Oct 17 00:00:00 CST 2020, sunIncome=0, sunday=Sun Oct 18 00:00:00 CST 2020, averageIncome=0), biggieWeeklyActiveDTO=BiggieWeeklyActiveDTO(orderNum=0, orderNumDesc=null, orderChangeNum=0, bossNum=0, bossNumDesc=null, bossChangeNum=0, publishNum=0, publishNumDesc=null, publishChangeNum=0, repurchaseNum=0, repurchaseNumDesc=快去问问旧金主今天要不要一起打游戏8, repurchaseChangeNum=0), bossContributionList=[], potentialBossesList=[PotentialBossDTO(uid=192881199214980004, avatar=https://tphoto.bxapp.cn/upload/6F36786C-922B-4D0B-B790-221A3E5BC899.jpg, nickname=Huishao, vipIcon=https://tphoto.bxapp.cn/c2357afab6b3403cb96245f9d9581e26.png, gender=1), PotentialBossDTO(uid=193530671217750004, avatar=https://tphoto.bxapp.cn/upload/86f23d20-9092-4a2d-befd-875dfbec4df7.jpg, nickname=我的名字非常的长。。, vipIcon=null, gender=1), PotentialBossDTO(uid=190220662020870010, avatar=https://tphoto.bxapp.cn/upload/6c5d1541-a4f0-423d-888e-57ded6b1efaa.jpg, nickname=美好生活\uD83D\uDE0A, vipIcon=null, gender=1)], biggieScore=BiggieScoreDTO(uid=191371015411030019, biggieScore=600, biggieExpText=主动抢/派单，可获得更多老板，提升大神分, certification=false), visitorsNumber=VisitorsNumberDTO(pageUvTotalLastWeek=5, pageUvTotalDiffLastWeek=-2, certification=false))"
    ;


    public static void main(String[] args) throws ParseException {
        System.out.println(ToStringUtils.toJSONString(OBJECT_STRING));
        //System.out.println("a");
    }

    public static void set(int a,int b) {

    }
}
