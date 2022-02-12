package com.dione.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dione.user.entities.User;
import com.dione.user.repositories.UserRepository;
import com.dione.user.response.dto.MessageResponseDTO;

/*
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
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
    public UserController(UserRepository userRepository) {
    	 this.userRepository = userRepository;
    }

	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody User user) {

		User savedPerson = userRepository.save(user);

		return MessageResponseDTO

				.builder()

				.message("Created person with Id" + user.getId())

				.build();

	}
}
