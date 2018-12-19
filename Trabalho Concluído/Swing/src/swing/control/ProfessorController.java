package swing.control;

import java.util.ArrayList;

import swing.model.Aluno;
import swing.model.ProfessorDAO;

public class ProfessorController {

	ProfessorDAO dao = new ProfessorDAO();

	public boolean insert(Aluno aluno) {
		try {
			dao.insert(aluno);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public Aluno select(long id) {
		return dao.select(id);
	}

	public ArrayList<Aluno> select() {

		return (ArrayList<Aluno>) dao.select();
	}

	public boolean update(Aluno aluno) {
		try {
			dao.update(aluno);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
