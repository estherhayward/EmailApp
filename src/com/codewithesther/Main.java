package com.codewithesther;


public class Main {

    public static void main(String[] args) {
        EmailAccount john = new EmailAccount("John", "Smith Lee");
        john.showInfo();
        System.out.println(john.getPassword());
        john.changePassword("newpassword");
        System.out.println(john.getPassword());
        john.setAlternativeEmail("johncompany.com");
        System.out.println(john.getAlternativeEmail());
        john.setAlternativeEmail("john@myocmpany.com");
        System.out.println(john.getAlternativeEmail());
    }
}
