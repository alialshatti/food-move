package com.example.demo.contro;

import com.example.demo.entity.Attachment;
import com.example.demo.entity.DoraSample;
import com.example.demo.repo.AttachRepo;
import com.example.demo.repo.rpo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    @Autowired
    rpo rpo;
    @Autowired
    AttachRepo attachRepo;

    @Autowired
    RestTemplate restTemplate;

    private String url = "http://65.108.218.198:8089/api/settings/sample/addR";

    @PostMapping
    public ResponseEntity<List<Long>> test() {
        List<DoraSample> sample = rpo.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoic3VwZXIgYWRtaW4iLCJjbGFpbXMiOlsiUm9sZS5WaWV3IiwiUm9sZS5BZGRFZGl0IiwiUm9sZS5EaXNhYmxlRW5hYmxlIiwiVXNlci5WaWV3IiwiVXNlci5BZGRFZGl0IiwiVXNlci5EaXNhYmxlRW5hYmxlIiwiU2FtcGxpbmdTaXRlcy5WaWV3IiwiU2FtcGxpbmdTaXRlcy5BZGRFZGl0IiwiU2FtcGxpbmdTaXRlcy5EaXNhYmxlRW5hYmxlIiwiTGFicy5WaWV3IiwiTGFicy5BZGRFZGl0IiwiTGFicy5EaXNhYmxlRW5hYmxlIiwiU2FtcGxlcy5WaWV3IiwiU2FtcGxlcy5BZGRFZGl0IiwiU2FtcGxlcy5EaXNhYmxlRW5hYmxlIiwiU2FtcGxlcy5EZWxldGUiLCJSZWNvcmRzLlZpZXciLCJCYXJjb2RlLkFkZCIsIlRyYW5zYWN0aW9ucy5WaWV3IiwiVHJhbnNhY3Rpb25zLkRpc2FibGVFbmFibGUiLCJUcmFuc2FjdGlvbnMuQWRkRWRpdCIsIlNhbXBsZVR5cGVzLlZpZXciLCJTYW1wbGVUeXBlcy5BZGRFZGl0IiwiU2FtcGxlVHlwZXMuRGlzYWJsZUVuYWJsZSIsIkxhYlJlcG9ydEZvcm0uVmlldyIsIkZvb2RTYW1wbGVGb3JtLlZpZXciXSwidXNlcm5hbWUiOiJzdXBlclRlc3QiLCJzdWIiOiJzdXBlclRlc3QiLCJpYXQiOjE3MDc1Nzc1MjAsImV4cCI6MTc5Mzk3NzUyMH0.D5NpBGhG_YPBX8ZexFitV8ChRAm5orkfTPlAEdTJaMM");
        List<Long> notInserted = new ArrayList<>();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(sample.size());

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

    @PostMapping("attachment-transfer")
    public ResponseEntity<List<Long>> transferAttach(){
        List<Attachment> attachs=attachRepo.findAll();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoic3VwZXIgYWRtaW4iLCJjbGFpbXMiOlsiUm9sZS5WaWV3IiwiUm9sZS5BZGRFZGl0IiwiUm9sZS5EaXNhYmxlRW5hYmxlIiwiVXNlci5WaWV3IiwiVXNlci5BZGRFZGl0IiwiVXNlci5EaXNhYmxlRW5hYmxlIiwiU2FtcGxpbmdTaXRlcy5WaWV3IiwiU2FtcGxpbmdTaXRlcy5BZGRFZGl0IiwiU2FtcGxpbmdTaXRlcy5EaXNhYmxlRW5hYmxlIiwiTGFicy5WaWV3IiwiTGFicy5BZGRFZGl0IiwiTGFicy5EaXNhYmxlRW5hYmxlIiwiU2FtcGxlcy5WaWV3IiwiU2FtcGxlcy5BZGRFZGl0IiwiU2FtcGxlcy5EaXNhYmxlRW5hYmxlIiwiU2FtcGxlcy5EZWxldGUiLCJSZWNvcmRzLlZpZXciLCJCYXJjb2RlLkFkZCIsIlRyYW5zYWN0aW9ucy5WaWV3IiwiVHJhbnNhY3Rpb25zLkRpc2FibGVFbmFibGUiLCJUcmFuc2FjdGlvbnMuQWRkRWRpdCIsIlNhbXBsZVR5cGVzLlZpZXciLCJTYW1wbGVUeXBlcy5BZGRFZGl0IiwiU2FtcGxlVHlwZXMuRGlzYWJsZUVuYWJsZSIsIkxhYlJlcG9ydEZvcm0uVmlldyIsIkZvb2RTYW1wbGVGb3JtLlZpZXciXSwidXNlcm5hbWUiOiJzdXBlclRlc3QiLCJzdWIiOiJzdXBlclRlc3QiLCJpYXQiOjE3MDcyMjg3MTAsImV4cCI6MTc5MzYyODcxMH0.2dVM1Gc0hljJCw-4Yjm-4ufWqeIlMU72CXdpfsB6Ilc");
        List<Long> notInserted = new ArrayList<>();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        for (Attachment s : attachs) {
            DoraSample doraSample = null;
            try {
                doraSample= rpo.findById(s.getDoraSampleId()).orElse(null);
            }catch (Exception ex){
                notInserted.add(s.getId());
                continue;
            }


            try {
                String substringToRemove = "public/uploads/dora/";
                String image = doraSample.getImg().replace(substringToRemove,"");
                String name =doraSample.getName();
                name =  name.replace('-',' ');
                UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                        .queryParam("image",image)
                        .queryParam("name",name);
                String finalUrl = builder.build().toUriString();

                HttpEntity<Attachment> requestEntity = new HttpEntity<>(s, headers);
                restTemplate.exchange(finalUrl, HttpMethod.POST, requestEntity, Void.class);

            } catch (Exception e) {
                notInserted.add(s.getId());
                ResponseEntity.ok().body(notInserted);
            }
        }

        Long size = (long) notInserted.size();
        notInserted.add(size);
        return ResponseEntity.ok().body(notInserted);

    }

}
