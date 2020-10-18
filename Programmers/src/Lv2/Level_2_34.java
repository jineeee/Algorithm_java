package Lv2;

import java.util.*;

public class Level_2_34 {

	static class Song implements Comparable<Song> {
		int idx, play;
		String genre;

		public Song(int idx, int play, String genre) {
			this.idx = idx;
			this.play = play;
			this.genre = genre;
		}

		@Override
		public int compareTo(Song song) {
			if (song.play == play)
				return Integer.compare(idx, song.idx);
			return Integer.compare(song.play, play);
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		HashMap<Integer, String> genMap = new HashMap(); // 장르 idx 저장
		HashMap<String, Integer> plCnt = new HashMap(); // 장르 재생 횟수 저장
		Song[] songs = new Song[plays.length]; // 노래 정보 저장

		for (int i = 0; i < genres.length; i++) {
			songs[i] = new Song(i, plays[i], genres[i]);
			genMap.put(i, genres[i]);
			plCnt.put(genres[i], plCnt.getOrDefault(genres[i], 0) + plays[i]);
		}
		Arrays.sort(songs);

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(plCnt.entrySet());
		Collections.sort(entries, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
		ArrayList<String> sortList = new ArrayList<String>();
		for (Map.Entry<String, Integer> e : entries)
			sortList.add(e.getKey());

		ArrayList<Integer> tempAns = new ArrayList<Integer>();
		for (int i = 0; i < sortList.size(); i++) {
			String g = sortList.get(i);
			int cnt = 0;
			for (int j = 0; j < songs.length; j++) {
				if (cnt == 2)
					break;
				if (g.equals(songs[j].genre)) {
					tempAns.add(songs[j].idx);
					cnt++;
				}
			}
		}

		int[] answer = new int[tempAns.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = tempAns.get(i);
		return answer;
	}
}
