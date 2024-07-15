package com.example.swp_jewelryproductionordersystem.exception;

import javax.security.sasl.AuthenticationException;

public class AuthenticationFailureException extends AuthenticationException {
    public AuthenticationFailureException(String message) { super(message);}
}
