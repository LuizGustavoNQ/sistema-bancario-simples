import model.Banco;
import model.Cliente;
import model.Conta;
import util.Menu;

public class Main {
    public static void main() {
        Banco banco = new Banco();

        Menu menu = new Menu();
        menu.selecionaOpcao();
    }
}
