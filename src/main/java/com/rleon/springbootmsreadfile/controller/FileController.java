package com.rleon.springbootmsreadfile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rleon.springbootmsreadfile.bean.Inputs;
import com.rleon.springbootmsreadfile.util.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @GetMapping("/")
    public ResponseEntity<?> getValidations() throws IOException {
        Map<String, Object> response = new HashMap<>();
        File file = new File(this.getClass().getClassLoader().getResource("p1.json").getFile());

        ObjectMapper mapper = new ObjectMapper();
        Inputs inputs = mapper.readValue(file, Inputs.class);

        /** forma 1*/
//        inputs.getInputs().stream()
//                .map(s -> response.put(s, Utils.validateString(s)))
//                .collect(Collectors.toList());

        /**  forma 2 **/
        inputs.getInputs().forEach(s -> response.put(s, Utils.validateString(s)));


        return ResponseEntity.ok(response);
    }

}
