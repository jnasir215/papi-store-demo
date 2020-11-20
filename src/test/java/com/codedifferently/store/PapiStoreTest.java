package com.codedifferently.store;  //This is the package it defines the family relation of objects


import org.junit.Assert;    //This is importing the Assert Class from the org.junit package or folder
import org.junit.Before;    //This imports the Before Class from org.junit to allow to create a pseudo Constructor for testing purposes
import org.junit.Test;      //This imports the Test Class from org.junit to allow the methods written to be recognized as 'tests'

    public class PapiStoreTest {        //This is a public class called Papi

        PapiStore papiStore;            //papiStore variable declared of Object type PapiStore

        @Before
        public void setup(){                //Test Constructor tailored specifically to the list of tests desired
            papiStore = new PapiStore();    //papiStore variable declared to reference the Class PapiStore
            papiStore.createActiveTab("Jamal"); //New tab created for the currently constructed PapiStore for Jamal
            papiStore.createActiveTab("Victor");//New tab created for the currently constructed PapiStore for Victor
            papiStore.owesPapiMoney.put("Jamal", 0.0);//Add Jamal to the list of those that have an active tab and how much he owes using the HashMap variable
            papiStore.owesPapiMoney.put("Victor", 7.0);//Add Victor to the list of those that have an active tab and how much he owes using the HashMap variable
        }

        @Test
        public void OpenStoreTest(){    //Method designed to test whether or not the 'isStoreOpen' method works properly
            //Given
            papiStore.openStore();      //Method called to open this currently constructed PapiStore

            //When
            Boolean expected = true;    //The 'expectation' is that the method works and will indicate that 'the store is open'
            Boolean actual = papiStore.isStoreOpen();//What 'actually' happens when the method is called will be returned here
                                                        //Did the method meet the expectation? 'Is it open' or 'is it closed'?
            //Then
            //Assert.assertEquals(expected, actual);
            Assert.assertTrue(actual);  //Asserts that the method will meet the expectation that the store is open
        }                                   //If so, this Test will PASS

        @Test
        public void allowToUseTabTestSuccess(){ //Method designed to test whether or not the 'allowToUseTab' method works
            // given
            PapiStore papiStore = new PapiStore();  //Local variable declared to reference the Class PapiStore

            // when
            Boolean expected = true;            //The 'expectation' is that the method works and will successfully add the given name to the ArrayList
            Boolean actual = papiStore.allowToUseTab("Jamal");  //What 'actually' happens when the method is called should add 'Jamal' to the ArrayList

            // then
            Assert.assertEquals(expected, actual);  //Asserts that the method will meet the expectation and will return a value of true
        }                                               //If so, this Test will PASS

        @Test
        public void allowToUseTabTestFail(){    //Method designed to test whether or not the 'allowToUseTab' method will predictably fail
            // given
            PapiStore papiStore = new PapiStore();  //Local variable declared to reference the Class PapiStore

            // when
            Boolean expected = false;           //The 'expectation' is that the method will unsuccessfully add the given name to the ArrayList
            Boolean actual = papiStore.allowToUseTab("Victor"); //What 'actually' happens when the method is called should add 'Victor' to the ArrayList

            // then
            Assert.assertEquals(expected, actual);  //Asserts that the method will meet the expectation and will return a value of false
        }                                               //If the 'allowToUseTab' method works, this Test will FAIL
}
