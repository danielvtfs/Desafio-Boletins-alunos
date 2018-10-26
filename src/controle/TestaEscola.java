package controle;

import dominio.Aluno;
import dominio.Escola;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Java
 */
public class TestaEscola {

	static Aluno temp = null;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Escola escola = new Escola();

		int opcao = 0;
		boolean opcaoValida = false;
		boolean opcaoValida2 = true;

		String voltar = null;

		do {

			System.out.println("=================================================");
			System.out.println("Bem vindo ao sistema de gerenciamento escolar");
			System.out.println("=================================================");
			System.out.println("Escolha um opção para prosseguir:");

			do {
				try {

					System.out.println("1 - Inserir Aluno;\n" + "2 - Listar Alunos;\n" + "3 - Deletar Aluno; \n"
							+ "4 - Alterar Aluno;");
					opcao = scan.nextInt();
					if (opcao >= 1 && opcao <= 4) {
						opcaoValida = true;
					} else {
						System.out.println("opcão inválida");
					}

				} catch (InputMismatchException e) {
					scan = new Scanner(System.in);
					System.out.println("opcão inválida");
					System.out.println(" Digite somente opções de 1 a 4");
				}

			} while (!opcaoValida);

			switch (opcao) {
				case 1:{
					Aluno aluno = escola.handleInsert(scan);
	
					System.out.println("=================================================");
					System.out.println("Aluno inserido com sucesso! (DIGITE ##VOLTAR## PARA VOLTAR AO MENU)");
					System.out.println(aluno);
					System.out.println("=================================================");
	
					voltar = scan.next();
					if (voltar.equalsIgnoreCase("voltar")) {
						opcaoValida2 = false;
					} else {
						System.out.println("Programa finalizado");
						opcaoValida2 = true;
						break;
					}
					break;
				}
				case 2:
					System.out.println("=================================================");
					System.out.println("Lista de alunos! (DIGITE ##VOLTAR## PARA VOLTAR AO MENU)");
					escola.listarAluno();
					System.out.println("=================================================");
	
					voltar = scan.next();
					if (voltar.equalsIgnoreCase("voltar")) {
						opcaoValida2 = false;
					} else {
						System.out.println("Programa finalizado");
						opcaoValida2 = true;
						break;
					}
					break;
	
				case 3:
					System.out.println("=================================================");
					System.out.println("Excluir aluno!");
					System.out.println("=================================================");
	
					System.out.println("Digite a matrícula do aluno para excluir.");
					String matricula = scan.next();
	
					/*
					 * for (int i = 0; i < escola.getAlunos().size(); i++) { if
					 * (escola.getAlunos().get(i).getMatricula().equals(matricula)) {
					 * escola.getAlunos().remove(i); } }
					 */
	
					escola.getAlunos().forEach((alunoUm) -> {
	
						if (alunoUm.getMatricula().equals(matricula)) {
							temp = alunoUm;
						}
					});
	
					escola.getAlunos().remove(temp);
					temp = null;
	
					System.out.println("======Aluno Excluído======");
					System.out.println("(DIGITE ##VOLTAR## PARA VOLTAR AO MENU)");
	
					voltar = scan.next();
					if (voltar.equalsIgnoreCase("voltar")) {
						opcaoValida2 = false;
					} else {
						System.out.println("Programa finalizado");
						opcaoValida2 = true;
						break;
					}
					break;
	
				case 4: {
					handleEditar(scan, escola);
					
					System.out.println("======Aluno Editado======");
					System.out.println("(DIGITE ##VOLTAR## PARA VOLTAR AO MENU)");
					
					voltar = scan.next();
					if (voltar.equalsIgnoreCase("voltar")) {
						opcaoValida2 = false;
					} else {
						System.out.println("Programa finalizado");
						opcaoValida2 = true;
						break;
					}
					break;
	
				}
			}

		} while (!opcaoValida2);

	}

	
	private static void handleEditar(Scanner scan, Escola escola) {
		System.out.println("=================================================");
		System.out.println("Editar aluno!");
		System.out.println("=================================================");

		System.out.println("Digite a matrícula do aluno que deseja editar: ");
		String matriculaUm = scan.next();

		escola.getAlunos().forEach((alunoUm) -> {

			if (alunoUm.getMatricula().equals(matriculaUm)) {
				temp = alunoUm;
			}
		});
		
		System.out.println("Digite o nome ( "+ temp.getNome() + " ): ");
		temp.setNome(scan.next());
		
		System.out.println("Digite a matricula ( "+ temp.getMatricula() + " ): ");
		temp.setMatricula(scan.next());
		
		System.out.println("Digite a turma ( "+ temp.getTurma() + " ): ");
		temp.setTurma(scan.next());
		
		temp.getNotas().clear();
		
		for (int i = 0; i < 4; i++) {
			
			System.out.println("Digite a nota " + (i + 1) + " do aluno ");
			double nota = scan.nextDouble();
			
			
			if ((nota <= 10) && (nota >= 0)) {
				temp.getNotas().add(nota);
			} else {
				System.out.println("A nota deve ser entre 0 e 10");
				i--;
			}
		}
		
		
	}

}
