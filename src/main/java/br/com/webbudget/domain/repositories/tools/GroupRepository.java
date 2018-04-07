package br.com.webbudget.domain.repositories.tools;

import br.com.webbudget.domain.entities.security.Group;
import br.com.webbudget.domain.entities.security.Group_;
import br.com.webbudget.domain.repositories.DefaultRepository;
import java.util.Optional;
import javax.persistence.metamodel.SingularAttribute;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;

/**
 *
 * @author Arthur Gregorio
 *
 * @version 1.0.0
 * @since 3.0.0, 28/12/2017
 */
@Repository
public interface GroupRepository extends DefaultRepository<Group> {

    /**
     * 
     * @param name
     * @return 
     */
    Optional<Group> findOptionalByName(String name);
    
    /**
     * 
     * @return 
     */
    @Override
    default SingularAttribute<Group, Boolean> getBlockedProperty() {
        return Group_.blocked;
    }

    /**
     * 
     * @param filter
     * @return 
     */
    @Override
    default Criteria<Group, Group> getRestrictions(String filter) {
        return criteria()
                .likeIgnoreCase(Group_.name, filter);
    }
}
