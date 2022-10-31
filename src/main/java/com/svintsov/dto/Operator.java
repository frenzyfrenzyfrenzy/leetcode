package com.svintsov.dto;

public interface Operator {

    Integer getPrecedence();

    Associativity getAssociativity();

}
