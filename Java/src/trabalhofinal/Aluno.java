package trabalhofinal;

import java.util.Date;

public class Aluno extends Pessoa {

	private String matricula;

	public Aluno() {
		super();
	}

	public Aluno(String nome, Date datanasc, String cpf, String telefone, String matricula) {
		super(nome, datanasc, cpf, telefone);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	Endereco AlunoEnde = new Endereco();
	public Endereco getAlunoEnde() {
		return AlunoEnde;
	}
	
	public void setAlunoEnde(Endereco AlunoEnde) {
		this.AlunoEnde = AlunoEnde;
	}
	
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", AlunoEnde=" + AlunoEnde + ", toString()=" + super.toString() + "]";
	}
	
	
}












