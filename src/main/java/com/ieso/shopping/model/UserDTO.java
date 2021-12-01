/**
 * 
 */
package com.ieso.shopping.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Getter
@Setter
public class UserDTO {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastro;
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());
		return userDTO;
	}

}
