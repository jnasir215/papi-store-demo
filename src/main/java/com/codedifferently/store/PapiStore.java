package com.codedifferently.store; //Code Differently package

import java.util.ArrayList; //ArrayList Class imported from java.util package
import java.util.HashMap;   //HashMap Class imported from java.util package
import java.util.Map;       //Map Class imported from java.util package

public class PapiStore {                //PapiStore Class declaration (Part of the .store Code Differently package
    private boolean isStoreOpen;        //Private boolean variable to determine whether or not the store is open
    private ArrayList<String> tabs;     //Private arrayList to store new String variables
    Map<String, Double> owesPapiMoney;  //Map variable to store who is available to have a tab and whether or not they owe money

    public PapiStore(){                 //Constructor of PapiStore Class -> declares beginning state of the class
        this.isStoreOpen = false;       //Declares the beginning state of the store as 'closed'
        this.tabs = new ArrayList();    //Declares an pointer ArrayList Class for usage throughout
        this.owesPapiMoney = new HashMap<>();   //Declares a pointer HashMap Class for usage throughout
    }

    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){ //Second Constructor of PapiStore Class accepting incoming parameters
        this.isStoreOpen = isOpen;      //Declares the beginning state of the store as 'open'
        this.tabs = tabsIn;             //Declares an ArrayList variable for usage throughout
        this.owesPapiMoney = new HashMap<>();   //Declares a pointer HashMap Class for usage throughout
    }

    public void closeStore(){           //Method to be called to 'close' the store

    }

    public void openStore(){            //Method to be called to 'open' the store
        this.isStoreOpen = true;        //Declares the store as 'open for business'
    }

    public boolean isStoreOpen() {      //Method to be called to return current state of store (open or closed?)
        return isStoreOpen;             //Returns the current state of the store (open or closed?)
    }


    public Boolean allowToUseTab(String name){  //Method to be called to see if the name being passed in is 'allowed to have a tab'
        Boolean response = false;               //Default response to this method is "No, this person is 'not allowed to have a tab'"
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))  //If person has a tab and does not have an overdue balance
            response = true;                    //...tells the program that this person 'is allowed to use a tab'
        return response;                        //Returns whether or not the person is 'allowed to use a tab'
    }

    private boolean hasAnOverDueBalance(String name){   //Method to be called to see if the name being passed in 'has an overdue balance'
        if(!owesPapiMoney.containsKey(name))    //If any item in the HashMap list does not match the name being passed into the method
            return false;                       //...tells the program that this person 'does not have an overdue balance
        Double money = owesPapiMoney.get(name); //Local variable that assigns a name to the fact that money is owed under this tab
        Boolean owes = false;                   //Boolean variable that tells the program whether or not 'money is owed' - defaulted to 'No'
        if(money > 0.0)                         //If dollar value is greater than zero
            owes = true;                        //...tells the program that this person owes money
        return owes;                            //Returns whether or not money is owed for this person
    }

    private boolean hasAnActiveTab(String name){    //Method to be called to see if the name being passed in 'has an active tab'
        for (String tab : tabs){                    //Loop to check through the list of Strings in the ArrayList
            if (tab.equals(name))                   //If one of the Strings in the list is the same as the name being passed into the method
                return true;                        //Method tells the program that the name given 'has an active tab'
        }
        return false;                               //If it goes through the loop without a match, tells the program that the
    }                                               //...name given does 'not have an active tab'

    public void createActiveTab(String name){       //Method to be called when someone wants to start a tab
        this.tabs.add(name);                        //Adds a name to the ArrayList of names (Strings) created
    }                                                   //specifically for the currently constructed Class 'PapiStore'


    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
