package com.ty.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sim {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int simId;
	private String provider;
	private String imrc;

	public int getSimId() {
		return simId;
	}

	public void setSimId(int simId) {
		this.simId = simId;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getImrc() {
		return imrc;
	}

	public void setImrc(String imrc) {
		this.imrc = imrc;
	}

	@Override
	public String toString() {
		return "Sim [simId=" + simId + ", provider=" + provider + ", imrc=" + imrc + "]";
	}

}
