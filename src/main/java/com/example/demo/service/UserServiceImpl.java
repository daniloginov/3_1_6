package com.example.demo.service;

import com.example.demo.model.UserEntity;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class UserServiceImpl implements UserService {
    private final String baseUrl = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate = new RestTemplate();
    private final HttpHeaders headers = new HttpHeaders();

    public UserServiceImpl() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public void getAllUsers() {
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                request,
                String.class);
        headers.set("Cookie", getSessionId(response));
    }

    @Override
    public ResponseEntity<String> addUser(UserEntity user) {
        HttpEntity<UserEntity> request = new HttpEntity<>(user, headers);
        return restTemplate.exchange(
                baseUrl,
                HttpMethod.POST,
                request,
                String.class);
    }

    @Override
    public ResponseEntity<String> updateUser(UserEntity user) {
        HttpEntity<UserEntity> request = new HttpEntity<>(user, headers);
        return restTemplate.exchange(
                baseUrl,
                HttpMethod.PUT,
                request,
                String.class);
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        HttpEntity<String> request = new HttpEntity<>(headers);
        return restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.DELETE,
                request,
                String.class);
    }

    private String getSessionId(ResponseEntity<String> response) {
        return response.getHeaders()
                .getFirst(HttpHeaders.SET_COOKIE);
    }
}
