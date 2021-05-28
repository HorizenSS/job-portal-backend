package com.ines.models;

 import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "files")
public class FileDB {
  @Id
  private String id;

  private String name;
  private String jobid;
  private String type;

  private byte[] data;

  public FileDB() {
  }

  public String getJobid() {
    return jobid;
  }

  public void setJobid(String jobid) {
    this.jobid = jobid;
  }

  public FileDB(String name,String type, byte[] data,String jobid) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.jobid= jobid;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}
