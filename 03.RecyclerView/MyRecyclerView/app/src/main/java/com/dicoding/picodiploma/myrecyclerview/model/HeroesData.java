package com.dicoding.picodiploma.myrecyclerview.model;

import java.util.ArrayList;

/**
 * Created by sidiqpermana on 10/29/16.
 */

public class HeroesData {
    public static String[][] data = new String[][]{
            {"Cut Nyak Dien", "Pahlawan dari Aceh", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Tjoet_Nya%27_Dhien.jpg/220px-Tjoet_Nya%27_Dhien.jpg"},
            {"Ki Hajar Dewantara", "Pahlawan dari Yogyakarta", "https://upload.wikimedia.org/wikipedia/commons/3/3a/Ki_Hadjar_Dewantara_Mimbar_Umum_18_October_1949_p2.jpg"},
            {"Moh Yamin", "Pahlawan dari Sumatera Barat", "https://upload.wikimedia.org/wikipedia/commons/6/62/Mohammad_Yamin%2C_Pekan_Buku_Indonesia_1954%2C_p251.jpg"},
            {"Patimura", "Pahlawan dari Maluku", "https://cdns.klimg.com/merdeka.com/i/w/tokoh/2012/03/15/4595/200x300/kapitan-pattimura.jpg"},
            {"R A Kartini", "Pahlawan dari Jepara", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/COLLECTIE_TROPENMUSEUM_Portret_van_Raden_Ajeng_Kartini_TMnr_10018776.jpg/440px-COLLECTIE_TROPENMUSEUM_Portret_van_Raden_Ajeng_Kartini_TMnr_10018776.jpg"},
            {"Sukarno", "Pahlawan dari Surabaya", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Presiden_Sukarno.jpg/440px-Presiden_Sukarno.jpg"},
            {"Tuanku Imam Bonjol", "Pahlawan dari Sumatera Barat", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Portret_van_Tuanku_Imam_Bonjol.jpg/440px-Portret_van_Tuanku_Imam_Bonjol.jpg"},
            {"Pangeran Antasari", "Pahlawan dari Banjar", "https://upload.wikimedia.org/wikipedia/id/thumb/c/c8/Pangeran_Antasari_Museum_Lambung_Mangkurat.JPG/440px-Pangeran_Antasari_Museum_Lambung_Mangkurat.JPG"},
            {"Bung Tumo", "Pahlawan dari Surabaya", "https://upload.wikimedia.org/wikipedia/commons/e/ed/Bung_Tomo.jpg"},
            {"Mohammad Hatta", "Pahlawan dari Sumatera Barat", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/VP_Hatta.jpg/440px-VP_Hatta.jpg"},
    };

    public static ArrayList<Hero> getListData(){
        ArrayList<Hero> list = new ArrayList<>();
        for (String[] aData : data) {
            Hero hero = new Hero();
            hero.setName(aData[0]);
            hero.setFrom(aData[1]);
            hero.setPhoto(aData[2]);

            list.add(hero);
        }

        return list;
    }
}
