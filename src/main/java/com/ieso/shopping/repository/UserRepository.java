/**
 * 
 */
package com.ieso.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ieso.shopping.model.User;

/**
 * @author Anderson dos Reis Santos
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByCpf(String cpf);
	
	List<User> queryByNomeLike(String nome);

}
