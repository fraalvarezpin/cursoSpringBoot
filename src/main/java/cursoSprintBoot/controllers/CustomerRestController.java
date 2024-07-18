package cursoSprintBoot.controllers;

import cursoSprintBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController


public class CustomerRestController{
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
           new Customer( 123, "Franciso Alarez",  "franciscoa","clave123"),
            new Customer( 456, "Wilman Chamba",  "wilmanc","clave456"),
            new Customer( 789, "María Ruilova",  "mariar","clave789"),
            new Customer( 987, "José Guamán",  "joseg","clave987")
    ));

    //end point clientes
    @GetMapping("/clientes")
    public List<Customer> getCustomers() {
        return customers;
    }
    //end point clientes especifico (uso de enrutamiento URL para obtener un recurso específico)
    //método get
    @GetMapping("/clientes/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equals(username)) {
                return c;
            }
        }
        return null;
    }
    //método post
    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;

    }
    //método put
    @PutMapping("/clientes")
    public Customer putCliente(@RequestBody Customer customer){
        for (Customer c : customers) {
            if (c.getID()   == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());

                return c;
            }
        }
        return null;
    }
    //Método delete
    @DeleteMapping("/clientes/{id}")
    public Customer deleteCliente(@PathVariable int id){
        for (Customer c : customers) {
            if(c.getID() == id) {
                customers.remove(c);

                return c;
            }
        }
    return null;
    }
    //Método patch

    @PatchMapping("/clientes")
    public Customer patchCliente(@RequestBody Customer customer){
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }
}
