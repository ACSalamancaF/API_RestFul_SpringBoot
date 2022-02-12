package com.dione.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexoType {
	MEN("Men"),
	WOMAN("Woman"),
	DO_NOT_MENTION("Do not mention"),
	OTHER("Other");

	private final String description;
}
