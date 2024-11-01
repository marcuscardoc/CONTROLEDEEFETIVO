package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class SoldadoDispMedica {
	private Integer id;
	private StringProperty nome = new SimpleStringProperty();
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	private StringProperty apartirDe = new SimpleStringProperty();
	private StringProperty tipoDeDispensa = new SimpleStringProperty();
	private StringProperty cid = new SimpleStringProperty();
	private StringProperty nomeMedico = new SimpleStringProperty();

	public SoldadoDispMedica() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ID
	public Integer getId() {
		return id;
	}

	public void setId(Integer soldadoDispMedicaId) {
		this.id = soldadoDispMedicaId;
	}

	@Column(name = "Nome")
	// NOME
	public String getNome() {
		return nome.get();
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

	@Column(name = "Quantidade")
	// QUANTIDADE
	public Integer getQuantidade() {
		return quantidade.get();
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade.set(quantidade);
	}

	@Column(name = "ApartirDe")
	// A PARTIR DE
	public String getApartirDe() {
		return apartirDe.get();
	}

	public void setApartirDe(String apartirDe) {
		this.apartirDe.set(apartirDe);
	}

	@Column(name = "TipoDeDispensa")
	// TIPO DE DISPENSA
	public String getTipoDeDispensa() {
		return tipoDeDispensa.get();
	}

	public void setTipoDeDispensa(String tipoDeDispensa) {
		this.tipoDeDispensa.set(tipoDeDispensa);
	}

	@Column(name = "cid")
	// CID
	public String getCid() {
		return cid.get();
	}

	public void setCid(String cid) {
		this.cid.set(cid);
	}

	@Column(name = "NomeMedico")
	// NOME MEDICO
	public String getNomeMedico() {
		return nomeMedico.get();
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico.set(nomeMedico);
	}
}
