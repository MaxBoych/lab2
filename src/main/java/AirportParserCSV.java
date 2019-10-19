class AirportParserCSV {
    private static final String[] EMPTY = {};

    static String[] parse(String line, int keyData) {
        String[] columns;
        if (keyData == 0) {
            columns = line.split(",", 2);
            /*for (String column : columns) {
                System.out.println(column);
                for (int i = 0; i < column.length(); i++) {
                    System.out.print(column.charAt(i) + " ");
                }
                System.out.println();
            }
            System.out.println("^^^^_^^^^");*/
            if (columns[0].equals("Code")) {
                //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                return EMPTY;
            }
        } else {
            columns = line.split(",");
            /*System.out.println(columns[0]);
            System.out.println(columns[18]);
            System.out.println(columns[19]);*/
            if ((columns[0].equals("\"YEAR\"")) ||
                    (columns[19].equals("1.00")) ||
                    (columns[18].equals("0.00"))) {
                //System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
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
