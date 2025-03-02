package com.bycrafter.core.accountmanagement.service.model;

public record UpdateUserRequestDto(String id, String name, String surname, String email, String phone, String password) {
}
