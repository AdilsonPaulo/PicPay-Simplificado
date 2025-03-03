package com.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/*
@Entity para indicar que essa classe representa uma tabela no banco de dados
@Table para configurar a tabela
@Getter @Setter @AllArgsConstructor @EqualsAndHashCode são utilizados para gerar códigos
 */
@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    /*
    @Id para informar que o campo id é a chave primária
    @GeneratedValue para gerar o valor automáticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Nome completo do usuário
    private String firstName;
    private String lastName;

    /*
    @Column(unique = true) para indicar que não é possível ter dois valores iguais
    para esse campo no banco de dados
     */
    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    //Senha do usuário
    private String password;

    //Saldo da conta bancária
    private BigDecimal balance;

    /*
    @Enumerated(EnumType.STRING) para indicar que type vai representar um dos valores do enum,
    ou seja, a classe UserType
     */
    @Enumerated(EnumType.STRING)
    private UserType type;


}
