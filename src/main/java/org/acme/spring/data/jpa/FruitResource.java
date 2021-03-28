package org.acme.spring.data.jpa;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;




import java.util.List;
import java.util.Optional;

@Path("/fruits")
public class FruitResource {
    @Inject
    Logger log; 
 
    private final FruitRepository fruitRepository;

    public FruitResource(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public Iterable<Fruit> findAll() {
        log.info("Getting fruits...");
        return fruitRepository.findAll();
    }


    @DELETE
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public void delete(@PathParam long id) {
        log.info("Deleting fruit " + id);
        fruitRepository.deleteById(id);
    }

    @POST
    @Consumes("application/json")
    @Produces({ MediaType.APPLICATION_JSON})
    public Fruit create(@Valid Fruit fruit) {
        log.info("Creating fruit...");
        return fruitRepository.save(fruit);
    }

    @PATCH
    @Path("{id}/color/{color}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Fruit changeColor(@PathParam Long id, @PathParam String color) {
        Optional<Fruit> optional = fruitRepository.findById(id);
        if (optional.isPresent()) {
            Fruit fruit = optional.get();
            fruit.setColor(color);
            log.info("Patching fruit...");
            return fruitRepository.save(fruit);
        }
        throw new IllegalArgumentException("No Fruit with id " + id + " exists");
    }

    @GET
    @Path("/color/{color}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Fruit> findByColor(@PathParam String color) {
        log.info("Getting fruit with "+ color+" color");
        return fruitRepository.findByColor(color);
    }
}