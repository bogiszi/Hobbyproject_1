package com.jetbrains.ideatest2;

import java.util.HashMap;
import java.util.Map;

public class QuestionsAndAnswers {

    protected Map<String, Integer> questionsAndAnswers;

    public QuestionsAndAnswers() {
        this.questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put("1995-ben ki volt az USA elnöke?;Bill Clinton",1);
        questionsAndAnswers.put("Mennyi 5 * 64?;320",1);
        questionsAndAnswers.put("Ki volt Az árvízi hajós?;Wesselényi Miklós",2);
        questionsAndAnswers.put("Ki volt Orpheusz felesége?;Eurüdiké",2);
        questionsAndAnswers.put("Mikor gyártották az első Trabantot?;1957",2);
        questionsAndAnswers.put("Mi volt Szombahely ókori latin neve?;Savaria",1);
        questionsAndAnswers.put("Milyen magas a Szent István-bazilika?;96",3);
        questionsAndAnswers.put("Hány gyermeke született Károly Walesi hercegnek?;2",3);
        questionsAndAnswers.put("Hány felesége volt VIII. Henrik angol királynak?;6",2);
        questionsAndAnswers.put("Mikor kezdte meg a Magyar Rádió az adását?;1925",3);
        questionsAndAnswers.put("Hány aradi vértanú volt?;13",1);
        questionsAndAnswers.put("Melyik ország fővárosa Helsinki?;Helsinki",1);
        questionsAndAnswers.put("Melyik államban van Dallas?;Texas",1);
        questionsAndAnswers.put("Melyik a Föld leghosszabb folyója?;Amazonas",2);
        questionsAndAnswers.put("Mi Norvégia fővárosa?;Oslo",1);
        questionsAndAnswers.put("Melyik óceánban vannak a Seychelle-szigetek?;Indiai",2);
        questionsAndAnswers.put("Hány megyéből áll Magyarország?;19",1);
        questionsAndAnswers.put("Mi a Csomolungma hegy másik elnevezése?;Mount Everest",1);
        questionsAndAnswers.put("1988-ban melyik film kapott Oscar-díjat?;Esőember",3);
        questionsAndAnswers.put("Hol kerül sor az Oscar-díj átadásra?;Hollywood",1);
        questionsAndAnswers.put("Hány cm magas volt Yoda a Star Wars szereplője?;66",3);
        questionsAndAnswers.put("Milyen állat Garfield?;macska",1);
        questionsAndAnswers.put("Melyik rajzfilm szereplője Grabowski?;Macskafogó",2);
        questionsAndAnswers.put("Hány évente kerül megrendezésre a labdarúgó EB?;4",1);
        questionsAndAnswers.put("Milyen poszton játszott Puskás Öcsi, a legendás labdarúgó?;csatár",1);
        questionsAndAnswers.put("Maradona hányas mezt viselt?;10",2);
        questionsAndAnswers.put("Szilágyi Áron melyik sportág olimpiai bajnoka?;kardvívás",3);
        questionsAndAnswers.put("Hosszú Katinka melyik sportág világbajnoka?;úszás",1);
        questionsAndAnswers.put("Mi az állkapocscsont latin neve?;mandibula",3);
        questionsAndAnswers.put("Mi alapján tájékozódik a delfin?;visszhang",3);
        questionsAndAnswers.put("Mennyi az elefántok vemhességi ideje hónapban?;22",3);
        questionsAndAnswers.put("Melyik növény a sörfőzés alapanyaga?;árpa",1);
        questionsAndAnswers.put("Hol él a koala?;Ausztrália",2);
        questionsAndAnswers.put("Melyik a természetben előforduló legkeményebb ásvány?;gyémánt",1);
        questionsAndAnswers.put("Milyen állat a bonobó?;majom",2);
        questionsAndAnswers.put("Milyen állat a gangeszi gaviál?;hüllő",3);
        questionsAndAnswers.put("Kinek az operája A Varázsfuvola?;Mozart",2);
        questionsAndAnswers.put("Mi volt Zámbó Jimmy eredeti keresztneve?;Imre",2);
        questionsAndAnswers.put("Milyen autómárka a Ferrari?;olasz",1);
        questionsAndAnswers.put("Mi a kén vegyjele?;S",1);
        questionsAndAnswers.put("Mit jelent a CPU?;processzor",1);

    }

    public Map<String, Integer> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public void setQuestionsAndAnswers(Map<String, Integer> questionsAndAnswers) {
        this.questionsAndAnswers = questionsAndAnswers;
    }

    public void removeQuestionAndAnswer(String input) {
        questionsAndAnswers.remove(input);
    }
}
