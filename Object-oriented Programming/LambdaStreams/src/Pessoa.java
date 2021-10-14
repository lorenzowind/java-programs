public class Pessoa {
    private int codigo;
    private String nome;
    private Departamento dpto;
    private int idade;

    public Pessoa(int umCodigo, String umNome, Departamento umDpto, int umaIdade) {
        codigo = umCodigo;
        nome = umNome;
        dpto = umDpto;
        idade = umaIdade;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDpto() {
        return dpto;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", dpto=" + dpto +
                ", idade=" + idade +
                '}';
    }
}
