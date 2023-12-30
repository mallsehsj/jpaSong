/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.*;
import com.example.song.model.*;

@Service
public class SongJpaService implements SongRepository {

      @Autowired
      private SongJpaRepository songjparepository;

      @Override
      public ArrayList<Song> getSongs() {
            List<Song> list = songjparepository.findAll();
            ArrayList<Song> arraylist = new ArrayList<>(list);
            return arraylist;
      }

      @Override
      public Song addSong(Song song) {
            songjparepository.save(song);
            return song;
      }

      @Override
      public Song getById(int songId) {
            try {
                  Song song5 = songjparepository.findById(songId).get();
                  return song5;

            } catch (Exception e) {
                  throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            }

      }

      @Override
      public Song updateSong(int songId, Song song) {
            try {
                  Song song1 = songjparepository.findById(songId).get();
                  if (song.getSongName() != null) {
                        song1.SetSongName(song.getSongName());

                  }
                  if (song.getLyricist() != null) {
                        song1.SetLyricist(song.getLyricist());
                  }
                  if (song.getSinger() != null) {
                        song1.setSinger(song.getSinger());
                  }
                  if (song.getMusicDirector() != null) {
                        song1.SetMusicDirector(song.getMusicDirector());

                  }
                  return song1;

            } catch (Exception e) {
                  throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            }

      }

      @Override
      public void deleteSong(int songId) {
            try {
                  songjparepository.deleteById(songId);

            } catch (Exception e) {
                  throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            }

      }

}
