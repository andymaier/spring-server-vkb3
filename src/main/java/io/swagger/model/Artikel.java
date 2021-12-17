package io.swagger.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Artikel
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-17T14:30:37.141Z[GMT]")
@Entity

public class Artikel   {

 @Id
@GeneratedValue(strategy = GenerationType.AUTO)   
  private UUID id;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("preis")
  private BigDecimal preis = null;

  public Artikel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Dies ist der Name des Artikels
   * @return name
   **/
  @Schema(example = "HansWurst", description = "Dies ist der Name des Artikels")
  
  @Size(max=20)   public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Artikel preis(BigDecimal preis) {
    this.preis = preis;
    return this;
  }

  /**
   * Dies ist der Preis des Artikels
   * minimum: 0
   * @return preis
   **/
  @Schema(example = "3.99", description = "Dies ist der Preis des Artikels")
  
    @Valid
  @DecimalMin("0")  public BigDecimal getPreis() {
    return preis;
  }

  public void setPreis(BigDecimal preis) {
    this.preis = preis;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artikel artikel = (Artikel) o;
    return Objects.equals(this.name, artikel.name) &&
        Objects.equals(this.preis, artikel.preis);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, preis);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Artikel {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    preis: ").append(toIndentedString(preis)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
