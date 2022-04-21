import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class OrchidDataAvgProcessor implements Runnable {
    // Tambahkan atribut sesuai kebutuhan
    private OrchidMeanDatum meanDatum;
    private String rawDataFilename;

    public OrchidDataAvgProcessor(OrchidMeanDatum meanDatum, String rawDataFilename) {
        // Konstruktor
        this.meanDatum = meanDatum;
        this.rawDataFilename = rawDataFilename;
    }

    @Override
    public void run() {
        // Menghitung rata-rata dari data yang dibaca dengan CSVReader, lalu update
        // meanDatum dengan rata-rata dari setiap aspek data

        // Apabila muncul IOException, maka hasil pembacaan data adalah kosong
        // dan meanDatum tidak di-update (tidak di throw lagi)
        try {
            CSVReader reader = new CSVReader(rawDataFilename, ",");
            reader.setSkipHeader(true);
            List<String[]> data = reader.read();
            float TotalPetalLength = 0;
            float TotalPetalWidth = 0;
            float TotalStemLength = 0;
            for (String[] row : data) {
                TotalPetalLength += Float.parseFloat(row[0]);
                TotalPetalWidth += Float.parseFloat(row[1]);
                TotalStemLength += Float.parseFloat(row[2]);
            }
            meanDatum.setMean(TotalPetalLength/data.size(), TotalPetalWidth/data.size(), TotalStemLength/data.size());
        } catch (IOException e) {
            // Do nothing
        }
    }
}