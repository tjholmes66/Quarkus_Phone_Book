package com.tomholmes.opensource.phonebook.dto;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;

@SuppressWarnings("serial")
@ApplicationScoped
public class SuffixDTO implements Serializable
{
    private Long suffixId;
    private Boolean suffixName;
    private Boolean active;

    public Long getSuffixId() {
        return suffixId;
    }

    public void setSuffixId(Long suffixId) {
        this.suffixId = suffixId;
    }

    public Boolean getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(Boolean suffixName) {
        this.suffixName = suffixName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
