package edu.miu.cs.cs425.fairfieldlibraryapp.repository;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    @Query(value = "select  p from  Publisher p where p.name = :name ")
    Optional<Publisher> getPublisherByName(String name);
//    @Query(value = "select * from ``", nativeQuery = true)
    List<Publisher> getPublishersByName(String name);
//    List<Publisher> findPublisherByNameContainsAnd
}
