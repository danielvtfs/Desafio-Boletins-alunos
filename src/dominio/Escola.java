package dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Escola {

	private Set<Aluno> alunos = new HashSet<>();

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void listarAluno() {
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}

	}
	
	public Aluno handleInsert(Scanner scan) {
		System.out.println("=================================================");
		System.out.println("Insira as informações do aluno");
		System.out.println("=================================================");
		System.out.println("");

		System.out.println("Digite o nome do aluno: ");
		String nomeAluno = scan.next();
		System.out.println("Digite a matrícula do aluno: " + nomeAluno);
		String matAluno = scan.next();
		System.out.println("Digite a turma do aluno: " + nomeAluno);
		String turmaAluno = scan.next();

		List<Double> notas = new ArrayList<>();

		for (int i = 0; i < 4; i++) {

			System.out.println("Digite a nota " + (i + 1) + " do aluno " + nomeAluno);
			double nota = scan.nextDouble();

			if ((nota <= 10) && (nota >= 0)) {
				notas.add(nota);
			} else {
				System.out.println("A nota deve ser entre 0 e 10");
				i--;
			}
		}

		Aluno aluno = new Aluno(nomeAluno, matAluno, turmaAluno, notas);
		getAlunos().add(aluno);
		return aluno;
	}
	
	

}