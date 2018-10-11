package com.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "attribute_id")
  private int id;

  private String mode;

  private Double value;

  private Date fetchDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Date getFetchDate() {
    return fetchDate;
  }

  public void setFetchDate(Date fetchDate) {
    this.fetchDate = fetchDate;
  }

  @Override
  public String toString() {
    return "CurrencyDetails [id=" + id + ", mode=" + mode + ", value=" + value + ", fetchDate="
        + fetchDate + "]";
  }

}
