// Essa classe puxa o nome de usuário e o tipo de registro que foi feito no ponto


@RestController
@RequestMapping("/api/ponto")
public class PontoController {
    
    private final PontoService pontoService;
    
    @PostMapping
    public ResponseEntity<PontoResponse> registrarPonto(
        @RequestBody RegistroPontoRequest request,
        @AuthenticationPrincipal UserDetails userDetails) {
        
        PontoResponse response = pontoService.registrarPonto(
            userDetails.getUsername(), 
            request.getTipo()
        );
        return ResponseEntity.ok(response);
    }
}