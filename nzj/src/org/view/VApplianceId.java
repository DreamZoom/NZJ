package org.view;

/**
 * VApplianceId entity. @author MyEclipse Persistence Tools
 */

public class VApplianceId implements java.io.Serializable {

	// Fields

	private Long id;
	private Long auntId;
	private Long applianceId;
	private String name;

	// Constructors

	/** default constructor */
	public VApplianceId() {
	}

	/** full constructor */
	public VApplianceId(Long id, Long auntId, Long applianceId, String name) {
		this.id = id;
		this.auntId = auntId;
		this.applianceId = applianceId;
		this.name = name;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAuntId() {
		return this.auntId;
	}

	public void setAuntId(Long auntId) {
		this.auntId = auntId;
	}

	public Long getApplianceId() {
		return this.applianceId;
	}

	public void setApplianceId(Long applianceId) {
		this.applianceId = applianceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VApplianceId))
			return false;
		VApplianceId castOther = (VApplianceId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getAuntId() == castOther.getAuntId()) || (this
						.getAuntId() != null && castOther.getAuntId() != null && this
						.getAuntId().equals(castOther.getAuntId())))
				&& ((this.getApplianceId() == castOther.getApplianceId()) || (this
						.getApplianceId() != null
						&& castOther.getApplianceId() != null && this
						.getApplianceId().equals(castOther.getApplianceId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getAuntId() == null ? 0 : this.getAuntId().hashCode());
		result = 37
				* result
				+ (getApplianceId() == null ? 0 : this.getApplianceId()
						.hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

}