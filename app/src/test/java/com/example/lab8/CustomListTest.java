package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * Create a mocklist for my citylist
     * @return
     *
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * Get the size of the list
     * Increase the list by adding a new city
     * Check if our current size matches the initial size plus 1
     * */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan","SK"));
        assertEquals(list.getCount(),listSize+1);
    }

    /**
     * Add a city to the list
     * Check to see if hasCity recognizes it's in the list
     * Check to see if hasCity recognizes another city is not in the list
     * */
    @Test
    void testHasCity() {
        list = MockCityList();
        City city1 = new City("Red Deer", "Alberta");
        City city2 = new City("Calgary", "Alberta");
        list.addCity(city1);
        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
    }

    /**
     * Add a city to the list
     * Delete the city from the list
     * Check that the length of the list decreased by one and
     * city is no longer in the list
     * */
    @Test
    void testDelete(){
        list = MockCityList();
        City city = new City("Calgary", "Alberta");
        City city2 = new City("Edmonton", "Alberta");
        list.add(city);
        list.add(city2);
        list.delete(city);
        //Assert size = 1
        assertEquals(1,list.getCount());
        assertFalse(list.hasCity(city));
    }
}
