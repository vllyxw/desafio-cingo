package cingo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


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

    public Log() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getVezes() {
        return vezes;
    }

    public void setVezes(Long vezes) {
        this.vezes = vezes;
    }
}
