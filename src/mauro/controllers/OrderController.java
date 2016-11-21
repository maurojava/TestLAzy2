package mauro.controllers;

import mauro.entities.Order;
import mauro.ejbs.OrderFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Named(value = "orderController")
@SessionScoped
public class OrderController extends AbstractController<Order> {

    @Inject
    private OrderFacade ejbFacade;
    @Inject
    private CustomerController customerController;

    /**
     * Initialize the concrete Order controller bean. The AbstractController
     * requires the EJB Facade object for most operations.
     */
    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public OrderController() {
        // Inform the Abstract parent controller of the concrete Order Entity
        super(Order.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        customerController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Customer controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCustomer(ActionEvent event) {
        if (this.getSelected() != null && customerController.getSelected() == null) {
            customerController.setSelected(this.getSelected().getCustomer());
        }
    }
}
