package me.caue.atividade3;

public class Carga {
	private String empresa;
	private String cnpj;
	private String destino;
	private double peso;
	
	public Carga(String empresa, String cnpj, String destino, double peso) {
		this.empresa = empresa;
		this.cnpj = cnpj;
		this.destino = destino;
		this.peso = peso;
	}
	
	public Carga(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public boolean equals(Object obj) {
		Carga carga = (Carga) obj;
		if(carga.cnpj.equalsIgnoreCase(cnpj)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String aux = "\n";
		aux += cnpj + ":";
		aux += "\n  Empresa: " + empresa;
		aux += "\n  CNPJ: " + cnpj;
		aux += "\n  Destino: " + destino;
		aux += "\n  Peso: " + String.format("%.2f", peso);
		return aux;
	}
}
