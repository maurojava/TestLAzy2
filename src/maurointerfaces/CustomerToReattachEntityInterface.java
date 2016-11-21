/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maurointerfaces;

import java.util.Collection;
import javax.ejb.Remove;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import mauro.entities.Customer;
import mauro.entities.Order;

/**
 *
 * @author mauronew
 */
public interface CustomerToReattachEntityInterface {

  
    

    
   

    Customer getCustomeratached();

    Collection<Order> getOrdersCollection();

    void setCustomerToReattached(Customer customerToReattach);
    
}
