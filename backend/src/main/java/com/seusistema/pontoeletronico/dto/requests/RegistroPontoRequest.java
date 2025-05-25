// Padroniza os tipos de dados como STRINGs


public class RegistroPontoRequest {
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TipoRegistro tipo; // ENUM: ENTRADA, SAIDA
    
    // Getters e Setters
}