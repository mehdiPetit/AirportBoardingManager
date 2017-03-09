/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportboardingmanager;
/**
 *
 * @author 20130157
 */
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Flight implements Runnable{
    private int idFly;
    private BoardingRoom boardingRoom;
    private Gateway gateway;
    private Resources resources;
    public Flight(Resources resources, int idFly) {
        this.resources = resources;
        this.idFly = idFly;
    }
    
  
    
    public int getIdFly() {
        return idFly;
    }

    public void setIdFly(int idFly) {
        this.idFly =  idFly;
    }

    public BoardingRoom getBoardingRoom() {
        return boardingRoom;
    }

    public void setBoardingRoom(BoardingRoom boardingRoom) {
        this.boardingRoom = boardingRoom;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String toString() {
        return "Flight{" + "idFly=" + idFly + ", boardingRoom=" + boardingRoom + ", gateway=" + gateway + '}';
    }
    
    
    public boolean bookedBoardingRoom(){
        for(int i  = 0; i < resources.getAirportBoardingRoom().size(); i++)
        {
            if(resources.getAirportBoardingRoomById(i).getIsAvailable() == true)
            {
                resources.getAirportBoardingRoomById(i).getBoardingRoomSynchroniser().P();
                resources.getAirportBoardingRoomById(i).setIsAvailable(false);
                 resources.getAirportBoardingRoomById(i).setId(i);
                this.setBoardingRoom(resources.getAirportBoardingRoomById(i));
                System.out.println("Fly n°" + idFly + " has booked boarding room : " + this.getBoardingRoom().getName() );
                return true;
            }
            
        }
        return false;
    }
    
    public boolean bookedGateway(){
        for(int i  = 0; i < resources.getAirportGateway().size(); i++)
        {
            if(resources.getAirportGatewayById(i).getIsAvailable() == true)
            {
                resources.getAirportGatewayById(i).getGatewaySynchroniser().P();
                resources.getAirportGatewayById(i).setIsAvailable(false);
                resources.getAirportGatewayById(i).setId(i);
                this.setGateway(resources.getAirportGatewayById(i));
                System.out.println("Fly n°" + idFly + " has booked gateway: " + this.getGateway().getName() );
                return true;
            }
            
        }
        return false;
    }
    
    public boolean booked(){
        while(!bookedBoardingRoom()){}
        while(!bookedGateway()){}   
        return true;
    }
    
    public boolean free(){
        try {
            int pause = (int)(Math.random()* 10000);
            Thread.sleep(pause);
            
            
            resources.getAirportGatewayById(gateway.getId()).setIsAvailable(true);
            resources.getAirportBoardingRoomById(boardingRoom.getId()).setIsAvailable(true);
            System.out.println("Fly n°" + idFly + " has made its ressources free (" +
                    resources.getAirportBoardingRoomById(boardingRoom.getId()).getName() +
                    "," + resources.getAirportGatewayById(gateway.getId()).getName() + ")");
            resources.getAirportGatewayById(gateway.getId()).getGatewaySynchroniser().V();
            resources.getAirportBoardingRoomById(boardingRoom.getId()).getBoardingRoomSynchroniser().V();

            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Flight.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    @Override
    public void run() {
        this.booked();
        this.free();
    }
    
    
    
}
