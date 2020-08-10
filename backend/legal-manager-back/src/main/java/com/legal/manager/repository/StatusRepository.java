/**
 * 
 */
package com.legal.manager.repository;

import org.springframework.data.repository.CrudRepository;

import com.legal.manager.entity.Status;

/**
 * @author Davi Maçana
 *
 */
public interface StatusRepository extends CrudRepository<Status, Long> {
}
