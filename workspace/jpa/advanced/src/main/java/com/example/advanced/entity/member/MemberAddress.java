package com.example.advanced.entity.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
public class MemberAddress {

    private String memberAddress;
    private String memberAddressDetail;
    private String memberPostcode;

}
