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
public class BoardingRoom {
    private int id;
    private String name;
    private boolean isAvailable;
    private Semaphore boardingRoomSynchroniser = new Semaphore(1,1);;

    public BoardingRoom() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public BoardingRoom(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        
        this.isAvailable = isAvailable;
    }

    public Semaphore getBoardingRoomSynchroniser() {
        return boardingRoomSynchroniser;
    }

    public void setBoardingRoomSynchroniser(Semaphore boardingRoomSynchroniser) {
        this.boardingRoomSynchroniser = boardingRoomSynchroniser;
    }

    
    
    @Override
    public String toString() {
        return "BoardingRoom{" + " name=" + name + ", isAvailable=" + isAvailable + '}';
    }
    
}
