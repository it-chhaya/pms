package co.istad.view;

public class MainView {
    public static void logoHeader() {
        System.out.println(" ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝ ");
    }
    public static final String HELP[][] = {
            {"1." , "* : Display all record of products"},
            {"2." , "w : Add new product"},
            {"  " , "w ->#proname-unitprice-qty : sortcut for add new product"},
            {"3." , "r : read Content any content"},
            {"  " , "r#proId : shortcut for read product by Id"},
            {"4." , "u : Update Data"},
            {"5." , "d : Delete Data"},
            {"  " , "d#proId : shortcut for delete product by Id"},
            {"6." , "f : Display First Page"},
            {"7." , "p : Display Previous Page"},
            {"8." , "n : Display Next Page"},
            {"9." , "l : Display last page"},
            {"10." , "s : Search product by name"},
            {"11." , "h : Help"}
    };
    }
