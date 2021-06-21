package com.watmap.server.controller;

import com.watmap.server.entity.dto.FacultyDto;
import com.watmap.server.entity.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @PostMapping
    public ResponseEntity<UserDto> addFaculty(@RequestBody final UserDto userDto){
        if (userDto.getPassword().equals("Abba321") && userDto.getLogin().equals("admin"))
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        return new ResponseEntity<>(userDto, HttpStatus.FORBIDDEN);
    }
}
