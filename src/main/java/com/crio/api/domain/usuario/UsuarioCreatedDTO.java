package com.crio.api.domain.usuario;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

public record UsuarioCreatedDTO(
        LocalDateTime createdAt,
        LocalDateTime end) {

        }


