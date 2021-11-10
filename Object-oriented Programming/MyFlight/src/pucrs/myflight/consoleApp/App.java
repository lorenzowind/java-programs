package pucrs.myflight.consoleApp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import pucrs.myflight.modelo.*;
import pucrs.myflight.modelo.Voo.Status;

public class App {

	public static void main(String[] args) {
		System.out.println("\nMyFlight project...");

		GerenciadorAeronaves gerenciadorAeronaves = new GerenciadorAeronaves();
		GerenciadorAeroportos gerenciadorAeroportos = new GerenciadorAeroportos();
		GerenciadorCias gerenciadorCias = new GerenciadorCias();
		GerenciadorRotas gerenciadorRotas = new GerenciadorRotas();
		GerenciadorVoos gerenciadorVoos = new GerenciadorVoos();

		gerenciadorCias.adicionar(new CiaAerea("JJ", "LATAM Linhas Aéreas"));
		gerenciadorCias.adicionar(new CiaAerea("G3", "Gol Linhas Aéreas SA"));
		gerenciadorCias.adicionar(new CiaAerea("TP", "TAP Portugal"));
		gerenciadorCias.adicionar(new CiaAerea("AD", "Azul Linhas Aéreas"));

		gerenciadorAeronaves.adicionar(new Aeronave("732", "Boeing 737-300", 140));
		gerenciadorAeronaves.adicionar(new Aeronave("738", "Boeing 737-700", 126));
		gerenciadorAeronaves.adicionar(new Aeronave(
			"332", 
			"Airbus Industrie A380", 
			644
		));
		gerenciadorAeronaves.adicionar(new Aeronave("320", "Boeing 767-400", 304));

		gerenciadorAeroportos.adicionar(new Aeroporto(
			"POA", 
			"Salgado Filho Intl Apt", 
			new Geo(-29.9939, -51.1711)
		));
		gerenciadorAeroportos.adicionar(new Aeroporto(
			"GRU", 
			"São Paulo Guarulhos Intl Apt", 
			new Geo(-23.4356, -46.4731)
		));
		gerenciadorAeroportos.adicionar(new Aeroporto(
			"LIS", 
			"Lisbon", 
			new Geo(38.7742, -9.1342)
		));
		gerenciadorAeroportos.adicionar(new Aeroporto(
			"MIA", 
			"Miami International Apt", 
			new Geo(25.7933, -80.2906)
		));

		Rota rota1 = new Rota(
			gerenciadorCias.buscarPorCodigo("G3"),
			gerenciadorAeroportos.buscarPorCodigo("GRU"),
			gerenciadorAeroportos.buscarPorCodigo("POA"),
			gerenciadorAeronaves.buscarPorCodigo("738")
		);

		gerenciadorRotas.adicionar(rota1);
        

		Rota rota2 = new Rota(
			gerenciadorCias.buscarPorCodigo("G3"),
			gerenciadorAeroportos.buscarPorCodigo("POA"),
			gerenciadorAeroportos.buscarPorCodigo("GRU"),
			gerenciadorAeronaves.buscarPorCodigo("738")
		);
		gerenciadorRotas.adicionar(rota2);

		Rota rota3 = new Rota(
			gerenciadorCias.buscarPorCodigo("TP"),
			gerenciadorAeroportos.buscarPorCodigo("MIA"),
			gerenciadorAeroportos.buscarPorCodigo("LIS"),
			gerenciadorAeronaves.buscarPorCodigo("332")
		);
		gerenciadorRotas.adicionar(rota3);

		Rota rota4 = new Rota(
			gerenciadorCias.buscarPorCodigo("JJ"),
			gerenciadorAeroportos.buscarPorCodigo("GRU"),
			gerenciadorAeroportos.buscarPorCodigo("POA"),
			gerenciadorAeronaves.buscarPorCodigo("320")
		);
		gerenciadorRotas.adicionar(rota4);


		Rota rotaselecionada = null;

		for (Rota rota : gerenciadorRotas.buscarPorOrigem(
			gerenciadorAeroportos.buscarPorCodigo("POA")
		)) {
			if (rota.getCia().equals(
				gerenciadorCias.buscarPorCodigo("G3")
			)) {
				rotaselecionada = rota;
				break;
			}
		} 

		gerenciadorVoos.adicionar(new VooDireto(
			rotaselecionada,
			LocalDateTime.of(2016, 8, 10, 8, 0)
		));

		for (Voo voo : gerenciadorVoos.buscarPorData(
			LocalDate.of(2016, 8, 10)
		)) {
			if (voo.getDatahora().getHour() == 8 &&
				voo.getDatahora().getMinute() == 0 &&
				voo.getRota().equals(rotaselecionada)
			) {
				voo.setStatus(Status.ATRASADO);
				break;
			}
		} 

		for (Rota rota : gerenciadorRotas.buscarPorOrigem(
			gerenciadorAeroportos.buscarPorCodigo("GRU")
		)) {
			if (rota.getCia().equals(
				gerenciadorCias.buscarPorCodigo("G3")
			)) {
				rotaselecionada = rota;
				break;
			}
		} 

		gerenciadorVoos.adicionar(new VooDireto(
			rotaselecionada,
			LocalDateTime.of(2016, 8, 10, 15, 0) 
		));

		for (Rota rota : gerenciadorRotas.buscarPorOrigem(
			gerenciadorAeroportos.buscarPorCodigo("MIA")
		)) {
			if (rota.getCia().equals(
				gerenciadorCias.buscarPorCodigo("TP")
			)) {
				rotaselecionada = rota;
				break;
			}
		} 

		gerenciadorVoos.adicionar(new VooDireto(
			rotaselecionada,
			LocalDateTime.of(2016, 8, 15, 12, 0)
		));

		for (Voo voo : gerenciadorVoos.buscarPorData(
			LocalDate.of(2016, 8, 15)
		)) {
			if (voo.getDatahora().getHour() == 12 &&
				voo.getDatahora().getMinute() == 0 &&
				voo.getRota().equals(rotaselecionada)
			) {
				voo.setStatus(Status.CANCELADO);
				break;
			}
		}

		VooEscalas vooEscalas = new VooEscalas(
			LocalDateTime.of(2016, 8, 10, 8, 0)
		);
		vooEscalas.adicionaRota(rota1);
		vooEscalas.adicionaRota(rota2);
		System.out.println(vooEscalas);
        System.out.println();
		System.out.println(vooEscalas.getDuracao().toHours());

	}
}
