package lt.codeacademy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVHandler {
  private static final String HEADER =
      "ID,suma,kategorija,papildoma info,data,pozymis ar i banka,data su laiku,atsiskaitymo budas";
  private static final String DELIMITER = ",";

  public static void writeToCsv(
      List<PajamuIrasas> pajamuDuomenys, List<IslaiduIrasas> islaiduDuomenys) {

    try (FileWriter writer = new FileWriter("Biudzeto irasai.csv")) {
      writer.append(HEADER);
      writer.append("\n");
      for (PajamuIrasas irasas : pajamuDuomenys) {
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
      for (IslaiduIrasas irasas : islaiduDuomenys) {
        writer.append(irasas.getUnikalusNr());
        writer.append(DELIMITER);
        writer.append(String.valueOf(irasas.getSuma()));
        writer.append(DELIMITER);
        writer.append(irasas.getKategorija());
        writer.append(DELIMITER);
        writer.append(irasas.getPapildomaInfo());
        writer.append(DELIMITER);
        writer.append(DELIMITER);
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

  public static void readFromCSV(Biudzetas biudzetas) {

    try (BufferedReader reader = new BufferedReader((new FileReader("Biudzeto irasai.csv")))) {
      String line;
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        String[] duomenys = line.split(DELIMITER);
        if (duomenys[0].charAt(0) == 'P') {
          biudzetas.pridetiIrasa(
              new PajamuIrasas(
                  Float.parseFloat(duomenys[1]),
                  Scan.stringToDate(duomenys[4]),
                  duomenys[2],
                  Boolean.getBoolean(duomenys[5]),
                  duomenys[3]));
        } else {
          biudzetas.pridetiIrasa(
              new IslaiduIrasas(
                  Float.parseFloat(duomenys[1]),
                  Scan.stringToDateTime(duomenys[6]),
                  duomenys[2],
                  duomenys[7],
                  duomenys[3]));
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("No existing file found");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
// "ID,1suma,2kategorija,3papildoma info,4data,5pozymis ar i banka,6data su laiku,atsiskaitymo
// budas";
