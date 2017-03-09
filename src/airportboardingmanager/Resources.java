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
public class Resources {
    private ArrayList <BoardingRoom> airportBoardingRoom;
    private ArrayList <Gateway> airportGateway;
    
    public Resources(int numberOfBoardingRoom, int numberOfGateway) {
        
        airportBoardingRoom = new ArrayList<BoardingRoom>();//[numberOfBoardingRoom];
        airportGateway = new ArrayList<Gateway>();//[numberOfGateway]; 
        
        for(int i = 0; i < numberOfBoardingRoom; i++)
        {
            airportBoardingRoom.add(new BoardingRoom(Character.toString((char)('A'+i)),true));
        }
        for(int i = 0; i < numberOfGateway; i++)
        {
            airportGateway.add(new Gateway(Integer.toString(i),true));
        }
        
    }

    public ArrayList <BoardingRoom> getAirportBoardingRoom() {
        return airportBoardingRoom;
    }

    public void setAirportBoardingRoom(ArrayList <BoardingRoom> airportBoardingRoom) {
        this.airportBoardingRoom = airportBoardingRoom;
    }

    public ArrayList <Gateway> getAirportGateway() {
        return airportGateway;
    }

    public void setAirportGateWay(ArrayList <Gateway> airportGateway) {
        this.airportGateway = airportGateway;
    }
    
     public BoardingRoom getAirportBoardingRoomById(int id) {
        return airportBoardingRoom.get(id);
    }

    public void setAirportBoardingRoomById(int id, BoardingRoom airportBoardingRoom) {
        this.airportBoardingRoom.set(id, airportBoardingRoom);
    }

     public Gateway getAirportGatewayById(int id) {
        return airportGateway.get(id);
    }

    public void setAirportGatewayById(int id, Gateway airportGateway) {
        this.airportGateway.set(id,airportGateway);
    }
}
