package swing.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import swing.control.ProfessorController;
import swing.model.Aluno;
import javax.swing.JList;

public class AlunoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeAluno;
	private JTextField txtTelefoneAluno;
	private JTextField txtIdAluno;
	private boolean atualizou = false;
	private JTextField txtEnderecoAluno;
	private JTextField txtCPFAluno;
	private JTextField txtModalidadeAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoGUI frame = new AlunoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlunoGUI() {
		ProfessorController cc = new ProfessorController();

		setTitle("Matrícula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Matr\u00EDcula Academia");
		lblNewLabel.setBounds(165, 0, 146, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno");
		lblNomeDoAluno.setBounds(34, 50, 146, 14);
		contentPane.add(lblNomeDoAluno);

		txtNomeAluno = new JTextField();
		txtNomeAluno.setEditable(false);
		txtNomeAluno.setBounds(198, 47, 221, 20);
		contentPane.add(txtNomeAluno);
		txtNomeAluno.setColumns(10);

		JLabel lblTelefoneDoAluno = new JLabel("Telefone do Aluno");
		lblTelefoneDoAluno.setBounds(34, 75, 140, 14);
		contentPane.add(lblTelefoneDoAluno);

		txtTelefoneAluno = new JTextField();
		txtTelefoneAluno.setEditable(false);
		txtTelefoneAluno.setBounds(198, 72, 221, 20);
		contentPane.add(txtTelefoneAluno);
		txtTelefoneAluno.setColumns(10);

		JButton btnSalvarAluno = new JButton("Salvar");
		btnSalvarAluno.setEnabled(false);
		btnSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = txtNomeAluno.getText();
				String telefone = txtTelefoneAluno.getText();
				
				boolean retorno = cc.insert(new Aluno(nome, telefone));

				if (retorno) {
					JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao salvar");
				}
				txtNomeAluno.setEditable(false);
				txtTelefoneAluno.setEditable(false);
				txtEnderecoAluno.setEditable(false);
				txtCPFAluno.setEditable(false);
				txtModalidadeAluno.setEditable(false);
				txtIdAluno.setEditable(false);
				btnSalvarAluno.setEnabled(false);
			}
		});
		btnSalvarAluno.setBounds(113, 184, 105, 23);
		contentPane.add(btnSalvarAluno);

		JButton btnCancelarContato = new JButton("Sair");
		btnCancelarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(null, "Deseja sair?", "", JOptionPane.YES_NO_OPTION);

				if (op == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		btnCancelarContato.setBounds(222, 184, 103, 23);
		contentPane.add(btnCancelarContato);

		JButton btnLimparContato = new JButton("Limpar");
		btnLimparContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeAluno.setText("");
				txtTelefoneAluno.setText("");
				txtEnderecoAluno.setText("");
				txtCPFAluno.setText("");
				txtModalidadeAluno.setText("");
				txtIdAluno.setText("");
			}
		});
		btnLimparContato.setBounds(335, 184, 89, 23);
		contentPane.add(btnLimparContato);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(34, 27, 46, 14);
		contentPane.add(lblId);

		txtIdAluno = new JTextField();
		txtIdAluno.setEditable(false);
		txtIdAluno.setBounds(198, 24, 221, 20);
		contentPane.add(txtIdAluno);
		txtIdAluno.setColumns(10);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdAluno.setEditable(true);
				txtNomeAluno.setEditable(true);
				txtTelefoneAluno.setEditable(true);
				txtEnderecoAluno.setEditable(true);
				txtCPFAluno.setEditable(true);
				txtModalidadeAluno.setEditable(true);
				btnSalvarAluno.setEnabled(true);

			}
		});
		btnNovo.setBounds(19, 184, 89, 23);
		contentPane.add(btnNovo);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane.showInputDialog(null, "Digite o ID que deseja procurar");
				long id = Long.parseLong(resp);

				Aluno contato = cc.select(id);
				if (contato != null) {
					JOptionPane.showMessageDialog(null, contato);
				} else {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado");
				}

			}
		});
		btnProcurar.setBounds(55, 232, 89, 23);
		contentPane.add(btnProcurar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!atualizou) {
					String resp = JOptionPane.showInputDialog(null, "Digite o id que deseja atualizar");
					long id = Long.parseLong(resp);
					Aluno contato = cc.select(id);
					txtIdAluno.setText("" + contato.getId());
					txtNomeAluno.setText("" + contato.getNome());
					txtTelefoneAluno.setText("" + contato.getTelefone());
					txtNomeAluno.setEditable(true);
					txtTelefoneAluno.setEditable(true);
					atualizou = true;
					btnAtualizar.setText("Confirma");
				} else {
					long id = Long.parseLong(txtIdAluno.getText());
					String nome = txtNomeAluno.getText();
					String telefone = txtTelefoneAluno.getText();
					boolean retorno = cc.update(new Aluno(id, nome, telefone));

					if (retorno) {
						JOptionPane.showMessageDialog(null, "Aluno atualizado");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao atualizar");
					}
					atualizou = false;
				}

			}
		});
		btnAtualizar.setBounds(178, 232, 89, 23);
		contentPane.add(btnAtualizar);
		JList lstContatos = new JList();

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Aluno> lista = cc.select();
				lstContatos.setListData(lista.toArray());
			}
		});
		btnListar.setBounds(295, 232, 89, 23);
		contentPane.add(btnListar);

		lstContatos.setBounds(9, 277, 410, 122);
		contentPane.add(lstContatos);
		
		JLabel lblEnderecoDoAluno = new JLabel("Endere\u00E7o do Aluno");
		lblEnderecoDoAluno.setBounds(34, 100, 146, 14);
		contentPane.add(lblEnderecoDoAluno);
		
		JLabel lblCPFdoAluno = new JLabel("CPF do Aluno");
		lblCPFdoAluno.setBounds(34, 125, 140, 14);
		contentPane.add(lblCPFdoAluno);
		
		txtEnderecoAluno = new JTextField();
		txtEnderecoAluno.setEditable(false);
		txtEnderecoAluno.setBounds(198, 97, 221, 20);
		contentPane.add(txtEnderecoAluno);
		txtEnderecoAluno.setColumns(10);
		
		txtCPFAluno = new JTextField();
		txtCPFAluno.setEditable(false);
		txtCPFAluno.setBounds(198, 122, 221, 20);
		contentPane.add(txtCPFAluno);
		txtCPFAluno.setColumns(10);
		
		JLabel lblModalidadeDoAluno = new JLabel("Modalidade do Aluno");
		lblModalidadeDoAluno.setBounds(34, 150, 146, 14);
		contentPane.add(lblModalidadeDoAluno);
		
		txtModalidadeAluno = new JTextField();
		txtModalidadeAluno.setEditable(false);
		txtModalidadeAluno.setBounds(198, 147, 221, 20);
		contentPane.add(txtModalidadeAluno);
		txtModalidadeAluno.setColumns(10);
	}
}
