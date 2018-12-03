package trabalhofinal;

public class Classe {

	private int horario;
	private int sala;
	private String modalidade;

	public Classe(int horario, int sala, String modalidade) {
		super();
		this.horario = horario;
		this.sala = sala;
		this.modalidade = modalidade;
	}

	public Classe() {
		super();
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
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
		int result = 1;
		result = prime * result + horario;
		result = prime * result + ((modalidade == null) ? 0 : modalidade.hashCode());
		result = prime * result + sala;
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
		Classe other = (Classe) obj;
		if (horario != other.horario)
			return false;
		if (modalidade == null) {
			if (other.modalidade != null)
				return false;
		} else if (!modalidade.equals(other.modalidade))
			return false;
		if (sala != other.sala)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Classe [horario=" + horario + ", sala=" + sala + ", modalidade=" + modalidade + "]";
	}

}
