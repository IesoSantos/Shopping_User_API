/**
 * 
 */
package com.ieso.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ieso.shopping.model.UserDTO;
import com.ieso.shopping.service.UserService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/")
	public List<UserDTO> getUsers(){
		List<UserDTO> usuarios = userService.getAll();
		return usuarios;
	}
	
	@GetMapping("/user/{id}")
	UserDTO findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping("/user")
	UserDTO newUser(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@GetMapping("/user/cpf/{cpf}")
	UserDTO findByCpf(@PathVariable String cpf) {
		return userService.findByCpf(cpf);
	}
	
	@DeleteMapping("/user/{id}")
	UserDTO delete(@PathVariable Long id) {
		return userService.delete(id);
	}
	
	@GetMapping("/user/search")
	public List<UserDTO> queryByName(
			@RequestParam(name = "nome", required = true)
			String nome
			){
		return userService.queryByName(nome);
	}
	
	/*
	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();;
	
	@PostConstruct
	public void initiateList() {
		UserDTO userDTO1 = new UserDTO();
		userDTO1.setNome("Eduardo");
		userDTO1.setCpf("123");
		userDTO1.setEndereco("Rua a");
		userDTO1.setEmail("eduardo@email.com");
		userDTO1.setTelefone("1234-3454");
		userDTO1.setDataCadastro(new Date());
		
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setNome("Luiz");
		userDTO2.setCpf("456");
		userDTO2.setEndereco("Rua b");
		userDTO2.setEmail("luiz@email.com");
		userDTO2.setTelefone("1234-3454");
		userDTO2.setDataCadastro(new Date());
		
		UserDTO userDTO3 = new UserDTO();
		userDTO3.setNome("Bruna");
		userDTO3.setCpf("678");
		userDTO3.setEndereco("Rua c");
		userDTO3.setEmail("bruna@email.com");
		userDTO3.setTelefone("1234-3454");
		userDTO3.setDataCadastro(new Date());
		
		usuarios.add(userDTO1);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}
	
	@GetMapping("/users")
	public List<UserDTO> getUsers(){
		return usuarios;
	}
	
	
	
	
	@GetMapping("/user/{cpf}")
	public UserDTO getUsersFiltro(@PathVariable String cpf) {
		for(UserDTO userFilter:usuarios) {
			if(userFilter.getCpf().equals(cpf)) {
				return userFilter;
			}
		}
		return null;
	}
	
	
	@PostMapping("/newUser")
	UserDTO inserir(@RequestBody UserDTO userDTO) {
		userDTO.setDataCadastro(new Date());
		usuarios.add(userDTO);
		return userDTO;
	}
	
	@DeleteMapping("/user/{cpf}")
	public boolean remover(@PathVariable String cpf) {
		for(UserDTO userFilter:usuarios) {
			if(userFilter.getCpf().equals(cpf)) {
				usuarios.remove(userFilter);
				return true;
			}
		}
		return false;
	}
	*/
}
