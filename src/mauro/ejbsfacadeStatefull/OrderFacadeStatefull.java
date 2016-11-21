/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mauro.ejbsfacadeStatefull;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import mauro.entities.Order;

/**
 *
 * @author mauronew
 */
@Stateful
public class OrderFacadeStatefull extends AbstractFacadeStatefull<Order> {

    @PersistenceContext(unitName = "mytestPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public OrderFacadeStatefull() {
        super(Order.class);
    }

    @Override
    protected EntityManager getEntityManagerExtended() {
        return em;
    }

}
