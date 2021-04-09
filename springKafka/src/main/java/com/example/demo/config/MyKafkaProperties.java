package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mykafka")
public class MyKafkaProperties {
	private String bootstrapAddress;

	public String getBootstrapAddress() {
		return bootstrapAddress;
	}

	public void setBootstrapAddress(String bootstrapAddress) {
		this.bootstrapAddress = bootstrapAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bootstrapAddress == null) ? 0 : bootstrapAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyKafkaProperties other = (MyKafkaProperties) obj;
		if (bootstrapAddress == null) {
			if (other.bootstrapAddress != null)
				return false;
		} else if (!bootstrapAddress.equals(other.bootstrapAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyKafkaProperties [bootstrapAddress=" + bootstrapAddress + "]";
	}

	public MyKafkaProperties(String bootstrapAddress) {
		super();
		this.bootstrapAddress = bootstrapAddress;
	}

	public MyKafkaProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

}
