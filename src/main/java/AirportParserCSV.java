class AirportParserCSV {
    private static final String[] EMPTY = {};

    static String[] parse(String line, int keyData) {
        String[] columns;
        if (keyData == 0) {
            columns = line.split(",", 2);
        } else {
            columns = line.split(",");
        }

        int size = columns.length;
        for (int i = 0; i < size; i++) {
            String check = columns[i];
            columns[i] = columns[i].replaceAll("\"", "");
            if (columns[i].equals("")) {
                return EMPTY;
            }
        }

        return columns;
    }
}
