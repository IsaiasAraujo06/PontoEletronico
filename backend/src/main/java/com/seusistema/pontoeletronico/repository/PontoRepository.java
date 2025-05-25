// Classe responsável pela comunicação com o banco de dados

public interface PontoRepository extends JpaRepository<RegistroPonto, Long> {
    
    List<RegistroPonto> findByUsuarioAndDataHoraBetween(
        Usuario usuario, 
        LocalDateTime inicio, 
        LocalDateTime fim);
}