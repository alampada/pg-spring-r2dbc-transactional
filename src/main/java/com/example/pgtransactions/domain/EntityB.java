package com.example.pgtransactions.domain;

import lombok.Builder;
import lombok.Value;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Builder
@Table("b")
public class EntityB {

	@Id
	Integer id;

	String name;

}
