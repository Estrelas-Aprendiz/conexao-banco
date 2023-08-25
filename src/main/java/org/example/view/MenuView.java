package org.example.view;

import org.example.model.UsuarioModel;
import org.example.service.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    //Trazendo classes que vamos utilizar
    private Scanner scanner;
    private UsuarioModel usuarioModel;
    private UsuarioService usuarioService;


    public MenuView(){
        scanner = new Scanner(System.in);
        usuarioModel = new UsuarioModel();
        usuarioService = new UsuarioService();
    }

    public void iniciar(){

        int opcao;

        do {
            imprimirMenu();
            opcao = selecionarOpcao();

            switch (opcao){
                case 1:
                    usuarioService.consultaTodosDados();
                    break;
                case 2:
                    System.out.println("Digite o nome que deseja inserir na tabela: ");
                    String nome = scanner.nextLine();
                    usuarioModel.setNome(nome);
                    usuarioService.inserirDados(usuarioModel.getNome());
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }while (opcao != 0);
    }

    public void imprimirMenu(){
        System.out.println("Digite uma das seguinte opções");
        System.out.println("1 - Consultar todos os dados da tabela.");
        System.out.println("2 - Inserir dados na tabela.");
        System.out.println("0 - Sair.");
    }

    public int selecionarOpcao(){
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scanner.nextLine();
        }
        return 1;
    }





}
