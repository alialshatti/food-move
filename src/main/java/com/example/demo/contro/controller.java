package com.example.demo.contro;

import com.example.demo.entity.DoraSample;
import com.example.demo.repo.rpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    @Autowired
    rpo rpo;

    @Autowired
    RestTemplate restTemplate;

    private String url = "http://65.108.218.198:8089/api/settings/sample/addR";

    @PostMapping
    public ResponseEntity<List<Long>> test() {
        List<DoraSample> sample = rpo.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoic3VwZXIgYWRtaW4iLCJjbGFpbXMiOlsiUm9sZS5WaWV3IiwiUm9sZS5BZGRFZGl0IiwiUm9sZS5EaXNhYmxlRW5hYmxlIiwiVXNlci5WaWV3IiwiVXNlci5BZGRFZGl0IiwiVXNlci5EaXNhYmxlRW5hYmxlIiwiU2FtcGxpbmdTaXRlcy5WaWV3IiwiU2FtcGxpbmdTaXRlcy5BZGRFZGl0IiwiU2FtcGxpbmdTaXRlcy5EaXNhYmxlRW5hYmxlIiwiTGFicy5WaWV3IiwiTGFicy5BZGRFZGl0IiwiTGFicy5EaXNhYmxlRW5hYmxlIiwiU2FtcGxlcy5WaWV3IiwiU2FtcGxlcy5BZGRFZGl0IiwiU2FtcGxlcy5EaXNhYmxlRW5hYmxlIiwiU2FtcGxlcy5EZWxldGUiLCJSZWNvcmRzLlZpZXciLCJCYXJjb2RlLkFkZCIsIlRyYW5zYWN0aW9ucy5WaWV3IiwiVHJhbnNhY3Rpb25zLkRpc2FibGVFbmFibGUiLCJUcmFuc2FjdGlvbnMuQWRkRWRpdCIsIlNhbXBsZVR5cGVzLlZpZXciLCJTYW1wbGVUeXBlcy5BZGRFZGl0IiwiU2FtcGxlVHlwZXMuRGlzYWJsZUVuYWJsZSIsIkxhYlJlcG9ydEZvcm0uVmlldyIsIkZvb2RTYW1wbGVGb3JtLlZpZXciXSwidXNlcm5hbWUiOiJzdXBlclVzZXIiLCJzdWIiOiJzdXBlclVzZXIiLCJpYXQiOjE3MDcwMTAxMTEsImV4cCI6MTc5MzQxMDExMX0.c8ednx4HRUUR9jpXNb4e5qV6Qxl7Pfa-CkbeNLi74JY");
        List<Long> notInserted = new ArrayList<>();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        for (DoraSample s : sample) {
            try {
                HttpEntity<DoraSample> requestEntity = new HttpEntity<>(s, headers);
                restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);

            } catch (Exception e) {
                // Handle the exception (e.g., log it)
                notInserted.add(s.getId());
                ResponseEntity.ok().body(notInserted);
            }
        }
        Long size = (long) notInserted.size();
        notInserted.add(size);
        return ResponseEntity.ok().body(notInserted);

    }
}
