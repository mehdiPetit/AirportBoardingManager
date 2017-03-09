/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportboardingmanager;

import java.util.ArrayList;

/**
 *
 * @author 20130157
 */
public class AirportBoardingManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // 4 boardingRoom a 3 gateWay
        Resources orlyResources = new Resources(4,3); 
        ArrayList<Thread> flyList = new ArrayList<Thread>();

        for (int i = 0; i < 100; i++)
        {
            flyList.add(new Thread(new Flight(orlyResources, i)));
        }
        for (int i = 0; i < flyList.size(); i++)
        {
            flyList.get(i).start();
        }
        
        
        
        
    }
    
}
