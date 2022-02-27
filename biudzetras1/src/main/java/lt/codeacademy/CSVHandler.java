package lt.codeacademy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVHandler {
  private static final String HEADER =
      "ID,suma,kategorija,papildoma info,data,pozymis ar i banka,data su laiku,atsiskaitymo budas";
  private static final String DELIMITER = ",";

  public static void writeToCsv(List<PajamuIrasas> pajamuDuomenys, List<IslaiduIrasas> islaiduDuomenys) {

    try (FileWriter writer = new FileWriter("Biudzeto irasai.csv")) {
      writer.append(HEADER);
      writer.append("\n");
      for(PajamuIrasas irasas : pajamuDuomenys){
        writer.append(irasas.getUnikalusNr());
        writer.append(DELIMITER);
        writer.append(String.valueOf(irasas.getSuma()));
        writer.append(DELIMITER);
        writer.append(irasas.getKategorija());
        writer.append(DELIMITER);
        writer.append(irasas.getPapildomaInfo());
        writer.append(DELIMITER);
        writer.append(String.valueOf(irasas.getData()));
        writer.append(DELIMITER);
        writer.append(String.valueOf(irasas.isPozymisArIBanka()));
        writer.append("\n");
      }
      for(IslaiduIrasas irasas : islaiduDuomenys){
        writer.append(irasas.getUnikalusNr());
        writer.append(DELIMITER);
        writer.append(String.valueOf(irasas.getSuma()));
        writer.append(DELIMITER);
        writer.append(irasas.getKategorija());
        writer.append(DELIMITER);
        writer.append(irasas.getPapildomaInfo());
        writer.append(DELIMITER);
        writer.append(String.valueOf(irasas.getDataSuLaiku()));
        writer.append(DELIMITER);
        writer.append(irasas.getAtsiskaitymoBudas());
        writer.append("\n");
      }


    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
