package catalog;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//Added
//import catalog.models.*;
import catalog.*;
import org.springframework.beans.factory.annotation.Autowired;
//Finish the Added

/**
 * REST Controller to manage Inventory database
 */
@RestController
public class CatalogController {
	
	//Added
	@Autowired
    InventoryRepo itemsRepo;
    //Finish the Added

    Logger logger = LoggerFactory.getLogger(CatalogController.class);

    /**
     * @return all items in inventory
     */
    //BEFORE EXERCISE
    /*@RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<?> getInventory() {
        return ResponseEntity.ok("[{\"id\": 1,\"name\":\"one\"},{\"id\":2,\"name\":\"two\"}]");
    }*/
   //ADDED
   @RequestMapping(value = "/items", method = RequestMethod.GET)
   @ResponseBody
   Iterable<Inventory> getInventory() {
     return itemsRepo.findAll();
   }

    /**
     * @return item by id
     */
    //BEFORE VERSION
    /*@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getById(@PathVariable long id) {
                return ResponseEntity.ok("{\"id\":1,\"name\":\"one\"}");
    }*/
   //ADDED
   @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
  ResponseEntity<?> getById(@PathVariable long id) {
    if (!itemsRepo.exists(id)) {
       return ResponseEntity.notFound().build();
   	}
    return ResponseEntity.ok(itemsRepo.findOne(id));
  }

}
