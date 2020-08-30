package com.codewithesther;


public class Main {

    public static void main(String[] args) {
        EmailAccount emilia = new EmailAccount("Emilia", "van Poelgeest");
        emilia.showInfo();
        System.out.println(emilia.getPassword());
        emilia.changePassword("pandaPower");
        System.out.println(emilia.getPassword());
        emilia.setAlternativeEmail("emiliacompany.com");
        System.out.println(emilia.getAlternativeEmail());
    }
}
