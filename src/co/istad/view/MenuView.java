package co.istad.view;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MenuView {

    public static final String MENU[]                       = {
            "   *)Display   | W)rite    | R)ead     | U)pdate   | D)elete   | F)irst    | P)revious | N)ext | L)last   ",
            "   S)earch     | G)oto     | Se)t row  | H)elp     | E)xit"};

    public static void menu() {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);
        table.addCell(MENU[0], cellCenter);
        table.addCell(MENU[1], cellCenter);
        System.out.println(table.render());
    }

}
