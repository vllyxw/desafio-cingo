package cingo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conteudo", nullable = false, unique = true)
    private String conteudo;

    @Column(name = "vezes", nullable = false)
    private Long vezes;
}
