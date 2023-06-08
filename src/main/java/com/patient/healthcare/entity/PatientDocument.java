package com.patient.healthcare.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient_document")
public class PatientDocument {
	@Id
	@Column(name="doc_id")
	private Integer docId;
	@Column(name = "patient_id")
	private Integer patientId;
	@Column(name="docs_name")
	private String docsName;
	@Column(name="docs_location")
	private String docsLocation;
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getDocsName() {
		return docsName;
	}
	public void setDocsName(String docsName) {
		this.docsName = docsName;
	}
	public String getDocsLocation() {
		return docsLocation;
	}
	public void setDocsLocation(String docsLocation) {
		this.docsLocation = docsLocation;
	}
	
}
