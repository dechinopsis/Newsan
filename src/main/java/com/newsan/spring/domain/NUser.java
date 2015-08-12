package com.newsan.spring.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class NUser {
	@Id
	@GeneratedValue
	@Column(name = "IdUsuario")
	private int id;
	
	@Column(name = "Nombre")
	private String name;
	
	@Column(name = "Clave")
	private byte[] key;
	
	@Column(name = "FechaAcceso")
	private Date accessDate;
	
	@Column(name = "HoraAcceso")
	private String timeDate;
	
	@Column(name = "NivelAcceso")
	private int levelAccess;
	
	@Column(name = "FechaCaducidad")
	private Date dueDate;
	
	@Column(name = "TipoDefecto")
	private String defaultType;
	
	@Column(name = "Turno")
	private String turn;
	
	@Column(name = "TipoUnidad")
	private String unityType;
	
	@Column(name = "IdLinea")
	private int lineId;
	
	@Column(name = "Email")
	private String mail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getKey() {
		return key;
	}
	public void setKey(byte[] key) {
		this.key = key;
	}
	public Date getAccessDate() {
		return accessDate;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
	public String getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}
	public int getLevelAccess() {
		return levelAccess;
	}
	public void setLevelAccess(int levelAccess) {
		this.levelAccess = levelAccess;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getDefaultType() {
		return defaultType;
	}
	public void setDefaultType(String defaultType) {
		this.defaultType = defaultType;
	}
	public String getTurn() {
		return turn;
	}
	public void setTurn(String turn) {
		this.turn = turn;
	}
	public String getUnityType() {
		return unityType;
	}
	public void setUnityType(String unityType) {
		this.unityType = unityType;
	}
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
