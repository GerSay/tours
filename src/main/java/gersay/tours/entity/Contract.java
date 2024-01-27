package gersay.tours.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;
}
