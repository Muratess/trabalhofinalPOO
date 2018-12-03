package trabalhofinal;

import java.util.Date;

public class Professor extends Pessoa {

	private String matricula;
	private String modalidade;

	public Professor(String nome, Date datanasc, String cpf, String telefone, String matricula, String modalidade) {
		super(nome, datanasc, cpf, telefone);
		this.matricula = matricula;
		this.modalidade = modalidade;
	}

	public Professor() {
		super();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((modalidade == null) ? 0 : modalidade.hashCode());
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
		Professor other = (Professor) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (modalidade == null) {
			if (other.modalidade != null)
				return false;
		} else if (!modalidade.equals(other.modalidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Professor [matricula=" + matricula + ", modalidade=" + modalidade + ", toString()=" + super.toString()
				+ "]";
	}

}
