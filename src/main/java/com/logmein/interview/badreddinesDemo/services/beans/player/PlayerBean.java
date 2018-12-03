package com.logmein.interview.badreddinesDemo.services.beans.player;

import org.springframework.util.Assert;

public class PlayerBean implements Comparable<PlayerBean> {
	private final Integer id;
	private final Long value;

	public PlayerBean(Integer id, Long value) {
		super();
		Assert.notNull(id, "[Assertion failed] - 'id' argument is required; it must not be null");
		Assert.notNull(value, "[Assertion failed] - 'value' argument is required; it must not be null");
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public Long getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PlayerBean other = (PlayerBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(PlayerBean o) {
		return this.value.compareTo(o.value);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlayerBean [id=");
		builder.append(id);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
