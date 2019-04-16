package org.launchcode.models.data;

import org.launchcode.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hackman
 */
@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {

}
