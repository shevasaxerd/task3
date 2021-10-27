import com.inamik.text.tables.Cell;
import com.inamik.text.tables.GridTable;
import com.inamik.text.tables.grid.Border;
import com.inamik.text.tables.grid.Util;

public class Table {
    void createTable(String[] args) {
        Func algorithm = new Func();
        GridTable table = GridTable.of(args.length + 1, args.length + 1);
        for (int i = 1; i <= args.length; i++) {
            for (int k = 1; k <= args.length; k++) {
                if (k == 1) {
                    table.put(i, 0, Cell.of(args[i - 1]));
                }
                if (i == 1) {
                    table.put(0, k, Cell.of(args[k - 1]));
                }
                int q = algorithm.func(i - 1, k - 1, args.length);
                if ( i-1 != k-1) {
                    if (q == 0) {
                        table.put(i, k, Cell.of("lose"));
                    } else {
                        table.put(i, k, Cell.of("win"));
                    }
                }
                else {
                    table.put(i, k, Cell.of("draw"));
                }
            }
        }
        System.out.println("Table of winners:");
        Util.print(Border.DOUBLE_LINE.apply(table));
    }
}