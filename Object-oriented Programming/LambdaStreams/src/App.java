import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
         List<Pessoa> lista = Arrays.asList(
                new Pessoa(1, "Huguinho", Departamento.FINANCEIRO, 40),
                new Pessoa(4, "Zezinho", Departamento.FINANCEIRO, 32),
                new Pessoa(3, "Luizinho", Departamento.VENDAS, 57),
                new  Pessoa(9, "Patinhas",   Departamento.VENDAS, 40),
                new Pessoa(10, "Donald", Departamento.GERENCIA, 54),
                new Pessoa(2, "Margarida", Departamento.FINANCEIRO, 40),
                new Pessoa(8, "Joe Doe", Departamento.VENDAS, 34),
                new Pessoa(5, "Jane Doe", Departamento.VENDAS, 22),
                new Pessoa(6, "Sr Smith", Departamento.VENDAS, 40),
                new Pessoa(7, "Sra Smith", Departamento.GERENCIA, 39),
                 new Pessoa(11, "Trinity", Departamento.VENDAS, 34),
                 new Pessoa(14, "Morpheus", Departamento.FINANCEIRO, 22),
                 new Pessoa(16, "AgenteSmith", Departamento.VENDAS, 47),
                 new Pessoa(13, "Neo", Departamento.GERENCIA, 29)
        );

        /***
         * Exercício
         *      - escreva as consultas solicitadas utilizando
         *        apenas expressões lambda e operações de agregação
          */
        System.out.println("1. Funcionários do setor de vendas:\n");

        lista
            .stream()
            .filter(f -> f.getDpto() == Departamento.VENDAS)
            .forEach(f -> System.out.println(f));

        System.out.println("\n2. Funcionários do setor de vendas com idade entre 20 e 30 anos\n");

        lista
            .stream()
            .filter(f -> f.getDpto() == Departamento.VENDAS && f.getIdade() > 20 && f.getIdade() < 30)
            .forEach(f -> System.out.println(f));

        System.out.println("\n3. Nomes (em maiúsculas) dos funcionários do setor de vendas (usando reduce)\n");
        
        System.out.println(
            lista
                .stream()
                .filter(f -> f.getDpto() == Departamento.VENDAS)
                .map(f -> f.getNome().toUpperCase())
                .reduce("", (n1, n2) -> {
                    if (!"".equals(n1)) {
                        return n1 + " - " + n2;
                    } else {
                        return n2;
                    }
                })
        );

        System.out.println("\n4. Todos os gerentes:\n");

        lista
            .stream()
            .filter(f -> f.getDpto() == Departamento.GERENCIA)
            .forEach(f -> System.out.println(f));

        System.out.println("\n5. Idade média dos gerentes:\n");

        lista
            .stream()
            .filter(f -> f.getDpto() == Departamento.GERENCIA)
            .mapToInt(f -> f.getIdade())
            .average()
            .ifPresent(avg -> System.out.printf("%.2f\n", avg));

        System.out.println("\n6. Funcionarios ordenados pelo código:\n");

        lista
            .stream()
            .sorted(Comparator.comparingInt(Pessoa::getCodigo))
            .forEach(f -> System.out.println(f));

        System.out.println("\n7. Funcionários ordenados pela idade+nome:\n");

        lista
            .stream()
            .sorted(Comparator.comparingInt(Pessoa::getIdade).thenComparing(Pessoa::getNome))
            .forEach(f -> System.out.println(f));

        System.out.println("\n8. Criar uma nova lista apenas com os funcionarios do financeiro:\n");

        System.out.println(
            lista
                .stream()
                .filter(f -> f.getDpto() == Departamento.FINANCEIRO)
                .collect(Collectors.toList())
        );

        System.out.println("\n9. Nome e setor da pessoa mais jovem:\n");

        lista
            .stream()
            .min(Comparator.comparingInt(Pessoa::getIdade))
            .ifPresent(f -> System.out.println(f.getNome() + " " + f.getDpto()));
    }
}
