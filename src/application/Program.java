
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import model.Entites.Produtos;

public class Program {

   
 
       public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);

		List<Produtos> list = new ArrayList<>();

		System.out.println("Digite o caminho do arquivo .csv que será Consumido: ");
		String FileStr = ler.nextLine();

		File pathFile = new File(FileStr);
		String pathFolderStr = pathFile.getParent();
		
                System.out.println("Nomear a pasta:  ");
                String nameDirectory = ler.nextLine();
		boolean success = new File(pathFolderStr + "\\"+nameDirectory).mkdir();
		System.out.println("Nomear a Arquivo:  ");
                String nameFile = ler.nextLine();
		String targetFileStr = pathFolderStr + "\\"+nameDirectory+"\\"+nameFile+".csv";

		try (BufferedReader br = new BufferedReader(new FileReader(FileStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Produtos(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Produtos item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CRIADO!");
				
			} catch (IOException ex) {
				System.out.println("Erro ao Escrever arquivo: " + ex.getMessage());
			}

		} catch (IOException ex) {
			System.out.println("Erro ao ler arquivo: " + ex.getMessage());
		}

		ler.close();
	}
        
        
    }
