package tw.com.tymbackend.module.people.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;

import tw.com.tymbackend.module.people.dao.PeopleRepository;
import tw.com.tymbackend.module.people.domain.vo.People;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true, noRollbackFor = {IllegalArgumentException.class, EmptyResultDataAccessException.class})
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> findAll() {
        return peopleRepository.findAll();
    }
    
    /**
     * Get all people
     * 
     * @return list of all people
     */
    public List<People> getAllPeople() {
        return findAll();
    }

    public Optional<People> findByName(String name) {
        return peopleRepository.findByName(name);
    }
    
    /**
     * Get people by name
     * 
     * @param name the person's name
     * @return the person
     */
    public Optional<People> getPeopleByName(String name) {
        return peopleRepository.findByName(name);
    }

    @Transactional
    public People save(People person) {
        return peopleRepository.save(person);
    }
    
    /**
     * Insert a new person
     * 
     * @param person the person to insert
     * @return the inserted person
     */
    @Transactional
    public People insertPerson(People person) {
        return save(person);
    }

    @Transactional
    public List<People> saveAll(List<People> peopleList) {
        return peopleRepository.saveAll(peopleList);
    }
    
    /**
     * Save all people
     * 
     * @param peopleList the list of people to save
     * @return the saved people
     */
    @Transactional
    public List<People> saveAllPeople(List<People> peopleList) {
        return saveAll(peopleList);
    }

    @Transactional
    public void deleteAll() {
        peopleRepository.deleteAll();
    }
    
    /**
     * Delete all people
     */
    @Transactional
    public void deleteAllPeople() {
        deleteAll();
    }

    @Transactional
    public People update(String name, People person) {
        if (peopleRepository.existsById(name)) {
            person.setName(name);
            return peopleRepository.save(person);
        }
        return null;
    }
    
    /**
     * Update a person
     * 
     * @param person the person to update
     * @return the updated person
     */
    @Transactional
    public People updatePerson(People person) {
        if (person.getName() != null && peopleRepository.existsById(person.getName())) {
            return peopleRepository.save(person);
        }
        return save(person);
    }

    @Transactional
    public People updateAttributes(String name, People person) {
        return peopleRepository.findByName(name)
            .map(existing -> {
                existing.setBaseAttributes(person.getBaseAttributes());
                existing.setBonusAttributes(person.getBonusAttributes());
                existing.setStateAttributes(person.getStateAttributes());
                return peopleRepository.save(existing);
            })
            .orElse(null);
    }

    public List<People> findBySpecification(Specification<People> spec) {
        return peopleRepository.findAll(spec);
    }

    public List<People> findBySpecification(Specification<People> spec, Sort sort) {
        return peopleRepository.findAll(spec, sort);
    }

    public Page<People> findBySpecification(Specification<People> spec, Pageable pageable) {
        return peopleRepository.findAll(spec, pageable);
    }

    public List<People> findByMultipleSpecifications(List<Specification<People>> specs) {
        Specification<People> combinedSpec = specs.stream()
            .reduce(Specification.where(null), Specification::and);
        return peopleRepository.findAll(combinedSpec);
    }

    public Page<People> findAll(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }
    
    /**
     * Get all people names only
     * 
     * @return list of people names
     */
    public List<String> getAllPeopleNames() {
        return peopleRepository.findAll().stream()
            .map(People::getName)
            .collect(Collectors.toList());
    }
}