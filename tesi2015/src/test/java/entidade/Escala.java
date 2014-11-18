package entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Escala implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEscala;
	
	@OneToMany(mappedBy = "escala")
	private List<ItemEscala> itensEscala;
	
	public Integer getIdEscala() {
		return idEscala;
	}
	
	public void setIdEscala(Integer idEscala) {
		this.idEscala = idEscala;
	}
	
	public List<ItemEscala> getItensEscala() {
		return itensEscala;
	}
	
	public void setItensEscala(List<ItemEscala> itensEscala) {
		this.itensEscala = itensEscala;
	}
	
}
