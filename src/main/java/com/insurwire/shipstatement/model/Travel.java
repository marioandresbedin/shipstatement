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
	@Column(name = "travel_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	@Column(name = "transporttype_id")
	@NotNull(message = "Select Transport Type!")
	private Integer transportTypeId;

	public Integer getTransportTypeId() {
		return transportTypeId;
	}

	public void setTransportTypeId(Integer transportTypeId) {
		this.transportTypeId = transportTypeId;
	}

	@Column(name = "port_id")
	@NotNull(message = "Select Port!")
	private Integer portId;

	public Integer getPortId() {
		return portId;
	}

	public void setPortId(Integer portId) {
		this.portId = portId;
	}

	@NotEmpty(message = "Empty transport can't be empty!")
	@Column(name = "empty_transport")
	private String emptyTransport;

	public String getEmptyTransport() {
		return emptyTransport;
	}

	public void setEmptyTransport(String emptyTransport) {
		this.emptyTransport = emptyTransport;
	}

	@NotEmpty(message = "Load on Board transport can't be empty!")
	@Column(name = "load_on_board")
	private String loadOnBoard;

	public String getLoadOnBoard() {
		return loadOnBoard;
	}

	public void setLoadOnBoard(String loadOnBoard) {
		this.loadOnBoard = loadOnBoard;
	}

	@Column(name = "travel_start_date")
	private java.sql.Date travelStartDate;

	public java.sql.Date getTravelStartDate() {
		return travelStartDate;
	}

	public void setTravelStartDate(java.sql.Date travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	@Column(name = "travel_end_date")
	private java.sql.Date travelEndDate;

	public java.sql.Date getTravelEndDate() {
		return travelEndDate;
	}

	public void setTravelEndDate(java.sql.Date travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	
	@Column(name = "travel_arrival_date")
	private java.sql.Date travelArrivalDate;

	public java.sql.Date getTravelArrivalDate() {
		return travelArrivalDate;
	}

	public void setTravelArrivalDate(java.sql.Date travelArrivalDate) {
		this.travelArrivalDate = travelArrivalDate;
	}

	@Column(name = "transport_country_id")
	@NotNull(message = "Select Transport country!")
	private Integer transportCountryId;

	public Integer getTransportCountryId() {
		return transportCountryId;
	}

	public void setTransportCountryId(Integer transportCountryId) {
		this.transportCountryId = transportCountryId;
	}

	@Column(name = "transport_type_country_id")
	@NotNull(message = "Select Transport Type country!")
	private Integer transportTypeCountryId;

	public Integer getTransportTypeCountryId() {
		return transportTypeCountryId;
	}

	public void setTransportTypeCountryId(Integer transportTypeCountryId) {
		this.transportTypeCountryId = transportTypeCountryId;
	}

	@NotEmpty(message = "Assigned person can't be empty!")
	@Column(name = "assigned_person")
	private String assignedPerson;

	public String getAssignedPerson() {
		return assignedPerson;
	}

	public void setAssignedPerson(String assignedPerson) {
		this.assignedPerson = assignedPerson;
	}

	@NotEmpty(message = "Customs can't be empty!")
	@Column(name = "customs")
	private String customs;

	public String getCustoms() {
		return customs;
	}

	public void setCustoms(String customs) {
		this.customs = customs;
	}

	@Column(name = "captain_country_id")
	@NotNull(message = "Select Transport Type country!")
	private Integer captainCountryId;

	public Integer getCaptainCountryId() {
		return captainCountryId;
	}

	public void setCaptainCountryId(Integer captainCountryId) {
		this.captainCountryId = captainCountryId;
	}

	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
