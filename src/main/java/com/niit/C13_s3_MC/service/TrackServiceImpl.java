package com.niit.C13_s3_MC.service;

import com.niit.C13_s3_MC.domain.Track;
import com.niit.C13_s3_MC.exception.TrackNotFoundException;
import com.niit.C13_s3_MC.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements ITrackService{

    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track addTrack(Track track) {
        if (trackRepository.findById(track.getTrackId()).isEmpty()){
            return trackRepository.save(track);
        }
        return null;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public String deleteTrack(int id) throws TrackNotFoundException {
        if (trackRepository.findById(id).isEmpty()){
            throw new TrackNotFoundException();
        }
        return "Track Deleted Successfully";
    }

    @Override
    public List<Track> getAllTrackByRating(double rating) {
        return trackRepository.getAllTrackByRating(rating);
    }

    @Override
    public List<Track> getAllTrackByArtistName(String artistName) {
        return trackRepository.getAllTrackByArtistName(artistName);
    }
}
