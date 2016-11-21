/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mauro.ejbsfacadeStatefull;

import java.util.List;
import javax.ejb.Remove;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;

/**
 *
 * @author mauronew
 */
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public abstract class AbstractFacadeStatefull<T> {

    /**
     * @return the entityreeattached
     */
    public T getEntityreattached() {
        return entityreattached;
    }

    private Class<T> entityClass;
    private T entityreattached;

    public AbstractFacadeStatefull(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManagerExtended();

    public void reattachEntityToPersistenceContextExtended(T entitytoreattach) {
        getEntityManagerExtended().clear();
        T reattached = getEntityManagerExtended().merge(entitytoreattach);

        this.entityreattached = reattached;

   }
    @Remove
     public void clearPersistenceContextExtended(){
        this.getEntityManagerExtended().clear();
        
    }
     public boolean isEntytiManaged(T entity){
     return this.getEntityManagerExtended().contains(entity);
     }
   
}
