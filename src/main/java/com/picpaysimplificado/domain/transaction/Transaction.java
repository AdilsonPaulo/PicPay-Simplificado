package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transaction")
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Valor da transação
    private BigDecimal amount;

    /*
    @ManyToOne indica que usuários podem fazer várias transações, entretanto, cada transação
    só possui um sender e um receiver
    @JoinColumn define a chave estrangeira em um relacionamento de entidades
     */
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
    @JoinColumn(name = "receiver_id")
    @ManyToOne
    private User receiver;

    //Data da transação
    private LocalDateTime timestamp;
}
