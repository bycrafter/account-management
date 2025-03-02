package com.bycrafter.core.accountmanagement.service.model;

public record UserAddRequestDto(String name, String surname, String email, String phone, String password) {
}
