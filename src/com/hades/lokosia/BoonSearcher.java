package com.hades.lokosia;

import com.hades.lokosia.enums.Gods;
import com.hades.lokosia.enums.Slots;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

import java.io.File;
import java.io.IOException;

public class BoonSearcher {


    public static Boon search(Gods god) {
        String boonsDBPath = "src/com/hades/lokosia/boons/";
        try {
            String neededBase = switch(god){
                case APHRODITE -> "AphroditeBoons.html";
                case ARES -> "AresBoons.html";
                case ARTEMIS -> "ArtemisBoons.html";
                case ATHENA -> "AthenaBoons.html";
                case CHAOS -> "ChaosBoons.html";
                case DEMETER -> "DemeterBoons.html";
                case DIONYSUS -> "DionysusBoons.html";
                case HERMES -> "HermesBoons.html";
                case POSEIDON -> "PoseidonBoons.html";
                case ZEUS -> "ZeusBoons.html";
            };
            File input = new File(boonsDBPath + neededBase);
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            Elements boons = doc.select("table tbody tr:not(table tbody tr tbody tr)");
            for (Element boon : boons) {
                //System.out.println(boon.text());
                //Name
                var name1 = boon.selectFirst("td.boonTableName");
                if (name1 != null) {
                    System.out.println("");
                    var name2 = name1.selectFirst("b");
                    System.out.println("Name: " + name2.text());
                }
                //Description
                var description = boon.selectFirst("td.boonTableDescription");
                if (description != null) {
                    System.out.println("Description: " + description.text());
                }
                //Rarity
                var rarityTableUnformatted = boon.selectFirst("tbody");
                if (rarityTableUnformatted != null) {
                    System.out.println("Rarity:");
                    var rarityTableFormatted = rarityTableUnformatted.select("tr");
                    for (Element element : rarityTableFormatted) {
                        String p1 = element.selectFirst("td").text();
                        String p2 = element.selectFirst("li").text();
                        System.out.println(p1 + " " + p2);
                    }
                } else {
                    var rarityFinder = boon.selectFirst("td[style]");
                    if (rarityFinder != null) {
                        System.out.println("Rarity: " + rarityFinder.text());
                    }
                }
                //Notes
                var notes = boon.selectFirst("td.boonTableNotes");
                if (notes != null) {
                    System.out.println("Notes: " + notes.text());
                }
                //Prereqs
                var prereqs = boon.selectFirst("td.boonTablePrereqs");
                if (prereqs != null) {
                    System.out.println("Prerequisites: " + prereqs.text());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
