package com.tomholmes.opensource.phonebook.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PositionDTO implements Serializable
{
    private Long positionId;
    private Boolean active;
    private String positionCode;
    private String description;

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
