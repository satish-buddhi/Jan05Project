package com.company2;

import java.util.*;

public final class Sample {
    private Sample(){
    }
    public static void main(String[] args) {

        List<String> al = new ArrayList<>();
        al.add("s");
        al.add("a");
        al.add("s");
        System.out.println(al);
        al.toArray();
        Arrays.asList("","a");
        Set<String> hs = new HashSet<>();
        hs.add("st");
        hs.addAll(al);
        System.out.println(hs);
        Map<String, String> hm = new HashMap<>();
        hm.put("name","sairam");
        String s = "this is";
        Character c = s.charAt(0);
        String st = s.replace(s.charAt(0),Character.toUpperCase(c));
        System.out.println(st);
    }

    public void a(){

    }
    public int a(int a){return 1;}
}
