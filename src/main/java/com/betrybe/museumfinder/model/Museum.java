package com.betrybe.museumfinder.model;

/**
 * The type Museum.
 */
public class Museum {
  private Long id;
  private String name;
  private String description;
  private String address;
  private String collectionType;
  private String subject;
  private String url;
  private Coordinate coordinate;
  private Long legacyId;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets collection type.
   *
   * @return the collection type
   */
  public String getCollectionType() {
    return collectionType;
  }

  /**
   * Gets subject.
   *
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Gets url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets coordinate.
   *
   * @return the coordinate
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * Gets legacy id.
   *
   * @return the legacy id
   */
  public Long getLegacyId() {
    return legacyId;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Sets collection type.
   *
   * @param collectionType the collection type
   */
  public void setCollectionType(String collectionType) {
    this.collectionType = collectionType;
  }

  /**
   * Sets subject.
   *
   * @param subject the subject
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Sets url.
   *
   * @param url the url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Sets coordinate.
   *
   * @param coordinate the coordinate
   */
  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  /**
   * Sets legacy id.
   *
   * @param legacyId the legacy id
   */
  public void setLegacyId(Long legacyId) {
    this.legacyId = legacyId;
  }
}
