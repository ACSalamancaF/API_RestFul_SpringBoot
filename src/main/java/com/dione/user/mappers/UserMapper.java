package com.dione.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dione.user.dto.UserDTO;
import com.dione.user.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	@Mapping(target = "birthDate",

			source = "birthDate",

			dateFormat = "dd-MM-yyyy")

	User toModel(UserDTO userDTO);

	UserDTO toDTO(User user);
}
