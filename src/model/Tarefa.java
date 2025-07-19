package model;

import java.util.Objects;

public class Tarefa {
    private final int id;
    private String descricao;
    private boolean concluido;

    private static int countId;

    public Tarefa(String descricao) {
        this.id = ++ countId;
        this.descricao = descricao;
        this.concluido = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return id == tarefa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", concluido=" + (concluido? "Sim" : "Não") +
                '}';
    }
}
