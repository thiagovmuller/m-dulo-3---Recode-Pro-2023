package crud;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import dao.ClienteDAO;
import dao.PassagemDAO;
import dao.CompraDAO;
import model.Cliente;
import model.Passagem;
import model.Compra;
import connection.ConnectionFactory;

public class Principal {
	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		int opcao = 0;

		while (opcao != 16) {
			menuPrincipal();
			opcao = scanner.nextInt();
			ClienteDAO cDao = new ClienteDAO();
			PassagemDAO pDao = new PassagemDAO();
			CompraDAO coDao = new CompraDAO();

			switch (opcao) {
			case 1: {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Cadastrar");
				System.out.println("Informe o nome:");
				String nome = scanner.next();
				System.out.println("Informe o cpf:");
				String cpf = scanner.next();
				System.out.println("Informe a data de nascimento (dd/mm/yyyy):");
				String dataNascText = scanner.next();
				Date dataNasc = new Date();
				dataNasc = sdf.parse(dataNascText);
				System.out.println("Informe o telefone:");
				String telefone = scanner.next();
				Cliente cliente = new Cliente(nome, cpf, dataNasc, telefone);
				cDao.cadastrar(cliente);
				break;
			}
			
			
			case 2: {
				System.out.println("Consultar");
				for (Cliente c : cDao.consultar()) {
					System.out.println(c.toString());
				}
				break;
			}
			
			
			case 3: {
				System.out.println("Digite um id: ");
				int idCliente = scanner.nextInt();
				Cliente cliente = cDao.consultarId(idCliente);
				System.out.println(cliente.toString());
				break;
			}
			
			
			case 4: {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Atualizar");
				System.out.println("Digite o id:");
				int idCliente = scanner.nextInt();
				System.out.println("Informe o nome:");
				String nome = scanner.next();
				System.out.println("Informe o cpf:");
				String cpf = scanner.next();
				System.out.println("Informe a data de nascimento (dd/mm/yyyy):");
				String dataNascText = scanner.next();
				Date dataNasc = new Date();
				dataNasc = sdf.parse(dataNascText);
				System.out.println("Informe o telefone:");
				String telefone = scanner.next();
				Cliente cliente = new Cliente(idCliente, nome, cpf, dataNasc, telefone);
				cDao.atualizar(cliente);
				System.out.println("Atualizado com sucesso");
				break;
			}
			
			
			case 5: {
				System.out.println("Deletar");
				System.out.println("Digite o id: ");
				int idCliente = scanner.nextInt();
				cDao.deletar(idCliente);
				System.out.println("Deletado com sucesso");
				break;
			}
			
			case 6: {
				System.out.println("Cadastrar Passagem");
				System.out.println("Informe a Cia Aérea: ");
				String ciaAerea = scanner.next();
				System.out.println("Informe a origem: ");
				String origem = scanner.next();
				System.out.println("Informe o destino: ");
				String destino = scanner.next();
				System.out.println("Informe o valor: ");
				Float valor = scanner.nextFloat();
				
				Passagem passagem = new Passagem(ciaAerea, origem, destino, valor);
				pDao.cadastrar(passagem);
				System.out.println("Passagem cadastrada com sucesso");
				break;
			}
			
			case 7: {
				System.out.println("Consultar Passagem");
				for (Passagem p : pDao.consultar()) {
					System.out.println(p.toString());
				}
				break;
			}
			
			case 8: {
				System.out.println("Digite um id: ");
				int idPassagem = scanner.nextInt();
				Passagem passagem = pDao.consultarId(idPassagem);
				System.out.println(passagem.toString());
				break;
			}
			
			case 9: {
				System.out.println("Atualizar Passagem");
				System.out.println("Digite o id:");
				int idPassagem = scanner.nextInt();
				System.out.println("Informe a Cia Aérea:");
				String ciaAerea = scanner.next();
				System.out.println("Informe a origem:");
				String origem = scanner.next();
				System.out.println("Informe o destino:");
				String destino = scanner.next();
				System.out.println("Informe o valor:");
				Float valor = scanner.nextFloat();
				Passagem passagem = new Passagem(idPassagem, ciaAerea, origem, destino, valor);
				pDao.atualizar(passagem);
				System.out.println("Passagem atualizada com sucesso");
				break;
			}
			
			case 10: {
				System.out.println("Deletar Passagem");
				System.out.println("Digite o id: ");
				int idPassagem = scanner.nextInt();
				pDao.deletar(idPassagem);
				System.out.println("Passagem deletada com sucesso");
				break;
			}
			
			case 11: {
				System.out.println("Comprar Passagem");
				System.out.println("Informe o id do Cliente:");
				int idCliente = scanner.nextInt();
				System.out.println("Informe o id da Passagem:");
				int idPassagem = scanner.nextInt();
				System.out.println("Informe a forma de pagamento:");
				String formaPgto = scanner.next();
				System.out.println("Informe o valor total:");
				float valorTotal = scanner.nextFloat();
				
				Compra compra = new Compra(idCliente, idPassagem, formaPgto, valorTotal);
				coDao.comprar(compra);
				System.out.println("Compra realizada com sucesso");
				break;
			}
			
			case 12: {
				System.out.println("Consultar Compra");
				for (Compra co: coDao.consultar()) {
					System.out.println(co.toString());
				}
				break;
			}
			
			case 13: {
				System.out.println("Digite um id: ");
				int idCompra = scanner.nextInt();
				Compra compra = coDao.consultarId(idCompra);
				System.out.println(compra.toString());
				break;
			}
			
			case 14: {
				System.out.println("Atualizar Compra");
				System.out.println("Digite o id:");
				int idCompra = scanner.nextInt();
				System.out.println("Informe o id do cliente:");
				int idCliente = scanner.nextInt();
				System.out.println("Informe o id da passagem:");
				int idPassagem = scanner.nextInt();
				System.out.println("Informe a forma de pagamento:");
				String formaPgto = scanner.next();
				System.out.println("Informe o valor total:");
				Float valorTotal = scanner.nextFloat();
				Compra compra = new Compra(idCompra, idCliente, idPassagem, formaPgto, valorTotal);
				coDao.atualizar(compra);
				System.out.println("Compra atualizada com sucesso");
				break;
			}
			
			case 15: {
				System.out.println("Cancelar Compra");
				System.out.println("Digite o id: ");
				int idCompra = scanner.nextInt();
				coDao.cancelar(idCompra);
				System.out.println("Compra cancelada com sucesso");
				break;
			}
			
			case 16: {
				System.out.println("Encerrando, até logo!");
				break;
			}
			}

		}

		scanner.close();

	}

	public static void menuPrincipal() {
		System.out.println("");
		System.out.println("MENU CLIENTE:  1-Cadastrar | 2-Consultar | 3-Consultar por id | 4-Atualizar | 5-Deletar ");
		System.out.println("MENU PASSAGEM: 6-Cadastrar | 7-Consultar | 8-Consultar por id | 9-Atualizar | 10-Deletar ");
		System.out.println("MENU COMPRA:   11-Comprar  | 12-Consultar| 13-Consultar por id| 14-Atualizar| 15-Cancelar");
		System.out.println("");
		System.out.println("16-SAIR");
		System.out.println("");
	}

}
