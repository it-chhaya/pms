package co.istad.view;

import co.istad.model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class ProductView {

    public static void viewCreateProduct(Product product, Scanner scanner) {
        out.print("Enter name: ");
        product.setName(scanner.nextLine());
        out.print("Enter qty: ");
        product.setQty(Integer.parseInt(scanner.nextLine()));
        out.print("Enter unit price: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
    }

    public static void viewProductList(List<Product> products) {

        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle cellCenter = new CellStyle(CellStyle.HorizontalAlign.center);

        String[] headers = {"ID", "NAME", "Qty", "Unit Price","Imported Date"};

        for (String header: headers) {
            table.addCell(header, cellCenter);
        }

        products.forEach(product -> {
            table.addCell(product.getId().toString(), cellCenter);
            table.addCell(product.getName(), cellCenter);
            table.addCell(product.getQty().toString(), cellCenter);
            table.addCell(product.getPrice().toString(), cellCenter);
            table.addCell(product.getImportedDate().toString(), cellCenter);
        });

        out.println(table.render());
    }

}
