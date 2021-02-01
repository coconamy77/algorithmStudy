package programmers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MusicG{
    int id;
    int plays;
    
    public MusicG(int id, int plays){
        this.id = id;
        this.plays = plays;
    }
}

class Genre{
	MusicG[] musics;
    int countM;
    int plays;
    int minM;
    public Genre(MusicG music){
        this.countM = 0;
        musics = new MusicG[2];
        musics[this.countM++] = music;
        this.plays = music.plays;
        this.minM = 0;
    }
    
    public int newMusic(MusicG music){
    	this.plays += music.plays;
        if(this.countM<2){
            musics[this.countM++] = music;
            if(musics[0].plays>=music.plays) {
            	minM = 1;
            }
            return 1;
        }else{
        	if(musics[minM].plays<music.plays) {
        		musics[minM] = music;
        		if(musics[(minM+1)%2].plays<music.plays) {
        			minM = (minM+1)%2;
        		}
            }
        }
        return 0;
    }
}

class Solution_베스트앨범 {
	public int[] solution(String[] genres, int[] plays) {
		int count = 0;
		
		Map<String, Genre> map = new HashMap<String, Genre>();
		Genre g;
		for (int i = 0; i<genres.length; i++) {
			MusicG music = new MusicG(i, plays[i]);
			if(!map.containsKey(genres[i])) {
				g = new Genre(music);
				map.put(genres[i], g);
				count++;
			}else {
				count += map.get(genres[i]).newMusic(music);
			}
		}
		
		List<Map.Entry<String, Genre>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Genre>>() {
			@Override
			public int compare(Entry<String, Genre> o1, Entry<String, Genre> o2) {
				return (o1.getValue().plays-o2.getValue().plays)*-1;
			}
		});
		
		int[] answer = new int[count];
		int idx = 0;
		for(Map.Entry<String, Genre> m: list) {
			Genre gg = m.getValue();
			if(gg.countM>=2) {
				answer[idx++] = gg.musics[(gg.minM+1)%2].id;
			}
			answer[idx++] = gg.musics[gg.minM].id;
		}
		
		
		return answer;
	}
	public static void main(String[] args) {
		Solution_베스트앨범 s = new Solution_베스트앨범();
		s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[] {500, 600, 150, 800, 2500});
	}
}
