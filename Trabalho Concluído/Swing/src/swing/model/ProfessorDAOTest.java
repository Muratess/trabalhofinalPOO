package swing.model;

import java.util.Scanner;

public class ProfessorDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ProfessorDAO dao = new ProfessorDAO();		
		Aluno c = new Aluno();
		
		for(;;) {
			System.out.println("\t\tMENU");
			System.out.println("1 - Inserir");
			System.out.println("2 - Pesquisar por id");
			System.out.println("3 - Listar todos");
			System.out.println("4 - Atualizar contato");
			System.out.println("5 - Deletar contato");
			System.out.println("0 - Sair");
			
			switch (s.nextInt()) {
			case 0:
				System.out.println("Aplicação Finalizada");
				System.exit(0);
				break;

			default:
				System.out.println("Opção Inválida");
				break;
			}
			
		}

	}
}
