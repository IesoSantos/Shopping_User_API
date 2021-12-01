/**
 * 
 */
package com.ieso.shopping.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieso.shopping.model.UserDTO;
import com.ieso.shopping.model.User;
import com.ieso.shopping.repository.UserRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository  userRepository;
	
	public List<UserDTO> getAll(){
		List<User> usuarios = userRepository.findAll();
		return usuarios
				.stream()
				.map(UserDTO::convert)
				.collect(Collectors.toList());
				
	}
	
	public UserDTO findById(long userId) {
		Optional<User> usuario = userRepository.findById(userId);
		if(usuario.isPresent()) {
			return UserDTO.convert(usuario.get());
		}
		return null;
	}

}
