@Service
public class PontoService {
    
    private final PontoRepository pontoRepository;
    private final UsuarioRepository usuarioRepository;
    
    public PontoResponse registrarPonto(String email, TipoRegistro tipo) {
        Usuario usuario = usuarioRepository.findByEmail(email)
            .orElseThrow(() -> new UsuarioNaoEncontradoException());
        
        RegistroPonto novoPonto = new RegistroPonto();
        novoPonto.setUsuario(usuario);
        novoPonto.setTipo(tipo);
        novoPonto.setDataHora(LocalDateTime.now());
        
        pontoRepository.save(novoPonto);
        
        return new PontoResponse(
            novoPonto.getId(),
            novoPonto.getTipo(),
            novoPonto.getDataHora()
        );
    }
}