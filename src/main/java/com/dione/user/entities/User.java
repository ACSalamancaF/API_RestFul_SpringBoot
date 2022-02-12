package com.dione.user.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dione.user.enums.SexoType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * As anotações abaixo 
 * @Entity A anotação é utilizada para informar que uma classe também é uma entidade. 
 * A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo 
 * nome no banco de dados, onde os dados de objetos desse tipo poderão ser persistidos.
 * Uma entidade representa, na Orientação a Objetos, uma tabela do banco de dados, e 
 * cada instância dessa entidade representa uma linha dessa tabela.
 * 
 * @Data é uma anotação que gera o código padronizado para classes Java: getters para 
 * todos os campos, setters para todos os campos não-finais e o toString apropriado, 
 * equals e implementações hashCode que envolvem os campos da classe.
 * 
 * @Builder Anotação é ideal com objetos imutáveis, sem métodos setters e sem construtores 
 * com muitos parâmetros, ela vai nos permitir criar objetos sem precisarmos de construtores
 * e sem métodos setters em nossas classes.
 * 
 * @AllArgsConstructor: cria o construtor que possui todos atributos como parâmetros.
 * 
 * @NoArgsConstructor: cria o construtor que não possui parâmetros.
 *
 * Referências:
 * https://medium.com/garota-da-ti/projeto-lombok-escrevendo-menos-c%C3%B3digo-boilerplate-dd1d670d981a
 * https://www.devmedia.com.br/jpa-como-usar-a-anotacao-entity/38410
 * 
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstNome;
	
	@Column(nullable = false)
	private String lastNome;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<SexoType> sex = new ArrayList<>();
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	private LocalDate birthDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones = new ArrayList<>();
}
