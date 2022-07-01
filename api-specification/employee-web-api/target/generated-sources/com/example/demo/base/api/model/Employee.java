package com.example.demo.base.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is the Employee model.
 */
@ApiModel(description = "This is the Employee model.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Employee  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("salary")
  private Integer salary;

  public Employee id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of Employee.
   * @return id
  */
  @ApiModelProperty(value = "The ID of Employee.")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employee name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The Name of Employee.
   * @return name
  */
  @ApiModelProperty(value = "The Name of Employee.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee salary(Integer salary) {
    this.salary = salary;
    return this;
  }

  /**
   * The salary of Employee.
   * @return salary
  */
  @ApiModelProperty(value = "The salary of Employee.")


  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.name, employee.name) &&
        Objects.equals(this.salary, employee.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, salary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    salary: ").append(toIndentedString(salary)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

