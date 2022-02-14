package com.dione.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dione.user.dto.UserDTO;
import com.dione.user.dto.response.MessageResponseDTO;
import com.dione.user.entities.User;
import com.dione.user.exception.UserNotFoundException;
import com.dione.user.mappers.UserMapper;
import com.dione.user.repositories.UserRepository;

import lombok.AllArgsConstructor;


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
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
	
	private final UserRepository userRepository;
	
		
	private final UserMapper userMapper;
	
	public UserDTO findByID(Long id) throws UserNotFoundException {
		User findUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		return userMapper.toDTO(findUser);
	}
	
	public MessageResponseDTO createUser(UserDTO userDTO) {

		User userToSave = userMapper.toModel(userDTO);
		User savedUser = userRepository.save(userToSave);

		MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedUser.getId());
		return messageResponse;
				

	}
	public List<UserDTO> listAll(){
		List<User> allUser = userRepository.findAll();
		return allUser.stream().map(userMapper::toDTO).collect(Collectors.toList());
		
	}
	
	public MessageResponseDTO update(Long id, UserDTO userDTO) throws UserNotFoundException {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        User updatedUser = userMapper.toModel(userDTO);
        User savedPerson = userRepository.save(updatedUser);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }
	
	public void delete(Long id) throws UserNotFoundException {
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.deleteById(id);
    }

	private MessageResponseDTO createMessageResponse(String s, Long id2) {
		return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
	}
	
}
