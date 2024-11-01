package main.java.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Observacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObs;

    @ManyToOne
    @JoinColumn(name = "soldado_id", nullable = false)
    private Soldado soldado;

    private LocalDate data;
    private String observacao;
    
    
    //SOLDADO
    public Soldado getSoldado() {
		return soldado;
	}
    
	public void setSoldado(Soldado soldado) {
		this.soldado = soldado;
	}
	
	//ID
	public Integer getId() {
		return idObs;
	}
	
	public void setId(Integer id) {
		this.idObs = id;
	}
	
	//DATA
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	//TEXT OBS
	public String getTextObs() {
		return observacao;
	}
	
	public void setTextObs(String textObs) {
		this.observacao = textObs;
	}

	
    
    
}
