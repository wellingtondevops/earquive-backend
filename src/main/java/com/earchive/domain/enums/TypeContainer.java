package com.earchive.domain.enums;

public enum TypeContainer {

	SIMPLEGUARD(1, "SIMPLE GUARD"), MANAGEDGUARD(2, "MANAGED GUARD");

	private int cod;
	private String description;

	private TypeContainer(int cod, String description) {
		this.cod = cod;
		this.description = description;

	}

	public int getCod() {

		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static TypeContainer toEnum(Integer cod) {

		if (cod == null) {
			return null;

		}

		for (TypeContainer x : TypeContainer.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("I invalid: " + cod);

	}

}
