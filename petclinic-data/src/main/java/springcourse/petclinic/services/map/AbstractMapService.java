package springcourse.petclinic.services.map;

import springcourse.petclinic.model.BaseEntity;

import java.util.*;

// bij het gebruik van generics kan nog steeds een klasse aangegeven worden waarvan ingevoerde waardes van moeten overerven,
// in dit geval worden enkel nog BaseEntities en Longs geaccepteerd
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    // ID verandert naar Long omdat anders geen berekeningen gedaan kunnen worden in getNextId
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    // bij de refactoring om automatisch ids te genereren is het niet meer nodig dat deze wordt meegegeven (ID verwijdert)
    T save(T object) {
        // omdat object overerft van BaseEntity kunnen methodes als getId() gebruikt worden
        if (object != null) {
            // if stmt van jt gecomment, scenario (object.getid == null) komt altijd voor aangezien id niet meer geset wordt,
//            if (object.getId() == null) {
//                object.setId(getNextId());
//            }
            object.setId(getNextId());
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("object cannot be null sir");
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
