/**
 * A interface RepositorioConstantes é a estrutura responsável pela definição de atributos para serem 
 * reutilizados pelas classes de controle.
 */
public interface RepositorioConstantes {
    // Array de objetos para armazenar os signos de zodíaco, com a data inicial e final
    public final SignoZodiaco[] signosZodiaco = {
        new SignoZodiaco("Áries", 21, 3, 20, 4),
        new SignoZodiaco("Touro", 21, 4, 20, 5),
        new SignoZodiaco("Gêmeos", 21, 5, 20, 6),
        new SignoZodiaco("Câncer", 21, 6, 22, 7),
        new SignoZodiaco("Leão", 23, 7, 22, 8),
        new SignoZodiaco("Virgem", 23, 8, 22, 9),
        new SignoZodiaco("Libra", 23, 9, 22, 10),
        new SignoZodiaco("Escorpião", 23, 10, 21, 11),
        new SignoZodiaco("Sagitário", 22, 11, 21, 12),
        new SignoZodiaco("Capricórnio", 22, 12, 20, 1),
        new SignoZodiaco("Aquário", 21, 1, 18, 2),
        new SignoZodiaco("Peixes", 19, 2, 20, 3),
    };
}
