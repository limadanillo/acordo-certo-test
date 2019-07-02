package br.com.acordo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "departamento_id", "nome" }) })
@Data
@Getter
@Builder
@EqualsAndHashCode(of = { "id" })
@AllArgsConstructor
@NoArgsConstructor
public class Empregado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "departamento_id", referencedColumnName = "id")
	private Departamento departamento;

	private Integer salario;

}
