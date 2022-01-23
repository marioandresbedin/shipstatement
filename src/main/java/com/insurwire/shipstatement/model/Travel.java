package com.insurwire.shipstatement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "travel")
public class Travel {

	protected Travel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Travel number can't be empty!")
	@Column(name = "travel_code")
	private String travelCode;

	public String getTravelCode() {
		return this.travelCode;
	}

	public void setTravelCode(String travelCode) {
		this.travelCode = travelCode;
	}

	
    @Column(name = "country_id")
    @NotNull(message = "Select country!")
    private Integer countryId;

    @Column(name = "transporttype_id")
    @NotNull(message = "Select Transport Type!")
    private Integer transportTypeId;
    
    @Column(name = "port_id")
    @NotNull(message = "Select Port!")
    private Integer portId;
	

}
