package sa.center.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sa.center.model.Center;

import java.util.List;

@Stateless
public class CenterService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Center> getAllCenters(int first, int maxResult) {
        return entityManager.createNamedQuery(Center.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Center getCenterByCode(long code){
        return entityManager.find(Center.class, code);
    }

    public void createCenter(Center course) {
        entityManager.persist(course);
    }

    public Center updateCenter(long code, Center course) {
        Center centerToUpdate = entityManager.find(Center.class, code);
        centerToUpdate.setName(course.getName());
        centerToUpdate.setLat(course.getLat());
        centerToUpdate.setLon(course.getLon());
        centerToUpdate.setAddress(course.getAddress());
        return entityManager.merge(centerToUpdate);
    }

    public void deleteCenter(long code) {
        Center center = entityManager.find(Center.class, code);
        entityManager.remove(center);
    }
}
