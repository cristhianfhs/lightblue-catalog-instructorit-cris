package catalog;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("itemsRepo")
@Transactional
public interface InventoryRepo extends 
CrudRepository <Inventory, Long> {
}