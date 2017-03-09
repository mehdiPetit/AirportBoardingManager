/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportboardingmanager;

/**
 *
 * @author mpeti
 */
public class Semaphore
{
    private int valeur;
    private int limite;
    
    public Semaphore(int valeur, int limite)
    {
        this.valeur=valeur;
        this.limite=limite;
    }
    
    public int getValeur()
    {
        return valeur;
    }
    
    synchronized public void P()
    {
        while (valeur<1)
        {
            try 
            {
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println("Erreur de Sémaphore");
            }
        }
        valeur=valeur-1;
    }
    
    synchronized public void V()
    {
        valeur=valeur+1;
        notify();
    }
}