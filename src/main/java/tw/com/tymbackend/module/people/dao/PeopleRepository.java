package tw.com.tymbackend.module.people.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tw.com.tymbackend.module.people.domain.vo.People;

public interface PeopleRepository extends JpaRepository<People, String>, JpaSpecificationExecutor<People> {

    Optional<People> findByName(String name);

    @Modifying
    @Query("DELETE FROM People")
    void deleteAllPeople();

    void deleteByName(String name);
}
