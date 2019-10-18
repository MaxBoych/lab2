public class AirportParserCSV {
    private String airportID;
    private String airportName;

    public String[] parse(String line) {
        String[] colums = line.split(",", 2);

        for (int i = 0; i < 2; i++) {
            String check = colums[i];
            colums[i] = colums[i].replaceAll("\"", "");
            if (check.equals(colums[i])) {
                return String[];
            }
        }
    }
}
