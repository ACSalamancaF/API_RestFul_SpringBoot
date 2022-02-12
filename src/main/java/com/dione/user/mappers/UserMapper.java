package com.dione.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dione.user.dto.UserDTO;
import com.dione.user.entities.User;
/*
 * @Mapper: indica ao MapStruct que a interface anotada será responsável pela declaração dos mapeamentos.
	@Mapping: com essa anotação é possível interligar campos de diferentes classes pelo target e source, ainda 
	que os nomes dos atributos fossem diferentes essa anotação iria fazer o pareamento. Percebe que a relação de mapeamento se dá de forma bem simples, quando quer ter acesso aos métodos do JPA o método é toModel, quando se quer passar para o cliente a resposta do banco toDTO.
*/

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(target = "birthDate",

			source = "birthDate",

			dateFormat = "dd-MM-yyyy")

	User toModel(UserDTO personDTO);

	UserDTO toDTO(User person);
}
