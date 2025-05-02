package ejercicio2.services;

import com.opencsv.CSVReader;
import ejercicio2.model.FuenteDeDatos;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorCVS implements FuenteDeDatos {
    private String cvsPath;

    public LectorCVS(String cvsPath) {
        this.cvsPath = cvsPath;
    }

    @Override
    public List<String[]> toList() {
        try {
            List<String[]> csvData = new ArrayList<String[]>();
            CSVReader reader = new CSVReader(new FileReader(this.cvsPath));
            String[] row = null;

            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }
            reader.close();
            csvData.remove(0);
            return csvData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
