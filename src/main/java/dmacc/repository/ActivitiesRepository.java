/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 2, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Activities;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, Long> {

}
