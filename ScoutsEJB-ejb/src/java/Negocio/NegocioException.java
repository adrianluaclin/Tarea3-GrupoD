/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Vanesa
 */
public class NegocioException extends Exception{
    
    public NegocioException(){
        
    }
    public NegocioException( String msg){
        super(msg);
    }
    
}
