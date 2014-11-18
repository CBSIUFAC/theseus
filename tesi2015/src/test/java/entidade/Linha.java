package entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Linha implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLinha;
	
	private String descricao;
	
	@OneToMany(mappedBy = "linha")
	private List<Onibus> onibus;

	public Integer getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(Integer idLinha) {
		this.idLinha = idLinha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Onibus> getOnibus() {
		return onibus;
	}

	public void setOnibus(List<Onibus> onibus) {
		this.onibus = onibus;
	}
	
}
