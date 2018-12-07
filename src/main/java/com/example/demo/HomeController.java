package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public String index(Model model){
        Album album = new Album();
        album.setName("ye");
        album.setGenre("Hip Hop");

        Song song = new Song();
        song.setTitle("All Mine");
        song.setYear(2017);

        Set<Song> songs = new HashSet<Song>();
        songs.add(song);

        song = new Song();
        song.setTitle("Ghost Town");
        song.setYear(2017);
        songs.add(song);

        album.setSongs(songs);

        albumRepository.save(album);

        model.addAttribute("albums", albumRepository.findAll());
        return "index";

    }
}
