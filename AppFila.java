import javax.swing.JOptionPane;

public class AppFila {
	public static void main(String[] args) {
		Fila<Pessoa> fila = new Fila<Pessoa>();
		
		String menu = "1. Chegada de uma pessoa;\n"
				+ "2. Atendimento de uma pessoa;\n"
				+ "3. Lista todas as pessoas da fila;\n"
				+ "4. Gerar estatísticas sobre o atendimento prioritário, normal e mostrar o tamanho da fila;\n"
				+ "5. Sair.";
		
		int op = -1;
		String nome;
		int idade;
		Pessoa p;
		int prioridade;
		int normal;
		int tamanho;
		
		while (op != 6) {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (op) {
			case 1:
				nome = JOptionPane.showInputDialog("Nome:");
				idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Idade:"));
				p = new Pessoa(nome, idade);
				if(idade>=60) fila.enqueuep(p);
				else fila.enqueue(p);
				break;
			case 2:
				try {
					p = (Pessoa) fila.dequeue();
					JOptionPane.showMessageDialog(null, p.getNome() + "\n" + p.getIdade());
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 3:
				String msg="";
				for (Pessoa aux : fila) {
					msg += aux.getNome();
					msg +="\n";
				}
				JOptionPane.showMessageDialog(null, msg);
				break;
			case 4:
				prioridade = fila.atendimentoPrioridade();
				JOptionPane.showMessageDialog(null, "Fila prioridade já atendida: " + prioridade + "%"+ "\n");
				normal = fila.atendimentoNormal();
				JOptionPane.showMessageDialog(null, "Fila normal já atendida: " +normal + "%"+ "\n");
				tamanho = fila.size();
				JOptionPane.showMessageDialog(null, "Tamanho da fila: " +tamanho + "\n");
				break;
			case 5:
				prioridade = fila.atendimentoPrioridade();
				JOptionPane.showMessageDialog(null, "Fila prioridade já atendida: " + prioridade + "%"+ "\n");
				normal = fila.atendimentoNormal();
				JOptionPane.showMessageDialog(null, "Fila normal já atendida: " +normal + "%"+ "\n");
				tamanho = fila.size();
				JOptionPane.showMessageDialog(null, "Tamanho da fila: " +tamanho  + "\n");
				if(fila.isEmpty()) {
					op=6;
				}
				else op=-1;
			}
		}
	}
}
