package com.dione.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.dione.user.dto.UserDTO;
import com.dione.user.entities.User;
import com.dione.user.mappers.UserMapper;
import com.dione.user.repositories.UserRepository;
import com.dione.user.response.dto.MessageResponseDTO;

/*
 * @Service: mostra que a lógica do negócio parte dessa classe.
 * 
 * /*
 * Estamos instanciando nosso tipo de pessoa repositório.
 * um dos mais notáveis recursos do spring boot, as injeções 
 * de dependências. No contexto a anotação @Autowired gera dependência do meu repository 
 * com o controller e ainda permite o acesso a métodos do JPA sem necessariamente ficar 
 * gerando objetos com os News.
 * 
 * Serviço Post definido através da anotação @PostMapping. Está salvando um user e dentro do corpo
 * do método dizemos que será através de uma requisição de corpo pela anotação @RequestBory e dizemos
 * o tipo que será user do tipo User.Usado um método da JPA para salvar o corpo da aplicação. 
 * Como retorno chama-se a classe MessageResponseDTO apenas para indicar que foi salvo no banco, veja a anotação @Build por ela pode-se passar os valores de forma direta aos atributos da classe.
 */


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	private final UserMapper userMapper = UserMapper.INSTANCE;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

public MessageResponseDTO createUser(UserDTO userDTO) {

	User userToSave = userMapper.toModel(userDTO);
	User savedUser = userRepository.save(userToSave);

		return MessageResponseDTO

				.builder()

				.message("Created person with Id" + savedUser.getId())

				.build();

	}
}
