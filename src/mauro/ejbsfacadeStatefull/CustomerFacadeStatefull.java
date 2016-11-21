/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mauro.ejbsfacadeStatefull;

import java.util.Collection;
import java.util.Collections;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import mauro.entities.Customer;
import mauro.entities.Order;

/**
 *
 * @author mauronew
 */
@Stateful
public class CustomerFacadeStatefull extends AbstractFacadeStatefull<Customer> {

        
    @PersistenceContext(unitName = "mytestPU",type = PersistenceContextType.EXTENDED)
    private EntityManager em;

       @Override
        protected  EntityManager getEntityManagerExtended(){
           return em;
        }

    

    public CustomerFacadeStatefull() {
        super(Customer.class);
    }
   public Collection<Order>  getOrderscCollections(){
 Collection <Order> ordersCollection ;
 ordersCollection= this.getEntityreattached().getOrders();
 for(Order order: ordersCollection){
    this.getEntityManagerExtended().refresh(order);
    order.toString();
 
 }
 return ordersCollection;
    }
   
 
}
