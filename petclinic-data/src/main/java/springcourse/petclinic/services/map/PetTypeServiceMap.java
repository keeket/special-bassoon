package springcourse.petclinic.services.map;

import springcourse.petclinic.model.PetType;
import springcourse.petclinic.services.CrudService;

import java.util.Set;

public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements CrudService<PetType, Long> {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
