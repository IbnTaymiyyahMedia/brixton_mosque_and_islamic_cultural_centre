package com.example.stripe.model;

import java.util.List;

import org.springframework.data.annotation.Id;


public class MSProduct {
	
	@Id
	private long id;
	private String category;
	private Boolean active;
	private String statementDescriptor;
	private Long created;
	private Boolean deleted;
	private String description;
	private String productId;
	private String type;
	private Boolean livemode;
	private String image;
	private Boolean shippable;
	private String name;
	private Long updated;
	private String unitLabel;
	private String url;
	private String taxBehavior;
	private String tiersMode;
	private String nickname;
	private String lookupKey;
	private String currency;
	private String billingScheme;
	private Long unitAmount;
	
	private String priceId;

	public Long getUnitAmount() {
		return unitAmount;
	}

	public String getPriceId() {
		return priceId;
	}

	public Boolean getActive() {
		return active;
	}

	public String getStatementDescriptor() {
		return statementDescriptor;
	}

	public Long getCreated() {
		return created;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Boolean getLivemode() {
		return livemode;
	}

	public String getImage() {
		return image;
	}

	public Boolean getShippable() {
		return shippable;
	}

	public String getName() {
		return name;
	}

	public Long getUpdated() {
		return updated;
	}

	public String getUnitLabel() {
		return unitLabel;
	}

	public String getUrl() {
		return url;
	}

	public void setActive(Boolean active) {
		// TODO Auto-generated method stub
		this.active = active;
	}

	public void setStatementDescriptor(String statementDescriptor) {
		// TODO Auto-generated method stub
		this.statementDescriptor = statementDescriptor;
	}

	public void setCreated(Long created) {
		// TODO Auto-generated method stub
		this.created = created;
	}

	public void setDeleted(Boolean deleted) {
		// TODO Auto-generated method stub
		this.deleted = deleted;
	}

	public void setDescription(String description) {
		// TODO Auto-generated method stub
		this.description = description;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}

	public void setLivemode(Boolean livemode) {
		// TODO Auto-generated method stub
		this.livemode = livemode;
	}

	public void setImage(String image) {
		// TODO Auto-generated method stub
		this.image = image;
	}

	public void setShippable(Boolean shippable) {
		// TODO Auto-generated method stub
		this.shippable = shippable;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public void setUnitLabel(String unitLabel) {
		// TODO Auto-generated method stub
		this.unitLabel = unitLabel;
	}

	public void setUpdated(Long updated) {
		// TODO Auto-generated method stub
		this.updated = updated;
	}

	public void setUrl(String url) {
		// TODO Auto-generated method stub
		this.url = url;
	}

	public void setBillingScheme(String billingScheme) {
		// TODO Auto-generated method stub
		this.billingScheme = billingScheme;
	}

	public String getTaxBehavior() {
		return taxBehavior;
	}

	public String getTiersMode() {
		return tiersMode;
	}

	public String getNickname() {
		return nickname;
	}

	public String getLookupKey() {
		return lookupKey;
	}

	public String getCurrency() {
		return currency;
	}

	public String getBillingScheme() {
		return billingScheme;
	}

	public void setCurrency(String currency) {
		// TODO Auto-generated method stub
		this.currency = currency;
	}

	public void setLookupKey(String lookupKey) {
		// TODO Auto-generated method stub
		this.lookupKey = lookupKey;
	}

	public void setNickname(String nickname) {
		// TODO Auto-generated method stub
		this.nickname = nickname;
	}

	public void setTaxBehavior(String taxBehavior) {
		// TODO Auto-generated method stub
		this.taxBehavior = taxBehavior;
	}

	public void setTiersMode(String tiersMode) {
		// TODO Auto-generated method stub
		this.tiersMode = tiersMode;
	}

	public void setUnitAmount(Long unitAmount) {
		// TODO Auto-generated method stub
		this.unitAmount = unitAmount;
	}

	

	public void setPriceId(String priceId) {
		// TODO Auto-generated method stub
		this.priceId = priceId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
