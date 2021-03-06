package com.dione.user.dto.response;

import lombok.Builder;
import lombok.Data;

/*
 * DTO response e nele apenas determinar um comportamento de um método de mensagens.
 * Acessar através da anotação @Data.
 * 
 */
@Data
@Builder
public class MessageResponseDTO {

	private String message;

}
