package il.finkel.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.dto.QueryResult.Result;
import org.influxdb.dto.QueryResult.Series;

import java.util.List;

import static java.lang.System.out;

/**
 * @author Alexander Krasniansky
 */
public class App {
    public static void main(String[] args) {

        InfluxDB influxDB = InfluxDBFactory.connect("http://localhost:8086", "root", "root");

        Query query = new Query("SELECT * FROM cpu", "serviceHealthReports");

        QueryResult qResult = influxDB.query(query);
        List<Result> results = qResult.getResults();

        for (Result result : results) {
            List<Series> seriesList = result.getSeries();

            for (Series s : seriesList) {
                s.getValues()
                        .stream()
                        .forEach(v -> out.printf("Name=%s, Value=%s\n", s.getName(), v));
            }
        }
    }
}
