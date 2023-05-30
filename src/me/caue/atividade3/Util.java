package me.caue.atividade3;

import java.util.Map;
import java.util.TreeMap;

public class Util {
	private static Map<String,Carga> listaCarga = new TreeMap<>();
	private static double pesoTotal = 0;
	
	public static String criarCarga(String cnpj, String empresa, String destino, double peso) {
		if(listaCarga.containsKey(cnpj) == true) return "Esse CNPJ já contém uma carga.";
		if(pesoTotal > 10000 || pesoTotal + peso > 10000) return "Limite de peso do navio foi exedido.";
		pesoTotal += peso;
		listaCarga.put(cnpj, new Carga(empresa, cnpj, destino, peso));
		return "Carga registrada com sucesso";
	}
	
	public static String pesquisarCarga(String cnpj) {
		if(listaCarga.containsKey(cnpj) == false) {
			return "Essa carga não existe!";
		}else {
			return listaCarga.get(cnpj).toString();
		}

	}
	
	public static String imprimirCargas() {
		if(listaCarga.size() == 0) {
			return "Nenhuma carga adicionada";
		}
		String aux = "";
		for (Map.Entry<String,Carga> carga : listaCarga.entrySet()) {
			Carga value = carga.getValue();
			aux += value.toString();
		}
		return aux;
	}
	
	public static String excluir(String cnpj) {
		if(listaCarga.containsKey(cnpj) == true){
			listaCarga.remove(cnpj);
			return "Carga excluida com sucesso!";
		}else {
			return "Essa carga não existe!";

		}
	}
}