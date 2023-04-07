package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Resort;

@Repository
public interface ResortRepository extends JpaRepository<Resort, Long>{

}
