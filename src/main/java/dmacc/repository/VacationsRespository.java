/**
 * @author Julie Burger - jaburger
 * CIS175 - Spring 2023
 * Apr 8, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Vacations;

public interface VacationsRespository extends JpaRepository<Vacations, Long> {

}
