class AirportParserCSV {
    private static final String[] EMPTY = {};
    private static final int CANCELED = 19;
    private static final int DELAYED = 18;

    static String[] parse(String line, int keyData) {
        String[] columns;
        if (keyData == 0) {
            columns = line.split(",", 2);
            if (columns[0].equals("Code")) {
                return EMPTY;
            }
        } else {
            columns = line.split(",");
            if ((columns[0].equals("\"YEAR\"")) ||
                    (columns[CANCELED].equals("1.00")) ||
                    (columns[DELAYED].equals("0.00"))) {
                return EMPTY;
            }
        }

        int size = columns.length;
        for (int i = 0; i < size; i++) {
            columns[i] = columns[i].replaceAll("\"", "");
        }

        return columns;
    }
}
