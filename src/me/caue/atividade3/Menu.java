package me.caue.atividade3;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.getRootFrame;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
public class Menu {
	
	public static void abrir() {
        boolean programa = true;
		try {
            do {
                boolean opcS = true;
                int opca = 0;
                do {
                    String aux = "Escolha uma das opções:\n\n";
                    aux += "1. Reservar Carga\n";
                    aux += "2. Pesquisar Carga\n";
                    aux += "3. Imprimir Carga Reservadas\n";
                    aux += "4. Excluir Carga\n";
                    aux += "5. Finalizar\n";
                    String opc = showInputDialog(aux);

                    if(opc == null) {
                        return;
                    }

                    if(!opc.matches("[0-9]+")) {
                        showMessageDialog(null, "Opção inválida!");
                    
                    }else {
                        
                        opca = parseInt(opc);
                        if(opca < 1 || opca > 5) {
                            showMessageDialog(null, "Opção inválida!");
                        }else {
                            opcS = false;
                        }
                    }	
                }while(opcS);
                
                if(opca == 1) {
                	reservar();
                }else if(opca == 2) {
                    pesquisar();
                }else if(opca == 3) {
                    imprimir();
                }else if(opca == 4) {
                    excluir();
                }else {
                    showMessageDialog(getRootFrame(), "Programa finalizado com sucesso!");
                    break;
                }
            }while(programa);
        } catch (Exception e) {
            showMessageDialog(null, "ERRO\n\nOuve um erro ao executar o programa!\n\nReporte-o ao suporte:\n" + e);
        }
    }
	
	private static void reservar() {
		String nome = showInputDialog("Qual o nome da empresa dona da carga? ");
		String cnpj = showInputDialog("Qual o CNPJ da empresa dona da carga? ");
		String destino = showInputDialog("Qual o destino da carga? ");
		double peso = 0;
		try {
			peso = Double.parseDouble(showInputDialog("Qual o peso da carga? "));
		} catch (NumberFormatException e) {
			showMessageDialog(null, "Peso inválido!");
		}
		
		showMessageDialog(null, Util.criarCarga(cnpj, nome, destino, peso));
	}
	
	private static void pesquisar() {
		String cpnj = showInputDialog("Qual o CNPJ da empresa que deseja pesquisar? ");
		showMessageDialog(null, Util.pesquisarCarga(cpnj));
	}
	
	private static void imprimir() {
		showMessageDialog(null, Util.imprimirCargas());
	}
	
	private static void excluir() {
		String cpnj = showInputDialog("Qual o CNPJ da empresa que deseja pesquisar? ");
		showMessageDialog(null, Util.excluir(cpnj));

	}
}
