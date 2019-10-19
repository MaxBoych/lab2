class AirportParserCSV {
    private static final String[] EMPTY = {};

    static String[] parse(String line, int keyData) {
        String[] columns;
        if (keyData == 0) {
            columns = line.split(",", 2);
            if (columns[0].equals("\"CODE\"")) {
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                return EMPTY;
            }
        } else {
            columns = line.split(",");
            if ((columns[0].equals("\"YEAR\"")) ||
                    (columns[19].equals("1")) ||
                    (columns[18].equals("0"))) {
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
