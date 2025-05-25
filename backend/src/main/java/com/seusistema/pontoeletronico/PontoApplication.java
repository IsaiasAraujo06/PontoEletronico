//Classe que inicia a aplicação;

@SpringBootApplication
public class PontoApplication { //Declara a classe
    public static void main(String[] args) { //método principal da classe
        SpringApplication.run(PontoApplication.class, args); // objeto da classe (instância indireta, pelo uso do Spring)
    }
}

//Essa classe inicia a aplicação, e cria e gerencia outros objetos do sistema através do Spring. Foi utilizado o modificador "public" para que essa classe consiga criar e gerenciar as outras, através da visibilidade em todas as classes e pacotes do projeto.   