import Service.TarefaService;

import java.util.Scanner;

public class Main {

    private static final Scanner sc1 = new Scanner(System.in);
    private static final TarefaService tarefaService = new TarefaService();

    public static void main(String[] args) {
        int option;

        do {
            menu();
            option = sc1.nextInt();
            sc1.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Insira a descrição da tarefa desejada");
                    String descricao = sc1.nextLine();
                    tarefaService.adicionarTarefa(descricao);
                }
                case 2 -> tarefaService.listarTarefas();
                case 3 -> {
                    System.out.println("Informe o Id, que deseja remover");
                    int id = sc1.nextInt();
                    tarefaService.removerTarefa(id);
                }
                case 4 -> {
                    System.out.println("Informe o Id");
                    int id = sc1.nextInt();
                    sc1.nextLine();
                    if (!tarefaService.retornarSeTiverConcluida(id)) {
                        System.out.println("Digite nova descrição");
                        String novaDescricao = sc1.nextLine();
                        tarefaService.atualizarTarefa(id, novaDescricao);
                    }
                }
                case 5 -> {
                    System.out.println("Informe o Id");
                    int id = sc1.nextInt();
                    tarefaService.marcarConcluido(id);
                }
                case 6 -> tarefaService.exibirTarefasConcluidas();
                case 0 -> System.out.println("Encerrando programa...");
                default -> System.out.println("Opção invalida");
            }
        } while (option != 0);
    }

    public static void menu(){
        System.out.println("=====Menu=====");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefa");
        System.out.println("3. Remover Tarefa");
        System.out.println("4. Atualizar Tarefa");
        System.out.println("5. Marcar Tarefa como concluído");
        System.out.println("6. Tarefa concluídas");
        System.out.println("0. Sair");
    }
}