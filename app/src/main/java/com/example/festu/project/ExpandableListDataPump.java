package com.example.festu.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("Safaricom to shut down services");
        cricket.add("Six killed, thousands displaced by heavy rainfall");
        cricket.add("Controversial doctor faces charges of stealing body organs");
        cricket.add("Movie goers enjoy premiere of ‘Avengers: Infinity War’ – PHOTOS");
        cricket.add("STUDY: Staring at women’s boobs is among 6 ways men can live longer");

        List<String> football = new ArrayList<String>();
        football.add("Soon to be sold’ Wanyama gets Tottenham fans’ backing");
        football.add("Trump warns FKF over its opposition to US 2026 Fifa World Cup bid");
        football.add("Walusimbi returns to the fold after long layoff at Gor Mahia");
        football.add("Tottenham ready to offload Wanyama for Sh7 billion");
        football.add("Woeful Arsenal throw away best shot at reaching Europa final");

        List<String> basketball = new ArrayList<String>();
        basketball.add("MPs want more money from Kenyans, again!");
        basketball.add("WhatsApp kicking out pre-16 users from their platform");
        basketball.add("Matatus have until Monday to move out of CBD");
        basketball.add("Kenyans troll tweep who notified Safaricom of Bonga Points hitch");
        basketball.add("How Kenyans cashed in on Safaricom’s Bonga Points hitch");

        expandableListDetail.put("LATEST NEWS", cricket);
        expandableListDetail.put("BUSSINESS NEWS", basketball);
        expandableListDetail.put("SPORT NEWS", football);

        return expandableListDetail;
    }
}