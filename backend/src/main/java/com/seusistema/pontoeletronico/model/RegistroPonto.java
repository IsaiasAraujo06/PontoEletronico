@Entity
public class RegistroPonto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @Enumerated(EnumType.STRING)
    private TipoRegistro tipo;
    
    @Column(nullable = false)
    private LocalDateTime dataHora;
    
    // Getters, Setters, Constructors
}