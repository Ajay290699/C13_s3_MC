package com.niit.C13_s3_MC.controller;

import com.niit.C13_s3_MC.domain.Track;
import com.niit.C13_s3_MC.exception.TrackNotFoundException;
import com.niit.C13_s3_MC.service.ITrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {

    ITrackService trackService;

    public TrackController(ITrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/track")
    public ResponseEntity<?> addTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.OK);
    }

    @GetMapping("/track")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<>(trackService.getAllTrack(),HttpStatus.OK);
    }

    @DeleteMapping("/track/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id){
        try {
            return new ResponseEntity<>(trackService.deleteTrack(id),HttpStatus.OK);
        } catch (TrackNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/track/{rating}")
    public ResponseEntity<?> gettrackByRating(@PathVariable double rating){
        return new ResponseEntity<>(trackService.getAllTrackByRating(rating),HttpStatus.OK);
    }

    @GetMapping("/tracks/{artistName}")
    public ResponseEntity<?> getTrackByArtistName(@PathVariable String artistName){
        return new ResponseEntity<>(trackService.getAllTrackByArtistName(artistName),HttpStatus.FOUND);
    }
}
