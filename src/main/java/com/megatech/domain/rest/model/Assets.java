package com.megatech.domain.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * This is our model class and it corresponds to Assets table in database
 */
@Entity
@Table(name = "ASSETS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Assets {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "assetId")
	long assetId;

	@Column(name = "tags")
	long tags;

	@Column(name = "tagValue")
	long tagValue;

	public Assets() {
		super();
	}

	public Assets(int id, long assetId, long tags, long tagValue) {
		super();
		this.id = id;
		this.assetId = assetId;
		this.tags = tags;
		this.tagValue = tagValue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public long getTags() {
		return tags;
	}

	public void setTags(long tags) {
		this.tags = tags;
	}

	public long getTagValue() {
		return tagValue;
	}

	public void setTagValue(long tagValue) {
		this.tagValue = tagValue;
	}

}