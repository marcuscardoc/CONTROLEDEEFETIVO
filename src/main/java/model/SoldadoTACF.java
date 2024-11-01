package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class SoldadoTACF {
	private Integer id;
	private StringProperty data1etapa = new SimpleStringProperty();
	private StringProperty data2etapa = new SimpleStringProperty();
	private StringProperty realizado1etapa = new SimpleStringProperty();
	private StringProperty realizado2etapa = new SimpleStringProperty();
	 	
	SoldadoTACF(){}

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    //ID
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer soldadoId) {
		this.id = soldadoId;
	}

@ManyToOne
@JoinColumn(name = "soldado_id", nullable = false)
   //SOLDADO
   private Soldado soldado;

@Column(name = "DATA1ETAPA")
   // DATA 1 ETAPA
   public String getData1Etapa() {
	     return data1etapa.get();
}

public void setData1Etapa(String data1etapa) {
	this.data1etapa.set(data1etapa);
}

public StringProperty Data1EtapaProperty() {
	return data1etapa;
}

@Column(name = "DATA2ETAPA")
// NOME
public String getData2Etapa() {
	return data2etapa.get();
}

public void setData2Etapa(String data2etapa) {
	this.data2etapa.set(data2etapa);
}

public StringProperty Data2EtapaProperty() {
	return data2etapa;
}

@Column(name = "REALIZADO1ETAPA")
// NOME
public String getRealizado1Etapa() {
	return realizado1etapa.get();
}

public void setRealizado1Etapa(String realizado1etapa) {
	this.realizado1etapa.set(realizado1etapa);
}

public StringProperty Realizado1EtapaProperty() {
	return realizado1etapa;
}

@Column(name = "REALIZADO2ETAPA")
// NOME
public String getRealizado2Etapa() {
	return realizado2etapa.get();
}

public void setRealizado2Etapa(String realizado2etapa) {
	this.realizado2etapa.set(realizado2etapa);
}

public StringProperty Realizado2EtapaProperty() {
	return realizado2etapa;
}


}
