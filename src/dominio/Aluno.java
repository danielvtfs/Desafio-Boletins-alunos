package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {

	private String nome;
	private String matricula;
	private String turma;
	private List<Double> notas;

	public Aluno() {
		super();
	}

	public Aluno(String nome, String matricula, String turma, List<Double> notas) {
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	public double obterMedia() {
		double media;
		double soma = 0;
		for (Double nota : notas) {
			soma += nota;
		}
		media = soma / 4;

		return media;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}	
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		String info = "[Nome: " + this.nome + "], [Matricula: " + this.matricula + "], [Turma: " + this.turma
				+ "], [Media: " + obterMedia() + "]";
		return info;
	}

	
}
