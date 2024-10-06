package estudando.api;

public class Aplicacao {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            viaCep viaCep = new viaCep();
            Endereco endereco = viaCep.getLocalidade("54220040");
            System.out.println(endereco);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}