// --- AuthRequest.java ---
package com.example.gestiontaches.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}