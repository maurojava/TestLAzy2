/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mauro.ejbsfacadeStatefull;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.NamingException;
import mauro.ejbs.CustomerFacade;
import mauro.entities.Customer;
import mauro.entities.Order;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mauronew
 */
public class CustomerFacadeStatefullTest {
    public static EJBContainer container;
    private Context context;
    
   @Inject 
    CustomerFacadeStatefull custFacadeStateful ;
    
   @Inject 
    CustomerFacade cusFacade;
    public CustomerFacadeStatefullTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       final Properties p = new Properties();
        p.put("ildatabase", "new://Resource?type=DataSource");
        p.put("ildatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("ildatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");
  container= EJBContainer.createEJBContainer(p); }
    
    @AfterClass
    public static void tearDownClass() {
  container.close();  }
    
    @Before
    public void setUp() throws NamingException {
 context = container.getContext();
 context.bind("inject",this);
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void createAndRetriveCustomerWithCustomerFacade(){
        List<Customer> listcustomer=
    this.create2CustomerandReturnList();
        System.out.println("Customer total created ="+listcustomer.size());
        
List<Customer> listcustomerretrived=this.cusFacade.findAll();
   System.out.println("Customer total rertrived ="+listcustomer.size());
        assertNotNull(listcustomer);
        int number=listcustomer.size();
        assertTrue(number > 0);
        
    }
    /**
     * Test of getEntityreattached method, of class CustomerFacadeStatefull.
     */
    @Test
    public void testGetEntityreattached() throws Exception {
        System.out.println("getEntityreattached");
    List<Customer> list2customer=    
        this.create2CustomerandReturnList();
    
        Customer c= list2customer.get(1);
        custFacadeStateful.reattachEntityToPersistenceContextExtended(c);
      
        Customer result = custFacadeStateful.getEntityreattached();
        assertEquals(c, result);
      
    }

    /**
     * Test of reattachEntityToPersistenceContextExtended method, of class CustomerFacadeStatefull.
     */
    @Test
    public void testReattachEntityToPersistenceContextExtended() throws Exception {
        System.out.println("reattachEntityToPersistenceContextExtended");
        
         List<Customer> list2customer=    
        this.create2CustomerandReturnList();
    
        Customer c= list2customer.get(1);
        Customer entitytoreattach = c;
        custFacadeStateful.reattachEntityToPersistenceContextExtended(entitytoreattach);
    boolean ismanaged=    custFacadeStateful.isEntytiManaged(c);
        assertTrue(ismanaged);
       
    }

    /**
     * Test of clearPersistenceContextExtended method, of class CustomerFacadeStatefull.
     */
    @Test
    public void testClearPersistenceContextExtended() throws Exception {
        System.out.println("clearPersistenceContextExtended");
          custFacadeStateful.clearPersistenceContextExtended();
      
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderscCollections method, of class CustomerFacadeStatefull.
     */
    @Test
    public void testGetOrderscCollections() throws Exception {
        System.out.println("getOrderscCollections");
         List<Customer> list1=this.create2CustomerandReturnList();
         Customer c1=list1.get(1);
         Collection<Order> expResult = null;
        Collection<Order> result = custFacadeStateful.getOrderscCollections();
        assertEquals(expResult, result);
      
       
    }
    
    
    private List<Customer> create2CustomerandReturnList(){
       Customer customer= new Customer("pippo");
      Customer customer2= new Customer("pluto");
      this.cusFacade.create(customer);
            this.cusFacade.create(customer2);
List<Customer> listcustomer=this.cusFacade.findAll();
return listcustomer;
    
    }
}
