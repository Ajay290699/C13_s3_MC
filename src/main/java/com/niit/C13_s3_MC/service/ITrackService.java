package com.niit.C13_s3_MC.service;

import com.niit.C13_s3_MC.domain.Track;
import com.niit.C13_s3_MC.exception.TrackNotFoundException;

import java.util.List;

public interface ITrackService {

    public Track addTrack(Track track);
    public List<Track>getAllTrack();
    public String deleteTrack(int id) throws TrackNotFoundException;

    public List<Track> getAllTrackByRating(double rating);

    public List<Track> getAllTrackByArtistName(String artistName);
}
