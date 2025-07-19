package Service;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaService {
    private final List<Tarefa> tarefaList = new ArrayList<>();
    private final List<Tarefa> tarefaConcluida = new ArrayList<>();

    public void adicionarTarefa(String tarefa) {
        tarefaList.add(new Tarefa(tarefa));
    }

    public void removerTarefa(int id) {
        listaVazia();
        listarTarefas();

        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getId() == id) {
                if (tarefa.isConcluido()) {
                    System.out.println("Tarefa ja concluída");
                    return;
                }
                tarefaList.remove(tarefa);
                System.out.println("Removido com sucesso");
                return;
            }
        }
        System.out.println("Tarefa não encontrada");
    }

    public void listarTarefas() {
        listaVazia();

        tarefaList.stream().filter(t -> !t.isConcluido())
                .forEach(System.out::println);
    }

    public void atualizarTarefa(int id, String novaDescricao) {
        listaVazia();
        long tarefaPendente = tarefaList.stream().filter(p -> !p.isConcluido()).count();
        boolean tarefaEncontrada = false;

        if (tarefaPendente > 0) {
            for (Tarefa tarefa : tarefaList) {
                if (tarefa.getId() == id) {
                    tarefa.setDescricao(novaDescricao);
                    System.out.println("Tarefa atualizado com sucesso");
                    tarefaEncontrada = true;
                    break;
                }
            }
             if (!tarefaEncontrada){
                System.out.println("Id não encontrada");
            }
        } else {
            System.out.println("nenhuma Tarefa pendente.");
        }
    }

    public void marcarConcluido(int id) {
        listaVazia();

        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getId() == id) {
                if (tarefa.isConcluido()) {
                    System.out.println("Tarefa ja concluída");
                    return;
                }
                tarefaConcluida.add(tarefa);
                tarefa.setConcluido(true);
                System.out.println("Tarefa concluída com sucesso: " + tarefa.getDescricao());
                return;
            }
        }
    }

    public boolean retornarSeTiverConcluida(int id) {
        listaVazia();

        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getId() == id) {
                if (tarefa.isConcluido()) {
                    System.out.println("Tarefa ja concluída");
                    return true;
                }
                System.out.printf("descrição atual: %s\n", tarefa.getDescricao());
            }
        }
        return false;
    }

    public void exibirTarefasConcluidas() {
        tarefaConcluida.forEach(System.out::println);
    }

    private void listaVazia() {
        if (tarefaList.isEmpty()) {
            System.out.println("Lista vazia");
            return;
        }
    }
}