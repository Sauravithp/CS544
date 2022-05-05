package com.example.exercise16_1.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class AccountEntry {
	
	private Date date;
	private double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	
}
