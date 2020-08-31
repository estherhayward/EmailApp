package com.codewithesther;

import java.util.Scanner;

public class EmailAccount {

    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String alternativeEmail;
    private String password;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 1000;
    private String companySuffix = "company.com";


    public EmailAccount(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email created for " + firstName + " " + lastName);

        setDepartment();

        generateEmail();

        randomPassword(defaultPasswordLength);
    }

    private String setDepartment() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter department code:\n0 for sales\n" +
                "1 for development\n2 for accounting\n3 for none");
        int departmentChoice = in.nextInt();

        switch(departmentChoice) {
            case 0:
                this.department = "sales";
                break;
            case 1:
                this.department = "development";
                break;
            case 2:
                this.department = "accounting";
                break;
            default:
                this.department = "";
        }
        return this.department;
    }

    private void emailWithoutDepartmentName() {
         this.email = this.firstName.toLowerCase().replaceAll("\\s+", "")
                 + "." + this.lastName.toLowerCase().replaceAll("\\s+", "")
                 + "@" + this.companySuffix;
    }

    private void emailWithDepartmentName() {
         this.email = this.firstName.toLowerCase().replaceAll("\\s+", "")
                 + "." + this.lastName.toLowerCase().replaceAll("\\s+", "")
                 + "@" + this.department.toLowerCase() + "." + this.companySuffix;
    }

    private String generateEmail() {
        if (this.department == "") {
            emailWithoutDepartmentName();
        } else {
            emailWithDepartmentName();
        }

        return this.email;
    }

    private String randomPassword(int length) {
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                    "abcdefghijklmnopqrstuvwxyz" +
                                    "0123456789" +
                                    "!@#$%^&*?";

        char[] password = new char[length];

        for (int i = 0; i < password.length; i++) {

            int random = (int) (Math.random() * passwordCharacters.length());
            password[i] = passwordCharacters.charAt(random);
        }
        return this.password = new String(password);
    }

    private void includeAlternativeEmail() {
        System.out.println("Email created for " + getName() + ".\n" +
                "Email: " + getEmail() + "\n" + "Password: " + getPassword());
    }

    public void showInfo() {
        System.out.println("Email created for " + getName() + ".\n" +
                "Address: " + getEmail() + "\n" + "Mailbox capacity: " +
                getMailboxCapacity() + "mb.");
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        if (alternativeEmail.contains("@")) {
            this.alternativeEmail = alternativeEmail;
        } else {
            System.out.println(alternativeEmail + " is not valid." +
                    " Please enter a valid email address.");
        }
    }

    public String getEmail() {
        return this.email;
    }

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getAlternativeEmail() {
        return this.alternativeEmail;
    }

}
