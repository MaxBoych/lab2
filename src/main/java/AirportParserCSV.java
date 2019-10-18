public class AirportParserCSV {
    private static final String[] EMPTY = {};

    public static String[] parse(String line) {
        String[] columns = line.split(",", 2);

        for (int i = 0; i < 2; i++) {
            String check = columns[i];
            columns[i] = columns[i].replaceAll("\"", "");
            if (check.equals(columns[i])) {
                return EMPTY;
            }
        }

        return columns;
    }
}
