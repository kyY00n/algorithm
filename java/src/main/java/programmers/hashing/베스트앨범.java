package programmers.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Album>> genreToAlbums = new HashMap<>();
        List<String> genresOrder = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            if (!genreToAlbums.containsKey(genres[i])) {
                genresOrder.add(genres[i]);
                genreToAlbums.put(genres[i], new ArrayList<>());
            }
            List<Album> albums = genreToAlbums.get(genres[i]);
            albums.add(new Album(genres[i], plays[i], i));
        }
        Map<String, Integer> genreToPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) { // iterate through the albums
            if (!genreToPlays.containsKey(genres[i])) {
                genreToPlays.put(genres[i], plays[i]);
                continue;
            }
            genreToPlays.put(genres[i], genreToPlays.get(genres[i]) + plays[i]);
        }
        // genresOrder 정렬 먼저
        Collections.sort(genresOrder,
                (genre1, genre2) -> genreToPlays.getOrDefault(genre2, 0) - genreToPlays.getOrDefault(genre1, 0));

        List<Integer> answer = new ArrayList<>();

        for (String genre : genresOrder) {
            List<Album> genreAlbums = genreToAlbums.get(genre);
            Collections.sort(genreAlbums, (album1, album2) -> {
                if (album1.play == album2.play) {
                    return album1.index - album2.index;
                }
                return album2.play - album1.play;
            });
            answer.add(genreAlbums.get(0).index);
            if (genreAlbums.size() == 1) { // 장르에 곡이 한 개일 경우 예외처리
                continue;
            }
            answer.add(genreAlbums.get(1).index);
        }

        int[] answers = new int[answer.size()]; // List to int[]
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answer.get(i);
        }
        return answers;
    }

}

class Album {

    public String genre;
    public int play;
    public int index;

    public Album(String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }

}
