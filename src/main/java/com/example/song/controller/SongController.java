/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.service.*;
import com.example.song.model.*;

@RestController

public class SongController {

   @Autowired
   private SongJpaService songjpaservice;

   @GetMapping("/songs")
   public ArrayList<Song> getSongs() {
      return songjpaservice.getSongs();
   }

   @PostMapping("/songs")
   public Song addSong(Song song) {
      return songjpaservice.addSong(song);
   }

   @GetMapping("/songs/{songId}")
   public Song getById(@PathVariable("songId") int songId) {
      return songjpaservice.getById(songId);
   }

   @PutMapping("/songs/{songId}")
   public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song) {
      return songjpaservice.updateSong(songId, song);
   }

   @DeleteMapping("/songs/{songId}")
   public void deleteSong(@PathVariable("songId") int songId) {
      songjpaservice.deleteSong(songId);

   }

}
